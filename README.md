# uTunes

Team tigers-java-idea-4:
- Aisha Dorsett
- Anamaria Mocanu
- Joseph Shaw
- Matthew Read

## Setup

1. Fork and clone this repository to your machine
2. Open the codebase in an IDE like InteliJ or VSCode
3. Open psql in terminal
4. Write CREATE DATABASE utunes;
5. Exit psql \q
6.Install Maven: type brew install maven in the terminal
7. Build the app and start the server, using the Maven command mvn spring-boot:run ( this will run the migrations and set the tables)
8. Visit http://localhost:8080/


### ENV variable for CHROMEDRIVER - BEWARE, ensure correct spellings, copy and paste instead of typing it out.
1. run `which chromedriver` in terminal
2. make a note of where your chromdriver is saved, eg. `/opt/homebrew/bin/chromedriver`
3. run `open ~/.zshrc` and paste the above address in to the .zshrc terminal, eg. `export CHROMEDRIVER=/opt/homebrew/bin/chromedriver`
4. save your .zshrc file
5. run `source ~/.zshrc`
6. run `echo $CHROMEDRIVER` - make sure the specified path prints to your terminal
7. run `mvn test` from your terminal (make sure that spring-boot is currently running with `mvn spring-boot:run`)
8. grab a tea - you smashed it!


## User stories:

### MVP 

```
 [x] As a human person
So that I can find music that I will like
I would like to search by genre
```

### Additional Features 

```
[x] As a big music fan
So that I can listen to my choons again
I would like to save a list of favourite jamz
```

```
[x] As a well-listened fan
So that I can keep on top of all of my favourite music
I would like to be able to add trax
```

```
[x] As a fanatic enjoyer of music
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
## MVP mock-up

![MVP- Deadline Thursday 18_11](https://user-images.githubusercontent.com/80968551/143443697-798809ba-6936-4a61-91bd-88da53fdd128.png)

## Application mock-up
![Mock-up](https://user-images.githubusercontent.com/80968551/143443802-148df0f7-6a72-4c1d-9370-518aaba1d955.png)

## Features
- user can signup at /users/new (on the login page you press on Sign up in the nav bar)
- user can login at /login (once you sign up the page will redirect to login)
- user can search songs by genre at /tunes (logging in takes you to this page)
- user can add a song to their favourite page by clicking "Add to favourites" button
- user can check their favourite page at /tunes/favourites ( you can press Favourites in the navbar)
- user can add a song to the database at /add/tunes
- user can add the song they have added to their favourites page
- user can share their favourites page on Facebook, Twitter, Whatsapp and Gmail by pressing on the widget buttons
- user can access the video of the song by pressing on trackname
- user can logout by pressing Logout in the navbar

 ## Further steps
 ### Using a database API
 - we are currently using a database that we hard-coded songs into:
         https://rapidapi.com/blog/top-free-music-data-apis/
         https://en.wikipedia.org/wiki/List_of_online_music_databases
 ### Creating a recommendation system
 ### Social share buttons
 - we are currently using a free version of https://elfsight.com/social-media-share-buttons/, which has a limit of usage of 200 views
 - we could hard code the buttons ourselves or look into other options
 
 
 
 
 
