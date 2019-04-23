package restControllers;

import database.auto.service.AutoService;
import database.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Clear {
    @Autowired
    private AutoService autoService;
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/clear" , method = RequestMethod.GET)
    protected String clearData(){
    autoService.clearAuto();
    personService.clearPerson();
    return "";
    }

}
