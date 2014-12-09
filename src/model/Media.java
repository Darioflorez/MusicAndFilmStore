package model;

public class Media {
	private String upc;
	private String title;
	private String releaseDate;
	private String genre;
	private float grandRating;
	private String userWhoAddedThisMedia;
	
	public Media() {
	}
	
	public Media(String upc, String title, String releaseDate, String genre, String userWhoAddedThisMedia){
		this.upc = upc;
		this.title = title;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.grandRating = 0;
		this.userWhoAddedThisMedia = userWhoAddedThisMedia;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getGrandRating() {
		return grandRating;
	}

	public void setGrandRating(float[] theRatings) {
		float r1 = theRatings[0];
		float r2 = theRatings[1];
		float r3 = theRatings[2];
		float r4 = theRatings[3];
		float r5 = theRatings[4];
		grandRating = (r1*1 + r2*2 + r3*3 + r4*4 + r5*5) / (r1+r2+r3+r4+r5);
	}

	public String getUserWhoAddedThisMedia() {
		return userWhoAddedThisMedia;
	}

	public void setUserWhoAddedThisMedia(String userWhoAddedThisMedia) {
		this.userWhoAddedThisMedia = userWhoAddedThisMedia;
	}
	
}
