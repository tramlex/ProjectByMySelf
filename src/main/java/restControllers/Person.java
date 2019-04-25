package restControllers;


import database.person.service.PersonService;
import model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Person {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/Person", method = RequestMethod.POST)
    public String savePerson(@RequestBody PersonModel personModel) {
        personService.savePerson(personModel);

        return "";
    }
}
