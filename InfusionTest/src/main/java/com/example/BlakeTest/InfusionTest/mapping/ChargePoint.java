package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;

@Entity
@Table(name = "chargePoint")
public class ChargePoint {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int serialNumber;

  private String name;

  public ChargePoint(String name) {
    this.name = name;
  }

  public ChargePoint() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
