package com.example.addressbookserver.entity;

public class User {
    private int id;
    private String name;
    private int telephone;
    private String gender;
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String username) {
        this.name = username;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int nTelephone) {
        this.telephone = nTelephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
};