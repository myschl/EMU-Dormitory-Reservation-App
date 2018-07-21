package com.example.dc.emu_dormitory_reservation_app.Home_activity;

public class HomeActivityDataModel {
    private String DormitoryName;
    private String DormitoryDiscountsStartsAt;
    private int DiscountAmountStratsAt;
    private String DiscountCurrency;
    private Boolean DealExists;
    private String DormitoryImageUrl;

    public HomeActivityDataModel(String dormitoryName, String dormitoryDiscountsStartsAt, int discountAmountStratsAt, String discountCurrency, Boolean dealExists, String dormitoryImageUrl) {
        DormitoryName = dormitoryName;
        DormitoryDiscountsStartsAt = dormitoryDiscountsStartsAt;
        DiscountAmountStratsAt = discountAmountStratsAt;
        DiscountCurrency = discountCurrency;
        DealExists = dealExists;
        DormitoryImageUrl = dormitoryImageUrl;
    }


    public String getDormitoryName() {
        return DormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        DormitoryName = dormitoryName;
    }

    public String getDormitoryDiscountsStartsAt() {
        return DormitoryDiscountsStartsAt;
    }

    public void setDormitoryDiscountsStartsAt(String dormitoryDiscountsStartsAt) {
        DormitoryDiscountsStartsAt = dormitoryDiscountsStartsAt;
    }

    public int getDiscountAmountStratsAt() {
        return DiscountAmountStratsAt;
    }

    public void setDiscountAmountStratsAt(int discountAmountStratsAt) {
        DiscountAmountStratsAt = discountAmountStratsAt;
    }

    public String getDiscountCurrency() {
        return DiscountCurrency;
    }

    public void setDiscountCurrency(String discountCurrency) {
        DiscountCurrency = discountCurrency;
    }

    public Boolean getDealExists() {
        return DealExists;
    }

    public void setDealExists(Boolean dealExists) {
        DealExists = dealExists;
    }

    public String getDormitoryImageUrl() {
        return DormitoryImageUrl;
    }

    public void setDormitoryImageUrl(String dormitoryImageUrl) {
        DormitoryImageUrl = dormitoryImageUrl;
    }
}
