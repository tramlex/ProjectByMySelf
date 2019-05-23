package database.auto.service;

import database.person.service.PersonService;
import model.CarModel;
import model.PersonModel;
import model.Statistics;
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
public class AutoServiceTest {

    @Autowired
    private AutoService autoService;
    @Autowired
    private PersonService personService;


    @Before
    public void setup() throws Exception{
        autoService.clearAuto();
        personService.clearPerson();
        PersonModel personModel = new PersonModel();
        personModel.setId((long) 1);
        personModel.setName("Alex");
        personModel.setBirthdate("10.10.2000");
        personService.savePerson(personModel);
        CarModel carModel = new CarModel();
        carModel.setId((long)1);
        carModel.setOwnerId(1);
        carModel.setHorsepower(100);
        carModel.setModel("BMW-3");
        autoService.saveAuto(carModel);

    }

    @Test
    public void saveAutoTest() {
        autoService.clearAuto();
        CarModel carModel = new CarModel();
        carModel.setId((long)1);
        carModel.setOwnerId(1);
        carModel.setHorsepower(100);
        carModel.setModel("BMW-3");
        Boolean result = autoService.saveAuto(carModel);
        assertEquals(true,result);
    }

    @Test
    public void getStatisticsTest() {
        Statistics result  = autoService.getStatistics();
        Statistics statistics = new Statistics();
        statistics.setCarcount(1);
        statistics.setPersoncount(1);
        statistics.setUniquevendorcount(1);
        assertEquals(statistics.getCarcount(),result.getCarcount());
        assertEquals(statistics.getUniquevendorcount(),result.getUniquevendorcount());
        assertEquals(statistics.getPersoncount(),result.getPersoncount());

    }
}