package restControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import database.person.service.PersonService;
import model.PersonModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@WebAppConfiguration
public class PersonTest {


//    @Mock
////    private PersonService personService;
////
////    @InjectMocks
////    private Person person;
////
////
////
////    @Before
////    public void init() {
////        MockitoAnnotations.initMocks(this);
////        mockMvc = MockMvcBuilders.standaloneSetup(person).build();
////    }

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PersonService personService;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void savePersonTest() throws Exception {

        personService.clearPerson();

        String uri = "/person";
        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("10.10.2000");

//        Gson gson = new Gson();
//        String json = gson.toJson(personModel);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(personModel);

        System.out.println(requestJson);

        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
