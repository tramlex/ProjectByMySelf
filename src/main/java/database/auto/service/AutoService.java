package database.auto.service;

import model.CarModel;

public interface AutoService {
    public void saveAuto(CarModel carModel);
    public void clearAuto();
}
