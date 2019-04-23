package restControllers;

import database.auto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {
    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/Car", method = RequestMethod.POST)
    protected String saveAuto(@RequestParam(name = "model") String model, @RequestParam(name = "horsepower") Integer horsepower, @RequestParam(name = "ownerId") Long ownerId) {

        autoService.saveAuto(model, horsepower, ownerId);
        return "redirect:car.jsp";
    }
}
