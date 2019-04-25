package database.auto.dao;

import database.entities.AutoEntity;
import database.entities.PersonEntity;
import model.CarModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoDaoImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAuto(CarModel carModel) {

        AutoEntity autoEntity = new AutoEntity();
        autoEntity.setId(carModel.getId());
        autoEntity.setModel(carModel.getModel());
        autoEntity.setHorsepower(carModel.getHorsepower());
        PersonEntity personEntity = sessionFactory.getCurrentSession().find(PersonEntity.class,carModel.getOwnerId());
        autoEntity.setPersonEntity(personEntity);
        this.sessionFactory.getCurrentSession().saveOrUpdate(autoEntity);
    }

    @Override
    public void clearAuto(){
        this.sessionFactory.getCurrentSession().createSQLQuery("TRUNCATE table AUTO");
}

}
