package database.auto.dao;

import model.CarModel;

public interface AutoDao {
    public void saveAuto(CarModel carModel);
    public void clearAuto();
}
