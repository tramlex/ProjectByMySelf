package database.auto.service;

import model.CarModel;
import model.Statistics;

public interface AutoService {
    public boolean saveAuto(CarModel carModel);

    public Statistics getStatistics();

    public void clearAuto();
}
