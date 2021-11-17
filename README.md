# uTunes

### User stories:

## MVP - 

```
[ ] As a human person
So that I can find music that I will like
I would like to search by genre
```

## Additional Features -

```
[ ] As a big music fan
So that I can listen to my choons again
I would like to save a list of favourite jamz
```

```
[ ] As a well-listened fan
So that I can keep on top of all of my favourite music
I would like to be able to add tracks
```

```
[ ] As a fanatic enjoyer of music
So that I can share the love with my fellow human people
I would like to share a YouTube/Bandcamp link to each song
```

```
[ ] As a musicologist
So that I can get my PhD in bangers
I would like to be able to search by artist
```

```
[ ] As a purveyor of big beats
So that I can fine-tune my radio dial
I would like to be able to search by year
```

```
[ ] As a groovy cat
So that I can surf the hippest frequencies
I would like to be able to search by album
```

```
[ ] As a sonic explorer
So that I can discover new musical worlds
I would like to be able to search for associated artists
```

## Setup

### ENV variable for CHROMEDRIVER - BEWARE, ensure correct spellings, copy and paste instead of typing it out.
1. run `which chromedriver` in terminal
2. make a note of where your chromdriver is saved, eg. `/opt/homebrew/bin/chromedriver`
3. run `open ~/.zshrc` and paste the above address in to the .zshrc terminal, eg. `export CHROMEDRIVER=/opt/homebrew/bin/chromedriver`
4. save your .zshrc file
5. run `source ~/.zshrc`
6. run `echo $CHROMEDRIVER`
7. go to src/main/resources/application.properties and add this line: spring.datasource.chromedriver=${CHROMEDRIVER}
8. go to src/test/java/com/JavaIdea4/UTunes/HelloTest.java
  1. paste this line: `import org.springframework.beans.factory.annotation.Value;`
  2. under `static WebDriver driver;` add the following lines;
    - `@Value("${spring.datasource.chromedriver}")`
    - `private static String chromedriver;`
  3. edit `@BeforeAll` to say:
     ```
     @BeforeAll
     public void setup() {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
     }
     ```
9. run `mvn test`from your terminal
  - make sure that spring-boot is currently running with `mvn spring-boot:run`
