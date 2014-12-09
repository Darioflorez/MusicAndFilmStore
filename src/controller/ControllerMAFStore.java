package controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.ArtistOrDirector;
import model.Media;

public class ControllerMAFStore {
	private String user;
	private String pwd;
	private String server;
	private String database;
	private Boolean appRunning;
	private String query;
	private String change;
	private Connection con;
	
	public void connect(String user, String database, String pwd){
		this.user = user;
		this.database = database;
		this.pwd = pwd;
		this.server = "jdbc:mysql://localhost:3306/" + this.database +
				"?UseClientEnc=UTF8"; 
		setQuery("");
		setChange("");
		con = null;

		try {	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(this.server, this.user, this.pwd);
			System.out.println("Connected!");
			appRunning = true;
			//insertRatingMovie("t_customer", "'2364'");
			//setQuery("SELECT * FROM t_customer");
			//setChange("UPDATE bibliotek.t_customer set email = 'dario@kth.se' where id = '1253'");
//			int i = 0;
//			while(appRunning){
//				if(!query.equals("")){
//					ExecuteQuery executeQuery = new ExecuteQuery(con, query);
//					executeQuery.start();
//					setQuery("");
//				}
//				else if(!change.equals("")){
//					ExecuteChange executeChange = new ExecuteChange(con, change);
//					executeChange.start();
//					setChange("");
//					//setQuery("SELECT * FROM t_customer");
//				}
//				insertRatingMovie("t_customer", "'1354'");
//				Thread.sleep(1000);
//				i++;
//				if(i == 5){
//					appRunning = false;
//				}
//			}
			
			//executeQuery(con,"SELECT * FROM t_customer"  );//"UPDATE bibliotek.t_customer set name = 'Dario' where id = '1253'"
        }
		catch(Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, 
				"Database error, " + e.toString());
		}
	}
	
	public void closeConnection(){
		try {
    		if(con != null) {
    			con.close();
    			System.out.println("Connection closed.");
    		}
    	} 
    	catch(SQLException e) {
    		
    	}
	}
	
	public Boolean getAppRunning(){
		return appRunning;
	}
	
	public void setAppRunning(Boolean appRunning){
		this.appRunning = appRunning;
	}
	
	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}


	public String getChange() {
		return change;
	}


	public void setChange(String change) {
		this.change = change;
	}

	public void updateMovie(){
	}
	
	public void updateMusic(){
		
	}
	
	public void insertMovie(){
		
	}
	
	public void insertMusic(Media cdInfo, ArrayList<ArtistOrDirector> artistList){
		InsertMusic insertMusic = new InsertMusic(con, cdInfo, artistList);
		insertMusic.start();
	}
	
	public void insertResentionMusic(){
		
	}
	
	public void insertResentionMovie(){
		
	}
	
	public void insertRatingMusic(){
		
	}
	
	public void insertRatingMovie(String movie, String rating ) throws InterruptedException{
		setChange("INSERT " + movie + "(id, name, email, phone)" +
				"VALUES(" + rating + ", 'jhon', 'jhon@kth.se',' 0767967712')");
		ExecuteChange executeChange = new ExecuteChange(con, change);
		executeChange.start();
		executeChange.join();
		setChange("");
		
		setQuery("SELECT * FROM t_customer");
		ExecuteQuery executeQuery = new ExecuteQuery(con, query);
		executeQuery.start();
		executeQuery.join();
		setQuery("");
		
		closeConnection();
	}
	
	public void insertArtist(ArtistOrDirector artistInfo) throws InterruptedException{
		String aCode = "'" + artistInfo.getaCode()+ "'";
		String name = artistInfo.getName();
		String nationality = artistInfo.getNationality();
		String userName = artistInfo.getUserWhoAddedThisPerson();
		setChange("INSERT  t_artist (aCode, name, nationality, userName)" +
				"VALUES(" + aCode + "," + name + "," + nationality + "," + userName + ")");
		ExecuteChange executeChange = new ExecuteChange(con, change);
		executeChange.start();
		executeChange.join();
		setChange("");
		
//		setQuery("SELECT * FROM t_artist");
//		ExecuteQuery executeQuery = new ExecuteQuery(con, query);
//		executeQuery.start();
//		executeQuery.join();
//		setQuery("");
//		
//		closeConnection();
	}
	
	
	public void search() throws InterruptedException{
		setQuery("SELECT * FROM t_artist");
		ExecuteQuery executeQuery = new ExecuteQuery(con, query);
		executeQuery.start();
		executeQuery.join();
		setQuery("");
		
		closeConnection();
	}

	class InsertMusic extends Thread{
		private Connection con = null;
		private String query;
		private Media cdInfo;
		private ArrayList<ArtistOrDirector> artistList;
		
		public InsertMusic(Connection con, Media cdInfo, ArrayList<ArtistOrDirector> artistList){
			this.con = con;
			this.cdInfo = cdInfo;
			this.artistList = artistList;	
		}
		
		public void run(){
			setQuery("Works");
			System.out.println(getQuery());
		}
		
	}
	
	class ExecuteQuery extends Thread {
		private Connection con = null;
		private String query;
		
		public ExecuteQuery (Connection con, String query){
			this.con = con;
			this.query = query;
		}
		
		public void run(){
			PreparedStatement pstmt = null;
			try { 
		    	pstmt = con.prepareStatement(query);
		    	ResultSet rs = pstmt.executeQuery();
		    	ResultSetMetaData metaData = rs.getMetaData();
		    	int ccount = metaData.getColumnCount();
		    	for(int c = 1; c <= ccount; c++) {
		    		//metaData.getColumnName(c). Column name from a table
		    		System.out.print(metaData.getColumnName(c) + "\t");
		    	}
		    	
		    	System.out.println();
		    	
		    	// Get the attribute values
		    	while (rs.next()) {
	    			// NB! This is an example, -not- the preferred way to retrieve data.
	    			// You should use methods that return a specific data type, like
	    			// rs.getInt(), rs.getString() or such.
	    			// It's also advisable to store each tuple (row) in an object of
	    			// custom type (e.g. Employee).
		    		for(int c = 1; c <= ccount; c++) {
		    			System.out.print(rs.getString(c) + "\t");
		    		}
			        System.out.println();
		    	}
			}
			catch(SQLException sqlE){
				sqlE.printStackTrace();
				//Thread.currentThread().interrupt();
			}
			finally {
			    if (pstmt != null) { 
			   		try {
						pstmt.close();
					} catch (SQLException sqlE) {
						sqlE.printStackTrace();
						Thread.currentThread().interrupt();
					} 
			   	}
			}
		}
	}
	
	class ExecuteChange extends Thread {

		private Connection con = null;
		private String change;		
		public ExecuteChange(Connection con, String change){
			this.con = con;
			this.change = change;
		}
		@Override
		public void run(){
			PreparedStatement pstmt = null;
			try{
				pstmt = con.prepareStatement(change);
				int n = pstmt.executeUpdate();
			}
			catch(SQLException sqlE){
				sqlE.printStackTrace();
				Thread.currentThread().interrupt(); //Shutdown the thread
			}
			finally{
				if(pstmt != null){
					try{
						pstmt.close();
					}
					catch(SQLException sqlE){
						sqlE.printStackTrace();
						Thread.currentThread().interrupt(); //Shutdown the thread
					}
				}
			}	
		}
	}
		
}
