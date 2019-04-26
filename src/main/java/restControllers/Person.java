package restControllers;


import database.person.service.PersonService;
import model.PersonModel;
import model.PersonModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Person {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonModelDao personModelDao;

    @RequestMapping(value = "/person" , method = RequestMethod.POST , produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
    public PersonModel savePerson(@RequestBody PersonModel personModel) {
        personModelDao.addPerson(personModel);
        //personService.savePerson(personModel);
        return personModel;
    }
}
