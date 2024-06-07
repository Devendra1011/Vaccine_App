package com.example.vaccineapp;

public class VaccineModel {
    private String vaccineName;
    private int vaccineImg;

    public VaccineModel(String vaccineName, int vaccineImg) {
        this.vaccineName = vaccineName;
        this.vaccineImg = vaccineImg;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getVaccineImg() {
        return vaccineImg;
    }

    public void setVaccineImg(int vaccineImg) {
        this.vaccineImg = vaccineImg;
    }
}
