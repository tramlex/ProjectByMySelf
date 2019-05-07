package restControllers;

import database.auto.service.AutoService;
import model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Car {
    @Autowired
    private AutoService autoService;

    @PostMapping(value = "/car")
    public ResponseEntity saveAuto(@RequestBody CarModel carModel) {

        if (autoService.saveAuto(carModel) == false) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
