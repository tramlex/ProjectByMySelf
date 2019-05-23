package restControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import database.auto.service.AutoService;
import database.person.service.PersonService;
import model.CarModel;
import model.PersonModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@WebAppConfiguration
public class PersonWithCarsTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private PersonService personService;
    @Autowired
    private AutoService autoService;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        autoService.clearAuto();
        personService.clearPerson();
    }

    @Test
    public void getPersonWithCarsTest() throws Exception {

        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("10.10.2000");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(personModel);

        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(requestJson).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        CarModel carModel = new CarModel();
        carModel.setId((long)1);
        carModel.setOwnerId(1);
        carModel.setHorsepower(100);
        carModel.setModel("BMW-3");

        ObjectMapper objectMapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonCar = objectWriter.writeValueAsString(carModel);

        mockMvc.perform(post("/car").contentType(MediaType.APPLICATION_JSON).content(jsonCar).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String uri = "/personwithcars";
        String id = "1";

        mockMvc.perform(get(uri).param("personid", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Alex")))
                .andExpect(jsonPath("$.birthdate", is("10.10.2000")))
                .andExpect(jsonPath("$.cars[0].model",is("BMW-3")))
                .andExpect(status().isOk());

    }

    @Test
    public void getPersonWithCarsNotFoundTest() throws Exception{
        String uri = "/personwithcars";
        String id = "-1";

        mockMvc.perform(get(uri).param("personid", id))
                .andExpect(status().is(404));
    }

}