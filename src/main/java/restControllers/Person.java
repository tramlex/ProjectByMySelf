package restControllers;


import database.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class Person {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    protected String savePerson(@RequestParam(name = "name") String name, @RequestParam(name = "date") Date birthdate) {

        personService.savePerson(name, birthdate);
        return "redirect:person.jsp";
    }
}
