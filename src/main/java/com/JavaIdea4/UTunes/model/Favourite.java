package com.JavaIdea4.UTunes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import lombok.Data;

import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.ManyToOne;

@Data
@Table(name = "FAVOURITES")
@Entity
public class Favourite {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private long user_id;
  @ManyToOne
  @JoinColumn(name = "tune_id")
  public Tune tune;

  public Favourite(long user_id) {
    this.user_id = user_id;
    
  }

  public Favourite(){
  }

  public Tune getTune() {
    return this.tune;
}

public void setTune(Tune Tune) {
  this.tune = Tune;
}

}
