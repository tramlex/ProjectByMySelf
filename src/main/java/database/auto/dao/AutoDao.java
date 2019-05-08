package database.auto.dao;

import model.CarModel;
import model.Statistics;


public interface AutoDao {
    public boolean saveAuto(CarModel carModel);

    public Statistics getStatistics();

    public void clearAuto();
}
