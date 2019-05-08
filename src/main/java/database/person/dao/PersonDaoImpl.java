package database.person.dao;

import database.entities.PersonEntity;
import model.PersonModel;
import model.PersonWithCars;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import restControllers.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean savePerson(PersonModel personModel) {
        PersonEntity personEntity = new PersonEntity();

        if (personModel.getName() == null) {
            return false;
        }
        personEntity.setId(personModel.getId());

        if (sessionFactory.getCurrentSession().find(PersonEntity.class, personModel.getId()) != null) {
            return false;
        }
        personEntity.setName(personModel.getName());

        if (personModel.getBirthdate().after(new Date(System.currentTimeMillis()))) {
            return false;
        }
        personEntity.setBirthdate(personModel.getBirthdate());

        sessionFactory.getCurrentSession().save(personEntity);
        return true;
    }

    @Override
    public PersonWithCars getPersonByID(long id){
        PersonWithCars personWithCars = new PersonWithCars();

        personWithCars.setId(id);

        personWithCars.setBirthdate(sessionFactory.getCurrentSession().find(PersonEntity.class,id).getBirthdate());
        personWithCars.setName(sessionFactory.getCurrentSession().find(PersonEntity.class,id).getName());

        List<String> cars = sessionFactory.getCurrentSession().createSQLQuery("SELECT MODEL FROM AUTO where OWNERID=" + id).list();
        personWithCars.setCars(cars.toArray(new String[0]));

        return personWithCars;
    }

    @Override
    public void clearPerson() {
        this.sessionFactory.getCurrentSession().createQuery("delete from PersonEntity").executeUpdate();
    }
}
