package com.example.BlakeTest.InfusionTest.controllers;

import com.example.BlakeTest.InfusionTest.mapping.Connector;
import com.example.BlakeTest.InfusionTest.mapping.RFIDTag;
import com.example.BlakeTest.InfusionTest.mapping.Session;
import com.example.BlakeTest.InfusionTest.repository.ChargingSessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}
