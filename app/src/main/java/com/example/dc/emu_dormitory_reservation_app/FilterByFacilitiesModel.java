package com.example.dc.emu_dormitory_reservation_app;

public class FilterByFacilitiesModel {
    private String facilityName;
    private String facilityId;

    public FilterByFacilitiesModel(String facilityName, String facilityId) {
        this.facilityName = facilityName;
        this.facilityId = facilityId;
    }

    public FilterByFacilitiesModel(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }
}

