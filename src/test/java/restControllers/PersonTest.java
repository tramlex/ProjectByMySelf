package restControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import database.person.service.PersonService;
import model.PersonModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*: resources/*.xml")
@WebAppConfiguration
public class PersonTest {


    private MockMvc mockMvc;

    @Mock
    private PersonService personService;

    @InjectMocks
    private Person person;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(person).build();
    }

    @Test
    public void savePersonTest() throws Exception {

        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("01.01.2000");
        //person.savePerson(personModel);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(personModel);

        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is(200));

               // .andExpect(jsonPath("$[0].id",is(1)))
               // .andExpect(jsonPath("$[0].name",is("Alex")))
               // .andExpect(jsonPath("$[0].birthdate",is("11.12.1990")));

    }
}
