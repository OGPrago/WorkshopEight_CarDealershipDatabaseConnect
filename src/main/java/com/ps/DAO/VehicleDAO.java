package com.ps.DAO;

import com.ps.DAO.Interfaces.VehicleInt;
import org.apache.commons.dbcp2.BasicDataSource;

public class VehicleDAO implements VehicleInt {
    private BasicDataSource basicDataSource;

    public VehicleDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
