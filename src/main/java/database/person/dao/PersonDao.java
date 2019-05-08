package database.person.dao;

import model.PersonModel;
import model.PersonWithCars;

public interface PersonDao {
    public boolean savePerson(PersonModel personModel);

    public PersonWithCars getPersonByID(long id);

    public void clearPerson();
}
