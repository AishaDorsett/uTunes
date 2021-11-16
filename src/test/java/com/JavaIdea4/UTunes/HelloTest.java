package com.JavaIdea4.UTunes;
import com.JavaIdea4.UTunes.controller.HelloController;
import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
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

@RunWith(SpringRunner.class)
@SpringBootTest (classes = UTunesApplication.class)

public class HelloTest {
    public WebDriver driver = new ChromeDriver();;

    @Before 
    public void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void userCanSearchByGenre() {
        driver.get("http://localhost:8080/");
        Assert.assertEquals("Hello",driver.findElement(By.tagName("h1")).getText());
        driver.close();
        driver.quit();
    }

}