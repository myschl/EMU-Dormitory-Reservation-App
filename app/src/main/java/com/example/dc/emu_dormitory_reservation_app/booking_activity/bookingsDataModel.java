package com.example.dc.emu_dormitory_reservation_app.booking_activity;

public class bookingsDataModel {
    private String DormitoryName;
    private String DormitoryDescription;
    private String DateOfBooking;
    private String CheckInDate;
    private String BookingStatus;
    private String DormitoryImageUrl;

    public bookingsDataModel(String dormitoryName, String dormitoryDescription, String dateOfBooking, String checkInDate, String bookingStatus, String dormitoryImageUrl) {
        DormitoryName = dormitoryName;
        DormitoryDescription = dormitoryDescription;
        DateOfBooking = dateOfBooking;
        CheckInDate = checkInDate;
        BookingStatus = bookingStatus;
        DormitoryImageUrl = dormitoryImageUrl;
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
}
