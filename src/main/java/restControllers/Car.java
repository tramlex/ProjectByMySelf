package restControllers;

import database.auto.service.AutoService;
import model.CarModel;
import model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Car {
    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/Car", method = RequestMethod.POST)
    protected String saveAuto(@RequestBody CarModel carModel) {

        autoService.saveAuto(carModel);
        return "";
    }
}
