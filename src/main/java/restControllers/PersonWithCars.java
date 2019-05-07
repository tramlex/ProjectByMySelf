package restControllers;

import database.entities.PersonEntity;
import database.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonWithCars {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/personwithcars?personid={id}" , method = RequestMethod.GET)
    public ResponseEntity<PersonEntity> getPersonWithCars(@PathVariable Long id){

    return new ResponseEntity(null,HttpStatus.OK);
    }
}
