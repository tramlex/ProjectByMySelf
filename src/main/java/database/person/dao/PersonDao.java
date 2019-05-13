package database.person.dao;

import model.PersonModel;
import model.PersonWithCars;

import java.text.ParseException;

public interface PersonDao {
    public boolean savePerson(PersonModel personModel) throws ParseException;

    public PersonWithCars getPersonByID(long id);

    public boolean checkForperson(long personid);

    public void clearPerson();
}
