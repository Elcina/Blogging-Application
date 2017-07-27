package com.assignment;

import org.springframework.data.annotation.Id;


public class Account {
  public Account(String name, String password){
    this.name =name;
    this.password=password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Id
  String name;

    String password;

}
