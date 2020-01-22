package com.db.service;
import com.db.model.Advert;

import java.util.List;

public interface IAdvertService {
    public Advert getAdvert(int id);
    public List<Advert> getAllAdverts();
    public List<Advert> getAdvertsByPersonID(int person_id);
    public boolean addAdvert(Advert advert);
    public boolean editAdvert(Advert advert, int id);
    public boolean deleteAdvert(int id);
}
