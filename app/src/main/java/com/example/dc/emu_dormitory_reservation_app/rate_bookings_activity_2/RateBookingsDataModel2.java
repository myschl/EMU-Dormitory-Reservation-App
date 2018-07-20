package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2;

public class RateBookingsDataModel2 {
    private String dormitoryName;
    private String dormitoryShortDescription; //
    private String dormitoryRating; // 4.5
    private String dormitoryRatingStatus; //very good, poor e.t.c
    private String dormitoryImageUrl;
    private String dormitoryId; //this will be used later for on click event, so that it will take us to the right dormitory

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public String getDormitoryShortDescription() {
        return dormitoryShortDescription;
    }

    public void setDormitoryShortDescription(String dormitoryShortDescription) {
        this.dormitoryShortDescription = dormitoryShortDescription;
    }

    public String getDormitoryRating() {
        return dormitoryRating;
    }

    public void setDormitoryRating(String dormitoryRating) {
        this.dormitoryRating = dormitoryRating;
    }

    public String getDormitoryRatingStatus() {
        return dormitoryRatingStatus;
    }

    public void setDormitoryRatingStatus(String dormitoryRatingStatus) {
        this.dormitoryRatingStatus = dormitoryRatingStatus;
    }

    public String getDormitoryImageUrl() {
        return dormitoryImageUrl;
    }

    public void setDormitoryImageUrl(String dormitoryImageUrl) {
        this.dormitoryImageUrl = dormitoryImageUrl;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public RateBookingsDataModel2(String dormitoryName, String dormitoryShortDescription, String dormitoryRating, String dormitoryRatingStatus, String dormitoryImageUrl, String dormitoryId) {
        this.dormitoryName = dormitoryName;
        this.dormitoryShortDescription = dormitoryShortDescription;
        this.dormitoryRating = dormitoryRating;
        this.dormitoryRatingStatus = dormitoryRatingStatus;
        this.dormitoryImageUrl = dormitoryImageUrl;
        this.dormitoryId = dormitoryId;

    }
}
