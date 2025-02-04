# GeoSence

GeoSence is a climate and resource utilization tracking system built using Java. It enables users and scientists to analyze environmental data, generate reports, and make informed decisions based on real-time weather and resource usage insights.

## Features

```
- **User Authentication:** Secure login for users and scientists.
- **Climate Data Storage:** Store temperature, rainfall, and other climate data.
- **Resource Utilization Tracking:** Monitor resource consumption trends.
- **Weather Reports:** Generate reports based on stored climate data.
- **Resource Usage Reports:** Analyze and generate reports on resource utilization.
- **Real-Time Updates:** Fetch and process data dynamically.
```

## Prerequisites

```
- Java Development Kit (JDK 8+)
- MySQL (for database management)
- MySQL Connector for Java (to connect to the database)
```

## Project Structure

```
GeoSence/
│── src/
│   ├── Main.java             # Entry point of the program
│   ├── Login.java            # Manages user authentication
│   ├── Datas.java            # Stores climate and resource data
│   ├── Report.java           # Generates weather and resource utilization reports
│── database/
│   ├── geosence.sql          # SQL script to set up the database
└── README.md                 # Project documentation
```

## Database Structure

### `weather_data` Table

```
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| id         | int         | NO   | PRI | NULL    |       |
| location   | varchar(50) | YES  |     | NULL    |       |
| temp       | float       | YES  |     | NULL    |       |
| rainfall   | float       | YES  |     | NULL    |       |
| air_quality| float       | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
```

### `resource_data` Table

```
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| id          | int         | NO   | PRI | NULL    |       |
| location    | varchar(50) | YES  |     | NULL    |       |
| water_usage | float       | YES  |     | NULL    |       |
| energy_usage| float       | YES  |     | NULL    |       |
| land_usage  | float       | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
```

## How to Run

### Step 1: Set Up the Database

```
1. Create a MySQL database named `geosence`.
2. Create the `weather_data` and `resource_data` tables using the structure above.
3. Insert sample data or allow real-time data entry through the program.
```

### Step 2: Install Dependencies

```
1. Ensure Java and MySQL are installed.
2. Add MySQL Connector for Java to the classpath.
```

### Step 3: Compile and Run the Program

```
javac -cp ".:mysql-connector-java.jar" Main.java
java -cp ".:mysql-connector-java.jar" Main
```

## Usage

```
- **Login** as a user or scientist.
- **Store climate data** like temperature, rainfall, and air quality.
- **Track resource usage** such as water and energy consumption.
- **Generate weather reports** with air quality analysis.
- **Generate resource utilization reports** based on historical data.
```

## Contribution

```
Contributions are welcome! Feel free to:
- Report bugs.
- Suggest new features.
- Open a pull request with improvements.
```

## License

```
This project is open-source and free to use. Add your preferred license here if needed.
```

## Author

```
Developed by Vishwaridha S. 🎉
```
