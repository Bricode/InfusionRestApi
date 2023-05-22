package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "sessions")
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name="startTime")
  private LocalDateTime startTime;
  @Column(name="startMeterValue")
  private Double startMeterValue;

  @Column(name="sessionComplete")
  private Boolean sessionComplete;

  @Column(name="endTime")
  private Timestamp endTime;
  @Column(name="endMeterValue")
  private Double endMeterValue;
  @OneToOne
  @Column(name="RFIDTag")
  private RFIDTag RFIDTag;
  @OneToOne
  @Column(name = "connector")
  private Connector connector;


  public Session(LocalDateTime startTime, Double startMeterValue, RFIDTag RFIDTag, Connector connector) {
    this.startTime = startTime;
    this.startMeterValue = startMeterValue;
    this.RFIDTag = RFIDTag;
    this.connector = connector;
    this.endTime = new Timestamp(0);
    this.endMeterValue = 0.00;
  }

  public Session() {
    super();
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public Double getStartMeterValue() {
    return startMeterValue;
  }

  public void setStartMeterValue(Double startMeterValue) {
    this.startMeterValue = startMeterValue;
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  public Double getEndMeterValue() {
    return endMeterValue;
  }

  public void setEndMeterValue(Double endMeterValue) {
    this.endMeterValue = endMeterValue;
  }

  public RFIDTag getRFIDTag() {
    return RFIDTag;
  }

  public void setRFIDTag(RFIDTag RFIDTag) {
    this.RFIDTag = RFIDTag;
  }

  public Connector getConnector() {
    return connector;
  }

  public void setConnector(Connector connector) {
    this.connector = connector;
  }
}
