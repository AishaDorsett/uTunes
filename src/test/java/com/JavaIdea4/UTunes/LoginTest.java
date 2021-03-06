package com.JavaIdea4.UTunes;

import com.JavaIdea4.UTunes.controller.HelloController;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UTunesApplication.class)
@TestInstance(Lifecycle.PER_CLASS)

public class LoginTest {
  Faker faker;
  WebDriver driver;
  @Value("${spring.datasource.chromedriver}")
  private String chromedriver;

  @BeforeAll
  public void setup() {
      System.setProperty("webdriver.chrome.driver",chromedriver );
      driver = new ChromeDriver();
      faker = new Faker();
  }

  @AfterAll
  public void tearDown() {
      driver.close();
  }

  @Test
  public void successfulSignInAfterSignUp() {
      // signup
      driver.get("http://localhost:8080/users/new");
      String name = faker.name().firstName();
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("password");
      driver.findElement(By.id("submit")).click();

      // logins
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("password");
      driver.findElement(By.xpath("//button")).click();
      String title = driver.getTitle();
      Assertions.assertEquals("uTunes", title);
      

  }

  @Test
  public void unsuccessfulSignInRedirectsToSignIn() {
      // logout
      driver.get("http://localhost:8080/logout");
      driver.findElement(By.xpath("//button")).click();
      // signin with unknown account
      driver.get("http://localhost:8080/");
      String name = faker.name().firstName();
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("wordpass");
      driver.findElement(By.xpath("//button")).click();

      // check still on sign in page
      String title = driver.getTitle();
      Assertions.assertEquals("Please sign in", title);
  }

  @Test
  public void unsuccessfulSignInGivesWarningMessage() {
      // logout
      driver.get("http://localhost:8080/logout");
      driver.findElement(By.xpath("//button")).click();
      // signin with unknown account
      driver.get("http://localhost:8080/");
      String name = faker.name().firstName();
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("wordpass");
      driver.findElement(By.xpath("//button")).click();

      // check message Bad credentials appears
      String bodyText = driver.findElement(By.tagName("body")).getText();
      Assertions.assertTrue(bodyText.contains("Bad credentials"));
  }

  @Test
  public void successfulSignInAfterUnsuccessfulSignIn() {
      // signup
      driver.get("http://localhost:8080/users/new");
      String name = faker.name().firstName();
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("password");
      driver.findElement(By.id("submit")).click();

      // signin with wrong password
      driver.get("http://localhost:8080/");
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("wordpass");
      driver.findElement(By.xpath("//button")).click();

      // sign in
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password")).sendKeys("password");
      driver.findElement(By.xpath("//button")).click();
      String title = driver.getTitle();
      Assertions.assertEquals("uTunes", title);

  }
}
