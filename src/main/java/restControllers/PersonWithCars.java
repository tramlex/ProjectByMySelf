package restControllers;

import database.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class PersonWithCars {
    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/personwithcars", method = RequestMethod.GET ,  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getPersonWithCars(@RequestParam long personid) {


        if(personService.checkForperson(personid)== false){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK).ok(personService.getPersonByID(personid));
    }

}
