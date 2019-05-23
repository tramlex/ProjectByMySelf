package restControllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import database.auto.service.AutoService;
import model.CarModel;
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
public class CarTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AutoService autoService;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        autoService.clearAuto();
    }

    @Test
    public void saveCarTest() throws Exception {

        String uri = "/car";
        String id = "1";
        CarModel carModel = new CarModel();
        carModel.setId((long)1);
        carModel.setOwnerId(1);
        carModel.setHorsepower(100);
        carModel.setModel("BMW-3");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(carModel);

        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/personwithcars").param("personid", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Alex")))
                .andExpect(jsonPath("$.birthdate", is("10.10.2000")))
                .andExpect(jsonPath("$.cars[0].model",is("BMW-3")))
                .andExpect(status().isOk());

    }

    @Test
    public void saveNotValidateCarTest() throws Exception{

        String uri = "/car";
        String id = "1";
        CarModel carModel = new CarModel();
        carModel.setId((long)1);
        carModel.setOwnerId(1);
        carModel.setHorsepower(100);
        carModel.setModel("--BMW-3");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(carModel);

        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

}