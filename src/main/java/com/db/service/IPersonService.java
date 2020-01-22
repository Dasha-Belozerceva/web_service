package com.db.service;

import com.db.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface IPersonService {
    public List<Person> getAllPersons();
    public Person getPerson(int id);
    public boolean insertPerson(Person person);
    public boolean editPerson(Person person, int id);
    public boolean deletePerson(int id) throws SQLException;
    public int getID(Person person);
}
