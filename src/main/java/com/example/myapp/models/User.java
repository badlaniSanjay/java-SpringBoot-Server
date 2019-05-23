package com.example.myapp.models;

public class User {

  private long id;
  private String username;
  private String firstName;
  private String password;
  private String lastName;
  private Role role;


  public User(long id, String username, String firstName) {
    super();
    this.id = id;
    this.username = username;
    this.firstName = firstName;
  }

  public User() {
    super();
  }

  public User(long id, String username, String firstName, String password, String lastName,
              Role role) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.password = password;
    this.lastName = lastName;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastname(String lastName) {
    this.lastName = lastName;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
