package database.person.service;

import database.entities.PersonEntity;
import model.PersonModel;
import model.PersonWithCars;

import java.sql.Date;
import java.util.List;

public interface PersonService {
    public boolean savePerson(PersonModel personModel);

    public PersonWithCars getPersonByID(long id);

    public void clearPerson();
}
