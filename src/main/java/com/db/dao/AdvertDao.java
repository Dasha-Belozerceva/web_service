package com.db.dao;
import com.db.conf.MyAppInitializer;
import com.db.model.Advert;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdvertDao implements IAdvertDao{
    @Override
    public Advert getAdvert(int id) {
        Connection connection = MyAppInitializer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + id);

            Advert advert = null;
            while (rs.next()) {
                advert = new Advert();
                advert.setId(rs.getInt(1));
                advert.setPerson_id(rs.getInt(2));
                advert.setHead(rs.getString(3));
                advert.setBody(rs.getString(4));
                advert.setPhone_number(rs.getString(5));
                advert.setCategory(rs.getString(6));
                advert.setDate_of_creation(rs.getTimestamp(7).toLocalDateTime());
            }
            return advert;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Advert> getAllAdverts() {
        List<Advert> allAdverts = new ArrayList<Advert>();
        Connection connection = MyAppInitializer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            while(rs.next()){
                Advert advert = new Advert();
                advert.setId(rs.getInt(1));
                advert.setPerson_id(rs.getInt(2));
                advert.setHead(rs.getString(3));
                advert.setBody(rs.getString(4));
                advert.setPhone_number(rs.getString(5));
                advert.setCategory(rs.getString(6));
                advert.setDate_of_creation(rs.getTimestamp(7).toLocalDateTime());
                allAdverts.add(advert);
            }
            return allAdverts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Advert> getAdvertsByPersonID(int person_id) {
        List<Advert> adverts = new ArrayList<Advert>();
        Connection connection = MyAppInitializer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE person_id=" + person_id);

            Advert advert = null;
            while (rs.next()) {
                advert = new Advert();
                advert.setId(rs.getInt(1));
                advert.setPerson_id(rs.getInt(2));
                advert.setHead(rs.getString(3));
                advert.setBody(rs.getString(4));
                advert.setPhone_number(rs.getString(5));
                advert.setCategory(rs.getString(6));
                advert.setDate_of_creation(rs.getTimestamp(7).toLocalDateTime());
                adverts.add(advert);
            }
            return adverts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addAdvert(Advert advert) {
        Connection connection = MyAppInitializer.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO advert" +
                    "(person_id, head, body, category, phone_number, date_of_creation) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, advert.getPerson_id());
            ps.setString(2, advert.getHead());
            ps.setString(3, advert.getBody());
            ps.setString(4, advert.getCategory());
            ps.setString(5, advert.getPhone_number());
            ps.setTimestamp(6, Timestamp.valueOf(advert.getDate_of_creation()));
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
    public boolean editAdvert(Advert advert, int id) {
        Connection connection = MyAppInitializer.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE advert SET " +
                    "head=?, body=?, category=?, phone_number=? WHERE id=?");
            ps.setString(1, advert.getHead());
            ps.setString(2, advert.getBody());
            ps.setString(3, advert.getPhone_number());
            ps.setString(4, advert.getCategory());
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
    public boolean deleteAdvert(int id) {
        Connection connection = MyAppInitializer.getConnection();
        try{
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM advert WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
