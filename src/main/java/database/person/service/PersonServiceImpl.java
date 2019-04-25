package database.person.service;

import database.entities.PersonEntity;
import database.person.dao.PersonDao;
import model.PersonModel;
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
    public void savePerson(PersonModel personModel) {
        personDao.savePerson(personModel);
    }

    @Override
    @Transactional
    public List<PersonEntity> getAllPerson() {
        return personDao.getAllPerson();
    }

    @Override
    @Transactional
    public void clearPerson() {
      personDao.clearPerson();
    }

}
