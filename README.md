# uTunes

### User stories:

## MVP - 

```
[x] As a human person
So that I can find music that I will like
I would like to search by genre
```

## Additional Features -

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

## Setup

### ENV variable for CHROMEDRIVER - BEWARE, ensure correct spellings, copy and paste instead of typing it out.
1. run `which chromedriver` in terminal
2. make a note of where your chromdriver is saved, eg. `/opt/homebrew/bin/chromedriver`
3. run `open ~/.zshrc` and paste the above address in to the .zshrc terminal, eg. `export CHROMEDRIVER=/opt/homebrew/bin/chromedriver`
4. save your .zshrc file
5. run `source ~/.zshrc`
6. run `echo $CHROMEDRIVER` - make sure the specified path prints to your terminal
7. run `mvn test` from your terminal (make sure that spring-boot is currently running with `mvn spring-boot:run`)
8. grab a tea - you smashed it!
