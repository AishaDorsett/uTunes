package com.JavaIdea4.UTunes.model;



import javax.persistence.*;

@Entity
@Table(name = "tunes")
public class Tune {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "trackname")
	private String trackname;

	@Column(name = "artistname")
	private String artistname;

	@Column(name = "genre")
	private String genre;

	public Tune() {

	}

	public Tune(String trackname, String artistname, String genre) {
		this.trackname = trackname;
		this.artistname = artistname;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public String getTrackname() {
		return trackname;
	}

	public void setTrackname(String trackname) {
		this.trackname = trackname;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", Trackname=" + trackname + ", Artist=" + artistname + ", Genre=" + genre + "]";
	}
}
