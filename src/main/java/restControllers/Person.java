package restControllers;


import database.person.service.PersonService;
import model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
public class Person {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/person")
    public ResponseEntity savePerson(@RequestBody PersonModel personModel) throws ParseException {


        if (personService.savePerson(personModel) == false) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
