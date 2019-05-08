package restControllers;

import database.auto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Statistics {

    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/statistics" , method = RequestMethod.GET)
    public model.Statistics savePerson() {

        return autoService.getStatistics();
    }
}
