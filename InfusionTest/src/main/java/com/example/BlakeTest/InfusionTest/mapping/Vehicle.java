package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name")
  private String name;
  @Column(name = "plate")
  private String plate;

  public Vehicle(String name, String plate) {
    this.name = name;
    this.plate = plate;
  }

  public Vehicle() {
    super();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }
}
