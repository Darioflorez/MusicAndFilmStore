package model;

public class ModelContainer {
	private ArtistOrDirector artistOrDirector;
	private Media media;
	private Rating rating;
	private Review review;
	private User user;
	
	public ModelContainer(){
		artistOrDirector = new ArtistOrDirector();
		media = new Media();
		rating = new Rating();
		review = new Review();
		user = new User();
	}
	
	
	public ArtistOrDirector getArtistOrDirector() {
		return artistOrDirector;
	}
	public void setArtistOrDirector(ArtistOrDirector artistOrDirector) {
		this.artistOrDirector = artistOrDirector;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
