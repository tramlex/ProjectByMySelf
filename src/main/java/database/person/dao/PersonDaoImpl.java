package database.person.dao;

import database.entities.PersonEntity;
import model.PersonModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonEntity> getAllPerson() {
        List<PersonEntity> personEntities = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM PERSON").addEntity(PersonEntity.class).list();
        return personEntities;
    }

    @Override
    public void clearPerson() {
        this.sessionFactory.getCurrentSession().createSQLQuery("TRUNCATE TABLE PERSON");
    }
}
