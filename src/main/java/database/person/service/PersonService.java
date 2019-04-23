package database.person.service;

import database.entities.PersonEntity;

import java.sql.Date;
import java.util.List;

public interface PersonService {
    public void savePerson(String name, Date date);

    public List<PersonEntity> getAllPerson();
}
