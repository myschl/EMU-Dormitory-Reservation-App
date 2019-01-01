package com.example.dc.emu_dormitory_reservation_app;

public class UserDataModel {
    private String Name;
    private String Email;

    public UserDataModel() {
    }

    public UserDataModel(String name, String email) {
        Name = name;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
