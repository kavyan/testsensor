# Sensor Data Management System

## Description
This project is a Spring Boot application designed to manage sensor data. It allows for the recording, retrieval, and analysis of sensor measurements.

## Installation and Setup
Clone the repository and import it into IntelliJ IDEA as a Maven project. Ensure you have JDK 11 or higher installed.

## Usage
To run the application:
1. Open the project in IntelliJ IDEA.
2. Run the `DemoApplication` class.

The application exposes several endpoints to interact with sensor data:
- `POST /api/sensors/measurements`: Add a new measurement.
- `GET /api/sensors/measurements`: Retrieve measurements for a sensor.
- `GET /api/sensors/measurements/stats`: Get statistical data for a sensor.

