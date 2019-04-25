package database.person.service;

import database.entities.PersonEntity;
import model.PersonModel;

import java.sql.Date;
import java.util.List;

public interface PersonService {
    public void savePerson(PersonModel personModel);

    public List<PersonEntity> getAllPerson();

    public void clearPerson();
}
