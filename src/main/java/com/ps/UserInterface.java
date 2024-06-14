package com.ps;

import com.ps.DAO.DealershipDAO;
import com.ps.DAO.LeaseContractDAO;
import com.ps.DAO.SalesContractDAO;
import com.ps.DAO.VehicleDAO;
import com.ps.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.InputMismatchException;
import java.util.List;
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
                    vehicleSearchMenu();
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

    private static void vehicleSearchMenu() {
        byte vehicleCommand = 0;

        do {

            System.out.println("-----Vehicle Search-----");
            System.out.println("\t1) Display all");
            System.out.println("\t2) Price Range");
            System.out.println("\t3) Make/Model");
            System.out.println("\t4) Year Range");
            System.out.println("\t5) Color");
            System.out.println("\t6) Mileage Range");
            System.out.println("\t7) Type");
            System.out.println("\t99) Back");

            try {
                vehicleCommand = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Misinput? ¬‿¬");
                scanner.next();
                continue;
            }

            switch (vehicleCommand) {
                case 1:
                    processGetAllVehicles();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 99:
                    break;
                default:
                    break;
            }

        } while (vehicleCommand != 99);
    }

    private static void processGetAllVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%d|%d|%s|%s|%s|%d|%s|%.2f|%s\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getColor(),
                    vehicle.getMileage(),
                    vehicle.getType(),
                    vehicle.getPrice(),
                    vehicle.getSold()
            );
        }
    }
}
