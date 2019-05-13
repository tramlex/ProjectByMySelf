package database.person.dao;

import database.entities.PersonEntity;
import model.PersonModel;
import model.PersonWithCars;
import org.h2.jdbc.JdbcSQLException;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.NestedServletException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean savePerson(PersonModel personModel) throws ParseException {
        PersonEntity personEntity = new PersonEntity();


        try {
            if (personModel.getName() == null) {
                return false;
            }
            personEntity.setName(personModel.getName());


            if (personModel.getId() == null) {
                return false;
            }
            personEntity.setId(personModel.getId());

            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
            dt.setLenient(false);
            if (dt.parse(personModel.getBirthdate()).after(new Date(System.currentTimeMillis()))) {
                return false;
            }
            personEntity.setBirthdate(dt.parse(personModel.getBirthdate()));

            sessionFactory.getCurrentSession().save(personEntity);
                
        } catch (Exception e) {
            return false;
        }
        return true;

    }


    @Override
    public PersonWithCars getPersonByID(long id) {
        PersonWithCars personWithCars = new PersonWithCars();

        personWithCars.setId(id);


        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");

        personWithCars.setBirthdate(dt.format(sessionFactory.getCurrentSession().find(PersonEntity.class, id).getBirthdate()));
        personWithCars.setName(sessionFactory.getCurrentSession().find(PersonEntity.class, id).getName());

        List<String> cars = sessionFactory.getCurrentSession().createSQLQuery("SELECT MODEL FROM AUTO where OWNERID=" + id).list();
        personWithCars.setCars(cars.toArray(new String[0]));

        return personWithCars;
    }

    @Override
    public boolean checkForperson(long personid) {
        try {
            if (sessionFactory.getCurrentSession().get(PersonEntity.class, personid).getId() == personid) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public void clearPerson() {
        this.sessionFactory.getCurrentSession().createQuery("delete from PersonEntity").executeUpdate();
    }
}
