package com.JavaIdea4.UTunes;
import com.JavaIdea4.UTunes.controller.HelloController;
import org.junit.jupiter.api.Test;

// import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.springframework.beans.factory.annotation.Autowired;

// @RunWith(SpringRunner.class)
@SpringBootTest(classes = UTunesApplication.class)

public class HelloTest {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void checksHeaderSaysHello(){ 

        Assertions.assertEquals("Hello",driver.findElement(By.tagName("h1")).getText());
    }

    // @Test
    // public void userCanSearchByGenre() {
    //     driver.findElement(By.id("content")).sendKeys("Hip Hop");
    //     driver.findElement(By.id("submit")).click();

    //     Assertions.assertEquals("King Kunta",driver.findElement(By.tagName("body")).getText());
    // }

}
