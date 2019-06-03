package com.example.nd.buspasssystem;

public class userProfile {
    String nameS;
    String doB;
    String froM;
    String collegE;
    String tO;
    String mobileNo;
    String yearStudy;
    String aDdress;
    String status;
    String keY;
    String Cost;
    String startD;
    String endD;


    public userProfile() {
    }

    public userProfile(String nameS,String collegE, String doB, String froM, String tO, String mobileNo, String yearStudy, String aDdress, String status,String keY) {
        this.nameS = nameS;
        this.collegE=collegE;
        this.doB = doB;
        this.froM = froM;
        this.tO = tO;
        this.mobileNo = mobileNo;
        this.yearStudy = yearStudy;
        this.aDdress = aDdress;
        this.status=status;
        this.keY=keY;
    }

    public String getKeY() {
        return keY;
    }

    public void setKeY(String keY) {
        this.keY = keY;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollegE() {
        return collegE;
    }

    public void setCollegE(String collegE) {
        this.collegE = collegE;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getFroM() {
        return froM;
    }

    public void setFroM(String froM) {
        this.froM = froM;
    }

    public String gettO() {
        return tO;
    }

    public void settO(String tO) {
        this.tO = tO;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getYearStudy() {
        return yearStudy;
    }

    public void setYearStudy(String yearStudy) {
        this.yearStudy = yearStudy;
    }

    public String getaDdress() {
        return aDdress;
    }

    public void setaDdress(String aDdress) {
        this.aDdress = aDdress;
    }
}