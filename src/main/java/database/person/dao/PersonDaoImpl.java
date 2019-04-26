package database.person.dao;

import database.entities.PersonEntity;
import model.PersonModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void savePerson(PersonModel personModel) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personModel.getId());
        personEntity.setName(personModel.getName());
        personEntity.setBirthdate(personModel.getBirthdate());
        this.sessionFactory.getCurrentSession().save(personEntity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonEntity> getAllPerson() {
        List<PersonEntity> personEntities = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM PERSON").addEntity(PersonEntity.class).list();
        return personEntities;
    }

    @Override
    public void clearPerson(){
        this.sessionFactory.getCurrentSession().createSQLQuery("TRUNCATE TABLE PERSON");
    }
}
