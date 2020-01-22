package com.db.service;

import com.db.dao.IPersonDao;
import com.db.model.Person;

import java.sql.SQLException;
import javax.inject.Inject;
import java.util.List;


public class PersonService implements IPersonService {
    @Inject
    private IPersonDao personDao;

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public Person getPerson(int id) {
        return personDao.getPerson(id);
    }

    @Override
    public boolean insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Override
    public boolean editPerson(Person person, int id) {
        return personDao.editPerson(person, id);
    }

    @Override
    public boolean deletePerson(int id) throws SQLException {
        return personDao.deletePerson(id);
    }

    @Override
    public int getID(Person person) {
        return personDao.getID(person);
    }
}
