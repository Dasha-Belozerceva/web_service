package com.db.model;

import java.time.LocalDateTime;

public class Advert {
    private Integer id;
    private Integer person_id;
    private String head;
    private String body;
    private String category;
    private String phone_number;
    private LocalDateTime date_of_creation;

    public Advert() {

    }

    public Advert(Integer id, Integer person_id, String head, String body, String phone_number, String category, LocalDateTime date_of_creation) {
        this.id = id;
        this.person_id = person_id;
        this.head = head;
        this.body = body;
        this.phone_number = phone_number;
        this.category = category;
        this.date_of_creation = date_of_creation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getDate_of_creation() {
        date_of_creation = LocalDateTime.now();
        return date_of_creation;
    }

    public void setDate_of_creation(LocalDateTime date_of_creation) {
        this.date_of_creation = date_of_creation;
    }
}
