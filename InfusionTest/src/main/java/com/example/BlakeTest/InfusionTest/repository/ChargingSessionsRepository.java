package com.example.BlakeTest.InfusionTest.repository;

import com.example.BlakeTest.InfusionTest.mapping.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargingSessionsRepository extends JpaRepository<Session, Long> {
  List<Session> getAllChargingSessions();
}
