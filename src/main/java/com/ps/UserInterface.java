package com.ps;

import com.ps.DAO.DealershipDAO;
import com.ps.DAO.LeaseContractDAO;
import com.ps.DAO.SalesContractDAO;
import com.ps.DAO.VehicleDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.InputMismatchException;
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
        mainMenu();
    }

    private static void mainMenu() {
        byte command = 0;

        do {
            System.out.println("Welcome! Please select an option.");
            System.out.println("\t1) Vehicle search");
            System.out.println("\t2) Add/Remove Vehicle");

            System.out.println("\t99) Exit");

            try {
                command = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Misinput? ¬‿¬");
                scanner.next();
                continue;
            }


            switch (command) {
                case 1:
                    break;
                case 2:
                    break;
                case 99:
                    System.out.println("Bye Bye.");
                    break;
                default:
                    System.out.println("Misinput? ¬‿¬");
                    break;
            }

        } while (command != 99);
    }
}
