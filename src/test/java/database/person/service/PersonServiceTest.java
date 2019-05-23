package database.person.service;

import database.auto.service.AutoService;
import model.PersonModel;
import model.PersonWithCars;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@WebAppConfiguration
public class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private AutoService autoService;

    @Before
    public void setup() throws Exception{
        autoService.clearAuto();
        personService.clearPerson();
        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("10.10.2000");
        personService.savePerson(personModel);

    }

    @Test
    public void savePersonTest() throws Exception{
        personService.clearPerson();
        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("10.10.2000");
        Boolean result = personService.savePerson(personModel);
        assertEquals(true,result);
    }

    @Test
    public void getPersonByIDTest() {
        PersonWithCars result = personService.getPersonByID(1);
        PersonWithCars personWithCars = new PersonWithCars();
        personWithCars.setName("Alex");
        personWithCars.setId(1);
        personWithCars.setBirthdate("10.10.2000");
        assertEquals(personWithCars.getId(),result.getId());
        assertEquals(personWithCars.getName(),result.getName());
        assertEquals(personWithCars.getBirthdate(),result.getBirthdate());

    }

    @Test
    public void checkForPersonTest() {
        Boolean result = personService.checkForperson(1);
        assertEquals(true,result);
    }

}