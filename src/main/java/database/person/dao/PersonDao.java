package database.person.dao;

import database.entities.PersonEntity;

import java.sql.Date;
import java.util.List;

public interface PersonDao {
    public void savePerson(String name, Date date);

    public List<PersonEntity> getAllPerson();

    public void clearPerson();
}
