package restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {
    @Autowired

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    protected String saveAuto(){

        return "";
    }
}
