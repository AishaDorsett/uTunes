package com.JavaIdea4.UTunes.model;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UserTest {
   public static Faker faker;

  @BeforeAll
  public static void setup() {
    faker = new Faker();
  }

  @Test
  public void testUser() {
    String name = faker.name().firstName();
    User user = new User(name, "password1");
    assertThat("test name is recorded", user.getUsername(), containsString(name));
    assertThat("test password is recorded", user.getPassword(), containsString("password1"));
  }

  @Test
  public void testUsernameSetter() {
    String name = faker.name().firstName();
    User user = new User();
    user.setUsername(name);
    assertThat("test name is set", user.getUsername(), containsString(name));

  }
}
