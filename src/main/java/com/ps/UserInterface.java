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
                    processGetVehiclesByPrice();
                    break;
                case 3:
                    processGetVehiclesByMakeModel();
                    break;
                case 4:
                    processGetVehiclesByYear();
                    break;
                case 5:
                    processGetVehiclesByColor();
                    break;
                case 6:
                    processGetVehiclesByMileage();
                    break;
                case 7:
                    processGetVehiclesByType();
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

    private static void processGetVehiclesByPrice() {
        System.out.print("Enter min price:");
        double min = scanner.nextDouble();
        System.out.print("Enter max price:");
        double max = scanner.nextDouble();
        List<Vehicle> vehiclesByPrice = vehicleDAO.getVehiclesByPrice(min, max);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByPrice) {
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

    private static void processGetVehiclesByMakeModel() {
        scanner.nextLine();
        System.out.print("Enter make:");
        String make = scanner.nextLine();
        System.out.print("Enter model:");
        String model = scanner.nextLine();
        List<Vehicle> vehiclesByMakeModel = vehicleDAO.getVehiclesByMakeModel(make, model);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByMakeModel) {
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

    private static void processGetVehiclesByYear() {
        System.out.print("Enter min year:");
        int min = scanner.nextInt();
        System.out.print("Enter max year:");
        int max = scanner.nextInt();
        List<Vehicle> vehiclesByYear = vehicleDAO.getVehiclesByYear(min, max);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByYear) {
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

    private static void processGetVehiclesByType() {
        scanner.nextLine();
        System.out.print("Enter vehicle type:");
        String type = scanner.nextLine();
        List<Vehicle> vehiclesByType = vehicleDAO.getVehiclesByType(type);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByType) {
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

    private static void processGetVehiclesByColor() {
        scanner.nextLine();
        System.out.print("Enter color:");
        String color = scanner.nextLine();
        List<Vehicle> vehiclesByColor = vehicleDAO.getVehiclesByColor(color);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByColor) {
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

    private static void processGetVehiclesByMileage() {
        System.out.print("Enter min mileage:");
        int min = scanner.nextInt();
        System.out.print("Enter max mileage:");
        int max = scanner.nextInt();
        List<Vehicle> vehiclesByMileage = vehicleDAO.getVehiclesByMileage(min, max);
        System.out.println("VIN|Year|Make|Model|Color|Mileage|Type|Price|SOLD");
        for (Vehicle vehicle : vehiclesByMileage) {
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
