package com.db.dao;
import com.db.conf.MyAppInitializer;
import com.db.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonDao implements IPersonDao {
    @Override
    public List<Person> getAllPersons(){
        List<Person> allPersons = new ArrayList<Person>();
        Connection connection = MyAppInitializer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            while(rs.next()){
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setFirst_Name(rs.getString(2));
                person.setLast_Name(rs.getString(3));
                person.setEmail(rs.getString(4));
                person.setCategory(rs.getString(5));
                allPersons.add(person);
            }
            return allPersons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person getPerson(int id) {
        Connection connection = MyAppInitializer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + id);

            Person person = null;
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt(1));
                person.setFirst_Name(rs.getString(2));
                person.setLast_Name(rs.getString(3));
                person.setEmail(rs.getString(4));
                person.setCategory(rs.getString(5));
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertPerson(Person person) {
        Connection connection = MyAppInitializer.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO person (first_name, last_name, email, category)" + "VALUES (?, ?, ?, ?)");
            ps.setString(1, person.getFirst_Name());
            ps.setString(2, person.getLast_Name());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getCategory());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editPerson(Person person, int id) {
        Connection connection = MyAppInitializer.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE person SET first_name=?, last_name=?, email=?, category=? WHERE id=" + id);
            ps.setString(1, person.getFirst_Name());
            ps.setString(2, person.getLast_Name());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getCategory());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePerson(int id) throws SQLException {
        Connection connection = MyAppInitializer.getConnection();
        try{
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM person WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getID(Person person) {
        Connection connection = MyAppInitializer.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id FROM person WHERE first_name=? AND last_name=? AND email=?" +" AND category=?");
            ps.setString(1, person.getFirst_Name());
            ps.setString(2, person.getLast_Name());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getCategory());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}