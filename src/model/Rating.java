package model;

public class Rating {
	private String upc;
	private String userName;
	private String rating;
	
	public Rating() {
		
	}

	public String getUpc() {
		return upc;
	}
		
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

}
