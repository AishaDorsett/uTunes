package com.JavaIdea4.UTunes.model;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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

  @Test
  public void testEncodingPassword() {
    String rawPassword = "potato";
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(rawPassword);

    boolean matched = passwordEncoder.matches("potato", encodedPassword);

    Assertions.assertTrue(matched);
  }

  @Test
  public void doesntMatchSameValue() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    assertFalse(passwordEncoder.matches("password", "password"));
  }

  @Test
  public void doesntMatchNullEncodedValue() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    assertFalse(passwordEncoder.matches("password", null));
  }

  @Test
  public void doesntMatchEmptyEncodedValue() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    assertFalse(passwordEncoder.matches("password", ""));
  }

  @Test
  public void doesntMatchBogusEncodedValue() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    assertFalse(passwordEncoder.matches("password", "012345678901234567890123456789"));
  }
}
