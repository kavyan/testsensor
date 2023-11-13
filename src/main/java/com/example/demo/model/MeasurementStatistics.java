package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MeasurementStatistics {
    private double minTemperature;
    private double maxTemperature;
    private double sumTemperature;
    private double avgTemperature;
    private double minHumidity;
    private double maxHumidity;
    private double sumHumidity;
    private double avgHumidity;
    @Id
    private Long id;

    public MeasurementStatistics(double minTemperature, double maxTemperature, double sumTemperature, double avgTemperature, double minHumidity, double maxHumidity, double sumHumidity, double avgHumidity) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.sumTemperature = sumTemperature;
        this.avgTemperature = avgTemperature;
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
        this.sumHumidity = sumHumidity;
        this.avgHumidity = avgHumidity;
    }

    public MeasurementStatistics() {
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getSumTemperature() {
        return sumTemperature;
    }

    public void setSumTemperature(double sumTemperature) {
        this.sumTemperature = sumTemperature;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public double getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(double minHumidity) {
        this.minHumidity = minHumidity;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public double getSumHumidity() {
        return sumHumidity;
    }

    public void setSumHumidity(double sumHumidity) {
        this.sumHumidity = sumHumidity;
    }

    public double getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(double avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
