package com.ps.DAO;

import com.ps.DAO.Interfaces.DealershipInt;
import org.apache.commons.dbcp2.BasicDataSource;

public class DealershipDAO implements DealershipInt {
    private BasicDataSource basicDataSource;

    public DealershipDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
