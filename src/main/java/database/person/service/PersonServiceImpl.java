package database.person.service;

import database.entities.PersonEntity;
import database.person.dao.PersonDao;
import model.PersonModel;
import model.PersonWithCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public boolean savePerson(PersonModel personModel) {
        if (personDao.savePerson(personModel) == true) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public PersonWithCars getPersonByID(long id){
        return personDao.getPersonByID(id);
    }

    @Override
    @Transactional
    public void clearPerson() {
        personDao.clearPerson();
    }

}
