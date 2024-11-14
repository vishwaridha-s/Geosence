package entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Datas {

    private Connection c;
    private Scanner s;
    private int resourceId;
    private int whetherId;
    public Datas(Connection conn,Scanner sc) {
        this.c= conn;
    }
    public int getResourceId() {
		String fetch = "select max(usage_id) as usage_id FROM resource_utilization";
        try (PreparedStatement statement = c.prepareStatement(fetch);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                resourceId = resultSet.getInt("usage_id");
            }
        }catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
		return resourceId;
	}
    public int getWhetherid() {
    	 String IdQuery = "select(weather_id) as weather_id FROM weather_data";
         try (PreparedStatement fetch= c.prepareStatement(IdQuery)){
        	 ResultSet resultSet = fetch.executeQuery();
             if (resultSet.next()){
                 whetherId= resultSet.getInt("weather_id");
             }
         }catch(SQLException e){
        	 System.out.println(e.getMessage());
         }
		 return whetherId;
	}
    public void insertWeatherData() {
        System.out.print("Enter location: ");
        String location = s.nextLine();
        System.out.print("Enter timestamp (yyyy-mm-dd HH:mm:ss): ");
        String timestamp = s.nextLine();
        System.out.print("Enter temperature: ");
        double temperature = s.nextDouble();
        System.out.print("Enter humidity: ");
        double humidity = s.nextDouble();
        System.out.print("Enter rainfall: ");
        double rainfall = s.nextDouble();
        System.out.print("Enter air quality: ");
        String airQuality = s.next();
        String dataQuery = "insert into weather_data (location, timestamp, temperature, humidity, rainfall, air_quality) " +
                                        "values(?,?,?,?,?,?)";

        try (PreparedStatement statement = c.prepareStatement(dataQuery)) {
            statement.setString(1, location);
            statement.setString(2, timestamp);
            statement.setDouble(3, temperature);
            statement.setDouble(4, humidity);
            statement.setDouble(5, rainfall);
            statement.setString(6, airQuality);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Updated weather. The id is " + getWhetherid());
            }
         }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void UsageData() {
        System.out.print("Enter location: ");
        String location = s.nextLine();
        System.out.print("Enter timestamp (yyyy-mm-dd HH:mm:ss): ");
        String timestamp = s.nextLine();
        System.out.print("Enter resource type electricity/water/gas");
        String resourceType = s.nextLine();
        System.out.print("Enter usage amount: ");
        double usageAmount = s.nextDouble();
        String usageQuery = "insert into resource_utilization (location, timestamp, resource_type, usage_amount) " +
                                          "values(?, ?, ?, ?)";

        try (PreparedStatement statement = c.prepareStatement(usageQuery)) {
            statement.setString(1, location);
            statement.setString(2, timestamp);
            statement.setString(3, resourceType);
            statement.setDouble(4, usageAmount);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Updated resource usage"+"the id is"+getResourceId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}