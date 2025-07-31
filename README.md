# 🌍 GeoSence

**GeoSence** is a Java-based climate and resource utilization tracking system designed to empower users and scientists with actionable environmental insights. The system stores real-time climate and resource usage data, analyzes it, and generates insightful reports to aid in sustainable decision-making.

---

## 🚀 Features

- ✅ **Secure User Authentication**  
  Role-based login system for general users and scientists.
  
- 🌦️ **Climate Data Storage**  
  Store and manage data such as temperature, rainfall, and air quality for different locations.

- 💧 **Resource Utilization Tracking**  
  Track usage of critical resources including water, energy, and land.

- 📊 **Weather Reports**  
  Generate dynamic weather reports with air quality analysis (classified as *Good* or *Bad* based on average levels).

- 📈 **Resource Usage Reports**  
  Analyze historical consumption trends to optimize resource use.

- 🔄 **Real-Time Data Handling**  
  Supports live data entry and immediate report generation.

---

## 🛠️ Technologies Used

- **Java (JDK 8+)** – Core language used for building the application logic.  
- **MySQL** – Relational database to store climate and resource data.  
- **JDBC (MySQL Connector)** – Java Database Connectivity to interact with the database.  
- **CLI Interface** – Lightweight console-based interactions for a clean UX.

---

## 🗃️ Project Structure

```
GeoSence/
│── src/
│   ├── Main.java             # Entry point of the application
│   ├── Login.java            # Handles authentication logic
│   ├── Datas.java            # Inserts and manages climate/resource data
│   ├── Report.java           # Generates reports from data
│
│── database/
│   ├── geosence.sql          # SQL schema for required tables
│
└── README.md                 # Project documentation
```

---

## 🧮 Database Schema

### 🌦️ `weather_data` Table

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `id`         | `INT`        | Primary key            |
| `location`   | `VARCHAR(50)`| Location name          |
| `temp`       | `FLOAT`      | Temperature in °C      |
| `rainfall`   | `FLOAT`      | Rainfall in mm         |
| `air_quality`| `FLOAT`      | AQI value              |

---

### 💡 `resource_data` Table

| Field         | Type         | Description               |
|---------------|--------------|----------------------------|
| `id`          | `INT`        | Primary key                |
| `location`    | `VARCHAR(50)`| Region name                |
| `water_usage` | `FLOAT`      | Water consumption (liters) |
| `energy_usage`| `FLOAT`      | Energy used (kWh)          |
| `land_usage`  | `FLOAT`      | Land used (hectares)       |

---

## ⚙️ Setup Instructions

### 1️⃣ Database Setup

1. Install and open MySQL.
2. Create a database named `geosence`.
3. Run the `geosence.sql` script or manually create the `weather_data` and `resource_data` tables as shown above.
4. Optionally insert sample records.

### 2️⃣ Environment Setup

1. Install JDK 8 or higher.
2. Download the [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) and add it to your project classpath.

### 3️⃣ Compile & Run

```bash
javac -cp ".:mysql-connector-java.jar" src/*.java
java -cp ".:mysql-connector-java.jar" src/Main
```

> 🔁 Replace `:` with `;` on Windows if needed.

---

## 👨‍💻 Usage Guide

- **Login** as a regular user or scientist.
- **Input climate data** such as temperature, rainfall, and AQI.
- **Add resource usage data** by location.
- **Generate reports** for weather or resource utilization.
- **Air Quality Classification** is provided in reports (e.g., *Good* if AQI < threshold).

---

## 📸 Screenshots *(optional)*

> Add terminal screenshots or UI snapshots here if you develop a GUI in the future.

---

## 🔮 Future Enhancements

- 🌐 Integration with live weather APIs for automated data input  
- 📅 Add timestamp fields for trend-based reporting  
- 📊 Develop a web-based or GUI interface for better usability  
- 🧠 Incorporate machine learning to predict future resource consumption or weather patterns

---

## 🤝 Contribution

Contributions are welcome! You can:
- Submit bug reports or feature requests
- Fork the repo and create a pull request
- Refactor code or optimize database operations

---

## 📄 License

This project is open-source and free to use.  
> 📌 *(You may add a specific license like MIT, GPL, etc., here.)*

---

## 👩‍💻 Author

Developed with dedication by **Vishwaridha S.** 🚀  
> For queries or collaborations, feel free to connect!
