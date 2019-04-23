package database.person.dao;

import database.entities.PersonEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void savePerson(String name, Date date) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(name);
        personEntity.setBirthdate(date);
        this.sessionFactory.getCurrentSession().save(personEntity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonEntity> getAllPerson() {
        List<PersonEntity> personEntities = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM PERSON").addEntity(PersonEntity.class).list();
        return personEntities;
    }
}
