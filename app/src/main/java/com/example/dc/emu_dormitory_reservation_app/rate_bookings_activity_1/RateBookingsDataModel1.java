package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1;

public class RateBookingsDataModel1 {
    private String dormitoryName;
    private String dormitoryRoomName;
    private String date;
    private String dormitoryRating;
    private String dormitoryId;

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public String getDormitoryRoomName() {
        return dormitoryRoomName;
    }

    public void setDormitoryRoomName(String dormitoryRoomName) {
        this.dormitoryRoomName = dormitoryRoomName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDormitoryRating() {
        return dormitoryRating;
    }

    public void setDormitoryRating(String dormitoryRating) {
        this.dormitoryRating = dormitoryRating;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public RateBookingsDataModel1(String dormitoryName, String dormitoryRoomName, String date, String dormitoryRating, String dormitoryId) {

        this.dormitoryName = dormitoryName;
        this.dormitoryRoomName = dormitoryRoomName;
        this.date = date;
        this.dormitoryRating = dormitoryRating;
        this.dormitoryId = dormitoryId;
    }
}
