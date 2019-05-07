package database.auto.dao;

import database.entities.AutoEntity;
import database.entities.PersonEntity;
import model.CarModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;


@Repository
public class AutoDaoImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveAuto(CarModel carModel) {
        AutoEntity autoEntity = new AutoEntity();
        if (sessionFactory.getCurrentSession().find(AutoEntity.class, carModel.getId()) != null) {
            System.out.println("Ошибка ID");
            return false;
        }
        autoEntity.setId(carModel.getId());


        if (carModel.getModel().charAt(0) == ' ' || carModel.getModel().charAt(0) == '-' || carModel.getModel().indexOf(" " + 1) == ' ') {
            System.out.println("Ошибка MODEl");
            return false;
        }
        autoEntity.setModel(carModel.getModel());

        if (carModel.getHorsepower() <= 0) {
            System.out.println("Ошибка Horse");
            return false;
        }
        autoEntity.setHorsepower(carModel.getHorsepower());

        //||sessionFactory.getCurrentSession().find(PersonEntity.class, carModel.getOwnerId()).getBirthdate().after(new Date(System.currentTimeMillis() - 31556926000L)) == false
        if(sessionFactory.getCurrentSession().find(PersonEntity.class,carModel.getOwnerId())==null){
            return false;
        }

        sessionFactory.getCurrentSession().save(autoEntity);
        return true;
    }

    @Override
    public void clearAuto() {
        this.sessionFactory.getCurrentSession().createSQLQuery("TRUNCATE table AUTO");
    }

}
