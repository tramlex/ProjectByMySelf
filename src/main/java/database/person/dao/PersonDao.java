package database.person.dao;

import database.entities.PersonEntity;
import model.PersonModel;

import java.util.List;

public interface PersonDao {
    public boolean savePerson(PersonModel personModel);

    public List<PersonEntity> getAllPerson();

    public void clearPerson();
}
