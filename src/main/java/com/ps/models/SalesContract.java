package com.ps.models;

public class SalesContract {
    private int salesId;
    private int vin;
    private String salesDate;

    public SalesContract(int salesId, int vin, String salesDate) {
        this.salesId = salesId;
        this.vin = vin;
        this.salesDate = salesDate;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesId=" + salesId +
                ", vin=" + vin +
                ", salesDate='" + salesDate + '\'' +
                '}';
    }
}
