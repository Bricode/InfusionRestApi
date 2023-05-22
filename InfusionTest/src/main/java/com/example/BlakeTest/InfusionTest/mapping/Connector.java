package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;

@Entity
@Table(name = "connector")
public class Connector {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int connectorNumber;
  @ManyToOne
  @Column(name = "chargePoint")
  private ChargePoint chargePoint;

  public Connector(ChargePoint chargePoint) {
    this.chargePoint = chargePoint;
  }

  public Connector() {
    super();
  }
}
