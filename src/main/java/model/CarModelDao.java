package model;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarModelDao {
    private static final Map<String, CarModel> carModelMap = new HashMap<String, CarModel>();

    static {
        initCars();
    }

    private static void initCars(){
        CarModel car1 = new CarModel(1,"BMW",1,1);
        CarModel car2 = new CarModel(2,"MERS",1,2);
        CarModel car3 = new CarModel(3,"KIA",1,3);

        carModelMap.put(car1.getModel(),car1);
        carModelMap.put(car2.getModel(),car2);
        carModelMap.put(car3.getModel(),car3);
    }

}
