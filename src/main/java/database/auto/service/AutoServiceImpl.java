package database.auto.service;

import database.auto.dao.AutoDao;
import model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AutoServiceImpl implements AutoService {
    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional
    public void saveAuto(CarModel carModel) {
        autoDao.saveAuto(carModel);
    }

    @Override
    @Transactional
    public void clearAuto() {
        autoDao.clearAuto();
    }
}
