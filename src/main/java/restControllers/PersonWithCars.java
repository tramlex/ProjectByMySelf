package restControllers;

import database.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class PersonWithCars {
    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/personwithcars?personid={id}", method = RequestMethod.GET)
    @ResponseBody
    public model.PersonWithCars getPersonWithCars(@PathVariable final long id) {
        return personService.getPersonByID(id);
    }

}
