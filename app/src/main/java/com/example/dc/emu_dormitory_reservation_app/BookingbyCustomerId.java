package com.example.dc.emu_dormitory_reservation_app;

import java.io.Serializable;

public class BookingbyCustomerId implements Serializable {
    private String DormitoryName;
    private String DormitoryDescription;
    private String DateOfBooking;
    private String CheckInDate;
    private String BookingStatus;
    private String DormitoryImageUrl;
    private String RatingNumber;
    private String RatingText;
    private String DormitoryId;

   /* public BookingbyCustomerId(String dormitoryName, String dormitoryDescription, String dateOfBooking, String checkInDate, String bookingStatus, String dormitoryImageUrl, String ratingNumber, String ratingText) {
        DormitoryName = dormitoryName;
        DormitoryDescription = dormitoryDescription;
        DateOfBooking = dateOfBooking;
        CheckInDate = checkInDate;
        BookingStatus = bookingStatus;
        DormitoryImageUrl = dormitoryImageUrl;
        RatingNumber = ratingNumber;
        RatingText = ratingText;
    }*/

    public BookingbyCustomerId(String dormitoryName, String dormitoryDescription, String dateOfBooking, String checkInDate, String bookingStatus, String dormitoryImageUrl, String ratingNumber, String ratingText, String dormitoryId) {
        DormitoryName = dormitoryName;
        DormitoryDescription = dormitoryDescription;
        DateOfBooking = dateOfBooking;
        CheckInDate = checkInDate;
        BookingStatus = bookingStatus;
        DormitoryImageUrl = dormitoryImageUrl;
        RatingNumber = ratingNumber;
        RatingText = ratingText;
        DormitoryId = dormitoryId;
    }

    public String getDormitoryName() {
        return DormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        DormitoryName = dormitoryName;
    }

    public String getDormitoryDescription() {
        return DormitoryDescription;
    }

    public void setDormitoryDescription(String dormitoryDescription) {
        DormitoryDescription = dormitoryDescription;
    }

    public String getDateOfBooking() {
        return DateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        DateOfBooking = dateOfBooking;
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String checkInDate) {
        CheckInDate = checkInDate;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        BookingStatus = bookingStatus;
    }

    public String getDormitoryImageUrl() {
        return DormitoryImageUrl;
    }

    public void setDormitoryImageUrl(String dormitoryImageUrl) {
        DormitoryImageUrl = dormitoryImageUrl;
    }

    public String getRatingNumber() {
        return RatingNumber;
    }

    public void setRatingNumber(String ratingNumber) {
        RatingNumber = ratingNumber;
    }

    public String getRatingText() {
        return RatingText;
    }

    public void setRatingText(String ratingText) {
        RatingText = ratingText;
    }

    public String getDormitoryId() {
        return DormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        DormitoryId = dormitoryId;
    }
}
