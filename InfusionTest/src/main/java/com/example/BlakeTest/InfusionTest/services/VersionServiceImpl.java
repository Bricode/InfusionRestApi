package com.example.BlakeTest.InfusionTest.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VersionServiceImpl implements VersionService {
  @Value("${application.version}")
  private Double applicationVersion;

  @Value("${databaseSchema.version}")
  private Double databaseSchemaVersion;

  @Override
  public Double getApplicationVersion() {
    return applicationVersion;
  }

  @Override
  public Double getDatabaseSchemaVersion() {
    return databaseSchemaVersion;
  }

}
