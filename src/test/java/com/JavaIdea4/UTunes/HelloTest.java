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
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

// @RunWith(SpringRunner.class)
@SpringBootTest(classes = UTunesApplication.class)

public class HelloTest {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void checksHeaderSaysHello(){ 
        driver.get("http://localhost:8080/");
        Assertions.assertEquals("Hello",driver.findElement(By.tagName("h1")).getText());
    }

    // @Test
    // public void userCanSearchByGenre() {
    //     driver.get("http://localhost:8080/search");
    //     Select dropdown = new Select(driver.findElement(By.id("select")));
    //     dropdown.selectByValue("hiphop");
    //     driver.findElement(By.id("submit")).click();

    //     Assertions.assertEquals("King Kunta",driver.findElement(By.tagName("body")).getText());
    // }

}
