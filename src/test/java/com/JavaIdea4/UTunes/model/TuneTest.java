package com.JavaIdea4.UTunes.model;

import static org.hamcrest.CoreMatchers.containsString;
// import org.junit.jupiter.api.Assertions;

// import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

public class TuneTest {
  @Test
  public void tuneHasTitle() {
    Tune tune = new Tune("Single Ladies", null, null, null);
    assertThat(tune.getTrackname(), containsString("Single Ladies"));
  }


  @Test
  public void tuneHasArtistName() {
    Tune tune = new Tune(null, "Beyonce", null, null);
    assertThat(tune.getArtistname(), containsString("Beyonce"));
  }

  @Test
  public void tuneHasGenre() {
    Tune tune = new Tune(null, null, "Pop", null);
    assertThat(tune.getGenre(), containsString("Pop"));
  }

  @Test
  public void tuneHasLink() {
    Tune tune = new Tune(null, null, null, "https://www.youtube.com/watch?v=4m1EFMoRFvY");
    assertThat(tune.getLink(), containsString("https://www.youtube.com/watch?v=4m1EFMoRFvY"));
  }
}
