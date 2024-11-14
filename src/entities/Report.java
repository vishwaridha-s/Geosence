package entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Report {

    private Connection c;
    private Scanner sc;
    public Report(Connection conn,Scanner sc) {
        this.c= conn;
        this.sc=sc;
    }
    public void generateWeatherReport(int analystid) {
        System.out.print("Enter location for weather report: ");
        String location = sc.nextLine();

        String weatherQuery = "SELECT AVG(rainfall) AS avg_rainfall, AVG(humidity) AS avg_humidity, AVG(air_quality) AS avg_air_quality FROM weather_data WHERE location = ?";
        String insertWeatherReport = "INSERT INTO weather_report (analyst_id, location, avg_rainfall, avg_humidity, air_quality,Air_status) " +
                                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = c.prepareStatement(weatherQuery)) {
            statement.setString(1, location);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    double avgRainfall = resultSet.getDouble("avg_rainfall");
                    double avgHumidity = resultSet.getDouble("avg_humidity");
                    double avgAirQuality = resultSet.getDouble("avg_air_quality");
                    String airStatus = avgAirQuality < 50 ? "Good" : "Bad";
                    try (PreparedStatement insert = c.prepareStatement(insertWeatherReport)) {
                        insert.setInt(1,analystid);
                        insert.setString(2,location);
                        insert.setDouble(3,avgRainfall);
                        insert.setDouble(4,avgHumidity);
                        insert.setDouble(5,avgAirQuality);
                        insert.setString(6,airStatus);

                        int rowsInserted = insert.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Weather report successfully saved for location: " + location);
                        }
                    }
                } else {
                    System.out.println("No data found for location: " + location);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void generateResourceReport() {
        System.out.print("Enter location for resource utilization report: ");
        String location = sc.nextLine();

        String resourceQuery = "SELECT resource_type, AVG(usage_amount) AS avg_usage " +
                               "FROM resource_utilization WHERE location = ? GROUP BY resource_type";
        String insertResourceReport = "INSERT INTO resource_usage (analyst_id, timestamp, resource_type, avg_usage, location) " +
                                      "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = c.prepareStatement(resourceQuery)) {
            statement.setString(1, location);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String resourceType = resultSet.getString("resource_type");
                    double avgUsage = resultSet.getDouble("avg_usage");
                    try (PreparedStatement insertStatement = c.prepareStatement(insertResourceReport)) {
                        insertStatement.setInt(1, 1); 
                        insertStatement.setDate(2, java.sql.Date.valueOf("2024-11-30"));
                        insertStatement.setString(3, resourceType);
                        insertStatement.setDouble(4, avgUsage);
                        insertStatement.setString(5, location);

                        int rowsInserted = insertStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Resource utilization report saved for resource: " + resourceType + " in location: " + location);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void checkWether() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();
        System.out.print("Enter location: ");
        String location = sc.nextLine();

        String weatherQuery = "SELECT * FROM weather_data WHERE timestamp = ? AND location = ?";

        try (PreparedStatement statement = c.prepareStatement(weatherQuery)) {
            statement.setString(1, date);
            statement.setString(2, location);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Weather data for " + location + " on " + date + ":");
                    System.out.println("Temperature: " + resultSet.getDouble("temperature"));
                    System.out.println("Humidity: " + resultSet.getDouble("humidity"));
                    System.out.println("Rainfall: " + resultSet.getDouble("rainfall"));
                    System.out.println("Air Quality: " + resultSet.getString("air_quality"));
                } 
                else{
                    System.out.println("No data found for the given date and location.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }