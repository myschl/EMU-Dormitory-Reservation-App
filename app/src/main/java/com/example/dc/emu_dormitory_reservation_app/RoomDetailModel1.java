package com.example.dc.emu_dormitory_reservation_app;

public class RoomDetailModel1 {
    private String imageUrl;
    private String imageName;
    private String facilityId;

    public RoomDetailModel1(String imageUrl, String imageName, String facilityId) {
        this.imageUrl = imageUrl;
        this.imageName = imageName;
        this.facilityId = facilityId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
