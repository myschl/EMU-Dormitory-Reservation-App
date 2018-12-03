package com.example.dc.emu_dormitory_reservation_app;

public class FilterByFacilitiesModel {
    private String facilityName;

    public FilterByFacilitiesModel(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}

