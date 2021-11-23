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

	@Column(name = "link")
	private String link;

	public Tune() {

	}

	public Tune(String trackname, String artistname, String genre, String link) {
		this.trackname = trackname;
		this.artistname = artistname;
		this.genre = genre;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", Trackname=" + trackname + ", Artist=" + artistname + ", Genre=" + genre + ", Link=" + link +"]";
	}
}
