package restControllers;

import database.auto.service.AutoService;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;


@RestController
public class Statistics {

    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/statistics" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public model.Statistics savePerson() {

        return autoService.getStatistics();
    }
}
