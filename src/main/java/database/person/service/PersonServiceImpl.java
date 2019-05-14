package database.person.service;

import database.entities.PersonEntity;
import database.person.dao.PersonDao;
import model.PersonModel;
import model.PersonWithCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public boolean savePerson(PersonModel personModel) throws ParseException {
        if (personDao.savePerson(personModel) == true) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean checkForperson(long personid) {
        return personDao.checkForperson(personid);
    }

    @Override
    @Transactional
    public PersonWithCars getPersonByID(long id) {
        return personDao.getPersonByID(id);
    }

    @Override
    @Transactional
    public void clearPerson() {
        personDao.clearPerson();
    }

}
