package com.ps.DAO;

import com.ps.DAO.Interfaces.SalesContractInt;
import org.apache.commons.dbcp2.BasicDataSource;

public class SalesContractDAO implements SalesContractInt {
    private BasicDataSource basicDataSource;

    public SalesContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
