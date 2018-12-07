package com.example.dc.emu_dormitory_reservation_app;

import java.io.Serializable;

public class ManageBookingModel implements Serializable {
    private String Dateofbooking;
    private String Timeofbooking;
    private String Checkindate;
    private String Checkinsemester;

    public ManageBookingModel(String dateofbooking, String timeofbooking, String checkindate, String checkinsemester) {
        Dateofbooking = dateofbooking;
        Timeofbooking = timeofbooking;
        Checkindate = checkindate;
        Checkinsemester = checkinsemester;
    }

    public ManageBookingModel() {

    }

    public String getDateofbooking() {
        return Dateofbooking;
    }

    public void setDateofbooking(String dateofbooking) {
        Dateofbooking = dateofbooking;
    }

    public String getTimeofbooking() {
        return Timeofbooking;
    }

    public void setTimeofbooking(String timeofbooking) {
        Timeofbooking = timeofbooking;
    }

    public String getCheckindate() {
        return Checkindate;
    }

    public void setCheckindate(String checkindate) {
        Checkindate = checkindate;
    }

    public String getCheckinsemester() {
        return Checkinsemester;
    }

    public void setCheckinsemester(String checkinsemester) {
        Checkinsemester = checkinsemester;
    }
}
