package database.auto.dao;

import database.entities.AutoEntity;
import database.entities.PersonEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoDaoImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAuto(String model, Integer horsepower, Long ownerId) {

        AutoEntity autoEntity = new AutoEntity();
        autoEntity.setModel(model);
        autoEntity.setHorsepower(horsepower);
        PersonEntity personEntity = sessionFactory.getCurrentSession().find(PersonEntity.class,ownerId);
        autoEntity.setPersonEntity(personEntity);
        this.sessionFactory.getCurrentSession().saveOrUpdate(autoEntity);
    }

}
