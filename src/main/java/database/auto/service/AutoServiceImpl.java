package database.auto.service;

import database.auto.dao.AutoDao;
import model.CarModel;
import model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AutoServiceImpl implements AutoService {
    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional
    public boolean saveAuto(CarModel carModel) {
        if (autoDao.saveAuto(carModel) == true) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Statistics getStatistics() {
        return autoDao.getStatistics();
    }

    @Override
    @Transactional
    public void clearAuto() {
        autoDao.clearAuto();
    }
}
