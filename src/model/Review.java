package model;

public class Review {
	private String upc;
	private String userName;
	private String content;
	
	public Review() {
		
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
