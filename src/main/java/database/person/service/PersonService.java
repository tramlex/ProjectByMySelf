package database.person.service;

import database.entities.PersonEntity;
import model.PersonModel;
import model.PersonWithCars;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public interface PersonService {
    public boolean savePerson(PersonModel personModel) throws ParseException;

    public PersonWithCars getPersonByID(long id);

    public boolean checkForperson(long personid);

    public void clearPerson();
}
