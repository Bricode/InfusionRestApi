package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;

@Entity
@Table(name = "RFIDTags")
public class RFIDTag {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int RFID;

  @Column(name = "customer")
  @ManyToOne
  private Customer customer;
  @Column(name = "vehicle")
  @ManyToOne
  private Vehicle vehicle;

  public RFIDTag(Customer customer, Vehicle vehicle) {
    this.vehicle = vehicle;
    this.customer = customer;
  }

  public RFIDTag() {
    super();
  }

  public int getRFID() {
    return RFID;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
