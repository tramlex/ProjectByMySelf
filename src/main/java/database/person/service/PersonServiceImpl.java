package database.person.service;

import database.entities.PersonEntity;
import database.person.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public void savePerson(String name, Date date) {
        personDao.savePerson(name, date);
    }

    @Override
    @Transactional
    public List<PersonEntity> getAllPerson() {
        return personDao.getAllPerson();
    }
}
