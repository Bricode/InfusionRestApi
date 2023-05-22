package com.example.BlakeTest.InfusionTest.mapping;

import jakarta.persistence.*;



@Entity
@Table(name = "customer")
public class Customer {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int customerId;

  @Column(name="name")
  private String name;

  public Customer(String name){
    this.name = name;
  }

  public Customer() {
    super();
  }
  public int getCustomerId() {
    return customerId;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
