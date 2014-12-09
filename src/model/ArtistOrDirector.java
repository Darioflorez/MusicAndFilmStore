package model;

public class ArtistOrDirector {
	private String aCode;
	private String name;
	private String nationality;
	private String userWhoAddedThisPerson;
	
	public ArtistOrDirector() {
		
	}
	
	public ArtistOrDirector(String aCode, String name, String nationality, String userWhoAddedThisPerson){
		this.aCode = aCode;
		this.name = name;
		this.nationality = nationality;
		this.userWhoAddedThisPerson = userWhoAddedThisPerson;
	}
	
	public String getaCode() {
		return aCode;
	}
	public void setaCode(String aCode) {
		this.aCode = aCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUserWhoAddedThisPerson() {
		return userWhoAddedThisPerson;
	}
	public void setUserWhoAddedThisPerson(String userWhoAddedThisPerson) {
		this.userWhoAddedThisPerson = userWhoAddedThisPerson;
	}
}
