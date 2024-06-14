package com.ps;

import com.ps.DAO.DealershipDAO;
import com.ps.DAO.LeaseContractDAO;
import com.ps.DAO.SalesContractDAO;
import com.ps.DAO.VehicleDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;


public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static DealershipDAO dealershipDAO;
    private static LeaseContractDAO leaseContractDAO;
    private static SalesContractDAO salesContractDAO;
    private static VehicleDAO vehicleDAO;

    private static void init(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/cardealershipdatabase");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);
        dealershipDAO = new DealershipDAO(basicDataSource);
        leaseContractDAO = new LeaseContractDAO(basicDataSource);
        salesContractDAO = new SalesContractDAO(basicDataSource);
        vehicleDAO = new VehicleDAO(basicDataSource);
    }

    public static void display(String[] args) {
        init(args);
    }
}
