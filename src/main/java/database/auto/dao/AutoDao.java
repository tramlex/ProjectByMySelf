package database.auto.dao;

import model.CarModel;


public interface AutoDao {
    public boolean saveAuto(CarModel carModel);

    public void clearAuto();
}
