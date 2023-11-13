package com.example.demo.repository;

import com.example.demo.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    @Query("SELECT m FROM Measurement m WHERE m.sensorId = :sensorId " +
            "AND (:startDate IS NULL OR m.timestamp >= :startDate) " +
            "AND (:endDate IS NULL OR m.timestamp <= :endDate)")
    List<Measurement> findBySensorIdAndTimestampBetween(Long sensorId, LocalDateTime startDate, LocalDateTime endDate);
}
