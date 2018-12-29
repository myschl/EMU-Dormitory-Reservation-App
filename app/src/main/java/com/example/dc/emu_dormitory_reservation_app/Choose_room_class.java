package com.example.dc.emu_dormitory_reservation_app;

import java.io.Serializable;

public class Choose_room_class implements Serializable {
    private String room_image;
    private String room_name;
    private String bedType;
    private String room_size;
    private String room_left;
    private String room_price;
    private String roomid;
    private String dormid;



    public Choose_room_class(String room_image, String room_name, String bedType, String room_size, String room_left, String room_price) {
        this.room_image = room_image;
        this.room_name = room_name;
        this.bedType = bedType;
        this.room_size = room_size;
        this.room_left = room_left;
        this.room_price = room_price;
    }

    public Choose_room_class(String room_image, String room_name, String bedType, String room_size, String room_left, String room_price, String roomid, String dormid) {
        this.room_image = room_image;
        this.room_name = room_name;
        this.bedType = bedType;
        this.room_size = room_size;
        this.room_left = room_left;
        this.room_price = room_price;
        this.roomid = roomid;
        this.dormid = dormid;
    }

    public Choose_room_class() {

    }

    public String getRoom_image() {
        return room_image;
    }

    public void setRoom_image(String room_image) {
        this.room_image = room_image;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getRoom_size() {
        return room_size;
    }

    public void setRoom_size(String room_size) {
        this.room_size = room_size;
    }

    public String getRoom_left() {
        return room_left;
    }

    public void setRoom_left(String room_left) {
        this.room_left = room_left;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getDormid() {
        return dormid;
    }

    public void setDormid(String dormid) {
        this.dormid = dormid;
    }
}
