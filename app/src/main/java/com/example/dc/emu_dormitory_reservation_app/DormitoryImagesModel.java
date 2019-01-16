package com.example.dc.emu_dormitory_reservation_app;

import java.io.Serializable;

public class DormitoryImagesModel implements Serializable {
    private String Image;
    private String dormId;

    public DormitoryImagesModel() {
    }

    public DormitoryImagesModel(String image) {
        Image = image;
    }

    public DormitoryImagesModel(String image, String dormId) {
        Image = image;
        this.dormId = dormId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }
}
