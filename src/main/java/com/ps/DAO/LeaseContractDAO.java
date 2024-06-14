package com.ps.DAO;

import com.ps.DAO.Interfaces.LeaseContractInt;
import org.apache.commons.dbcp2.BasicDataSource;

public class LeaseContractDAO implements LeaseContractInt {
    private BasicDataSource basicDataSource;

    public LeaseContractDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
