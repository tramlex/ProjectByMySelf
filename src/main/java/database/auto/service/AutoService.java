package database.auto.service;

import model.CarModel;

public interface AutoService {
    public boolean saveAuto(CarModel carModel);

    public void clearAuto();
}
