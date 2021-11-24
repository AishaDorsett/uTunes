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
public class FavouritesTest {
    WebDriver driver;
    Faker faker;
    @Value("${spring.datasource.chromedriver}")
    private String chromedriver;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        driver = new ChromeDriver();
        faker = new Faker();
        // signup
        driver.get("http://localhost:8080/users/new");
        String name = faker.name().firstName();
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();

        // sign in
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button")).click();
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checksNavbarRoutesToFavouritesPage() {
        driver.get("http://localhost:8080/tunes");
        driver.findElement(By.id("nav-faves")).click();

        Assertions.assertEquals("http://localhost:8080/tunes/favourites",driver.getCurrentUrl());
    }

    @Test
    public void addingFavouriteRedirectsToFavouritesPage() {
        driver.get("http://localhost:8080/tunes");
        var input = driver.findElement(By.xpath("//input[@list='genre']"));
        var dropdown = driver.findElement(By.xpath("//*[@id='genre']/option[4]"));
        var value = dropdown.getAttribute("value");
        input.sendKeys(value);
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.tagName("h4")).getText();
        driver.findElement(By.id("add")).click();

        Assertions.assertEquals("http://localhost:8080/tunes/favourites",driver.getCurrentUrl());
    }

    @Test
    public void checksSpecificFavouritedTuneDisplaysOnFavouritesPage() {
        driver.get("http://localhost:8080/tunes");
        var input = driver.findElement(By.xpath("//input[@list='genre']"));
        var dropdown = driver.findElement(By.xpath("//*[@id='genre']/option[4]"));
        var value = dropdown.getAttribute("value");
        input.sendKeys(value);
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//form[@action='/add/7']")).click();
        
        String body = driver.findElement(By.tagName("body")).getText();
        Assertions.assertTrue(body.contains("Usher"));
    }

    @Test
    public void checksFavouritesNavbarShowsTunes() {
        driver.get("http://localhost:8080/tunes");
        var input = driver.findElement(By.xpath("//input[@list='genre']"));
        var dropdown = driver.findElement(By.xpath("//*[@id='genre']/option[3]"));
        var value = dropdown.getAttribute("value");
        input.sendKeys(value);
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//form[@action='/add/28']")).click();
        
        driver.get("http://localhost:8080/tunes");
        driver.findElement(By.id("nav-faves")).click();

        String body = driver.findElement(By.tagName("body")).getText();
        Assertions.assertTrue(body.contains("Humble"));
    }
}
