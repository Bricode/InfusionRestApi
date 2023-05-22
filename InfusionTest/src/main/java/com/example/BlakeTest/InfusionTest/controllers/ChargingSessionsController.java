package com.example.BlakeTest.InfusionTest.controllers;

import com.example.BlakeTest.InfusionTest.mapping.Connector;
import com.example.BlakeTest.InfusionTest.mapping.RFIDTag;
import com.example.BlakeTest.InfusionTest.mapping.Session;
import com.example.BlakeTest.InfusionTest.repository.ChargingSessionsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/chargingSessions")
public class ChargingSessionsController {


  ChargingSessionsRepository chargingSessionsRepository;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Session>> getAllSessions() {
    List<Session> sessions = new ArrayList<Session>();
    chargingSessionsRepository.findAll().forEach(sessions::add);

    if (sessions.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(sessions, HttpStatus.OK);
  }

  @RequestMapping(value = "/all", params = {"earliestDate","latestDate"}, method = RequestMethod.GET)
  public ResponseEntity<List<Session>> getAllSessions(LocalDateTime earliestDate, LocalDateTime latestDate) {


    List<Session> sessions = new ArrayList<Session>();
    chargingSessionsRepository.findAll().forEach(session -> {
      if (session.getStartTime().isAfter(earliestDate) && session.getStartTime().isBefore(latestDate)) {
        sessions.add(session);
      }
    });

    if (sessions.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(sessions, HttpStatus.OK);
  }

  @PostMapping( "/createChargingSession")
  public ResponseEntity<Session> createChargingSession(@RequestBody Session incomingSession) {
    try {
      Session session = chargingSessionsRepository.save(
        new Session(incomingSession.getStartTime(),incomingSession.getStartMeterValue(),incomingSession.getRFIDTag(),incomingSession.getConnector()));
      return new ResponseEntity<>(session, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping( "/finishChargingSession/{id}")
  public ResponseEntity<Session> finishChargingSession(@PathVariable("id") int id, @RequestBody Session session) {
    Optional<Session> sessionData = chargingSessionsRepository.findById((long) id);

    if (sessionData.isPresent()) {
      Session finishedSession = sessionData.get();
      finishedSession.setEndTime(session.getEndTime());
      finishedSession.setEndMeterValue(session.getEndMeterValue());
      return new ResponseEntity<>(chargingSessionsRepository.save(finishedSession), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
