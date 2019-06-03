package com.example.nd.buspasssystem;

public class user {
    String cost;
    String startD;
    String endD;
    String status;

    public user() {
    }

    public user(String cost, String startD, String endD, String status) {
        this.cost = cost;
        this.startD = startD;
        this.endD = endD;
        this.status = status;
    }

    public String getcost() {
        return cost;
    }

    public void setcost(String cost) {
        cost = cost;
    }

    public String getStartD() {
        return startD;
    }

    public void setStartD(String startD) {
        this.startD = startD;
    }

    public String getEndD() {
        return endD;
    }

    public void setEndD(String endD) {
        this.endD = endD;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
