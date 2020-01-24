package com.db.service;
import com.db.dao.AdvertDao;
import com.db.dao.IAdvertDao;
import com.db.model.Advert;

import java.sql.SQLException;
import java.util.List;

public class AdvertService implements IAdvertService{
    private IAdvertDao advertDao = new AdvertDao();

    @Override
    public Advert getAdvert(int id) {
        return advertDao.getAdvert(id);
    }

    @Override
    public List<Advert> getAllAdverts() {
        return advertDao.getAllAdverts();
    }

    @Override
    public List<Advert> getAdvertsByPersonID(int person_id) {
        return advertDao.getAdvertsByPersonID(person_id);
    }

    @Override
    public boolean addAdvert(Advert advert) {
        return advertDao.addAdvert(advert);
    }

    @Override
    public boolean editAdvert(Advert advert, int id) {
        return advertDao.editAdvert(advert, id);
    }

    @Override
    public boolean deleteAdvert(int id) {
        return advertDao.deleteAdvert(id);
    }
}
