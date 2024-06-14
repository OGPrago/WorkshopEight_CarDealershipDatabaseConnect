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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return vehicles;
        }

    }

    @Override
    public List<Vehicle> getVehiclesByPrice(double min, double max) {

    }

    @Override
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return List.of();
    }

    @Override
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return List.of();
    }

    @Override
    public List<Vehicle> getVehiclesByColor(String color) {
        return List.of();
    }

    @Override
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return List.of();
    }

    @Override
    public List<Vehicle> getVehiclesByType(String type) {
        return List.of();
    }
}
