package com.example.BlakeTest.InfusionTest.controllers;

import com.example.BlakeTest.InfusionTest.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionServiceController {

  @Autowired
  VersionService versionService;

  @RequestMapping(value = "/appVersion")
  public ResponseEntity<Double> getAppVersion() {
    return new ResponseEntity<>(versionService.getApplicationVersion(), HttpStatus.OK);
  }

  @RequestMapping(value = "/databaseSchemaVersion")
  public ResponseEntity<Double> getDatabaseSchemaVersion() {
    return new ResponseEntity<>(versionService.getDatabaseSchemaVersion(), HttpStatus.OK);
  }
}
