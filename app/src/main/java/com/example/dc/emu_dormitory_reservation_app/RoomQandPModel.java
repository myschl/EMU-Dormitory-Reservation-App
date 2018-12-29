package com.example.dc.emu_dormitory_reservation_app;

import java.io.Serializable;

public class RoomQandPModel implements Serializable {
    private String roomqota;
    private String roomprice;
    private String roomId;

    public RoomQandPModel(String roomqota, String roomprice, String roomId) {
        this.roomqota = roomqota;
        this.roomprice = roomprice;
        this.roomId = roomId;
    }

    public RoomQandPModel(String roomqota, String roomprice) {
        this.roomqota = roomqota;
        this.roomprice = roomprice;
    }

    public RoomQandPModel() {

    }

    public String getRoomqota() {
        return roomqota;
    }

    public void setRoomqota(String roomqota) {
        this.roomqota = roomqota;
    }

    public String getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(String roomprice) {
        this.roomprice = roomprice;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
