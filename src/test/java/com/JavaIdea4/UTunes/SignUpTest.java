package com.JavaIdea4.UTunes;
import com.JavaIdea4.UTunes.controller.UserController;
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
public class SignUpTest {
   
    WebDriver driver;
    Faker faker;
    @Value("${spring.datasource.chromedriver}")
    private String chromedriver;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        driver = new ChromeDriver();
        faker = new Faker();
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checksUserSignUpRedirectsToHome() {
        driver.get("http://localhost:8080/users/new");
        driver.findElement(By.id("username")).sendKeys(faker.pokemon().name());
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();

        Assertions.assertEquals("http://localhost:8080/login",driver.getCurrentUrl());
    }

}
