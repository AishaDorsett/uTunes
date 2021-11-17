package com.JavaIdea4.UTunes.model;

import javax.persistence.*;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "USERS")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;

  public User() {

  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  // public void setPassword(String password) {
  //   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
  //   String encodedPassword = encoder.encode(password);
  //   this.password = encodedPassword;
  // }
}
