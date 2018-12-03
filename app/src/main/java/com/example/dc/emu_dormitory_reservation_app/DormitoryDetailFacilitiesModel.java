package com.example.dc.emu_dormitory_reservation_app;

public class DormitoryDetailFacilitiesModel {
    private  String Facilityid ;
    private String ImageUrl;
    private String Name;

    public DormitoryDetailFacilitiesModel(String imageUrl, String name) {
        ImageUrl = imageUrl;
        Name = name;
    }

    public DormitoryDetailFacilitiesModel() {

    }

    public DormitoryDetailFacilitiesModel(String image, String name, String facilityId) {
        ImageUrl = image;
        Name = name;
        Facilityid = facilityId;
    }

    public String getFacilityid() {
        return Facilityid;
    }

    public void setFacilityid(String facilityid) {
        Facilityid = facilityid;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
