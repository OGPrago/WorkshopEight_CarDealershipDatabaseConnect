package com.ps.DAO;

import com.ps.DAO.Interfaces.VehicleInt;
import com.ps.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO implements VehicleInt {
    private BasicDataSource basicDataSource;

    public VehicleDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                int vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("year");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                int mileage = resultSet.getInt("mileage");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                String sold = resultSet.getString("SOLD");

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesYear = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE price BETWEEN ? AND ? ORDER BY price");
        ) {
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesYear.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return vehiclesYear;
    }

    @Override
    public List<Vehicle> getVehiclesByMakeModel(String makeIn, String modelIn) {
        List<Vehicle> vehiclesMakeModel = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE make LIKE ? AND model LIKE ?");
        ) {
            preparedStatement.setString(1, makeIn);
            preparedStatement.setString(2, modelIn);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesMakeModel.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesMakeModel;
    }

    @Override
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesYear = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE year BETWEEN ? AND ? ORDER BY year");
        ) {
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesYear.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesYear;
    }

    @Override
    public List<Vehicle> getVehiclesByColor(String colorIn) {
        List<Vehicle> vehiclesColor = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE color LIKE ?");
        ) {
            preparedStatement.setString(1, colorIn);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesColor.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesColor;
    }

    @Override
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehiclesMileage = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE mileage BETWEEN ? AND ? ORDER BY mileage");
        ) {
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesMileage.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesMileage;
    }

    @Override
    public List<Vehicle> getVehiclesByType(String typeIn) {
        List<Vehicle> vehiclesType = new ArrayList<>();

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE type LIKE ?");
        ) {
            preparedStatement.setString(1, typeIn);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vin = resultSet.getInt("VIN");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String color = resultSet.getString("color");
                    int mileage = resultSet.getInt("mileage");
                    String type = resultSet.getString("type");
                    double price = resultSet.getDouble("price");
                    String sold = resultSet.getString("SOLD");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, mileage, type, price, sold);
                    vehiclesType.add(vehicle);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesType;
    }
}

