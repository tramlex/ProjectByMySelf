package database.auto.dao;

import database.entities.AutoEntity;
import database.entities.PersonEntity;
import model.CarModel;
import model.Statistics;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class AutoDaoImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveAuto(CarModel carModel) {
        AutoEntity autoEntity = new AutoEntity();
        try {
            if (sessionFactory.getCurrentSession().find(AutoEntity.class, carModel.getId()) != null) {
                return false;
            }
            autoEntity.setId(carModel.getId());


            if (carModel.getModel().charAt(0) == ' ' || carModel.getModel().charAt(0) == '-' || carModel.getModel().indexOf(" " + 1) == ' ') {
                return false;
            }
            autoEntity.setModel(carModel.getModel());

            if (carModel.getHorsepower() <= 0) {
                return false;
            }
            autoEntity.setHorsepower(carModel.getHorsepower());


            Calendar birthdate = Calendar.getInstance();
            Calendar curenttime = Calendar.getInstance();
            birthdate.setTime(sessionFactory.getCurrentSession().find(PersonEntity.class, carModel.getOwnerId()).getBirthdate());
            curenttime.setTime(new Date(System.currentTimeMillis()));

            if (sessionFactory.getCurrentSession().find(PersonEntity.class, carModel.getOwnerId()) == null || (curenttime.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR)) < 18) {
                return false;
            }
            autoEntity.setOwnerId(carModel.getOwnerId());

            sessionFactory.getCurrentSession().save(autoEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Statistics getStatistics() {
        Statistics statistics = new Statistics();
        statistics.setPersoncount((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from PersonEntity ").uniqueResult());
        statistics.setCarcount((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from AutoEntity ").uniqueResult());

        List<String> models = sessionFactory.getCurrentSession().createQuery("select model from AutoEntity ").list();
        for (int i = 0; i < models.size(); i++) {
            models.set(i, models.get(i).toLowerCase().substring(0, models.get(i).toLowerCase().indexOf("-")));
        }
        Set<String> uniqueModels = new HashSet<String>(models);
        statistics.setUniquevendorcount(uniqueModels.size());
        return statistics;
    }

    @Override
    public void clearAuto() {
        this.sessionFactory.getCurrentSession().createQuery("delete from AutoEntity ").executeUpdate();
    }

}
