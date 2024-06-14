package com.ps.models;

public class LeaseContract {
    private int leaseId;
    private int vin;
    private String leaseDate;

    public LeaseContract(int leaseId, int vin, String leaseDate) {
        this.leaseId = leaseId;
        this.vin = vin;
        this.leaseDate = leaseDate;
    }

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(String leaseDate) {
        this.leaseDate = leaseDate;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "leaseId=" + leaseId +
                ", vin=" + vin +
                ", leaseDate='" + leaseDate + '\'' +
                '}';
    }
}
