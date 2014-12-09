package main;

import java.util.ArrayList;

import model.ArtistOrDirector;
import model.Media;

import controller.ControllerMAFStore;

public class RunApplication {
	
	public RunApplication() throws InterruptedException{
		//MusicAndFilmStoreModel model = new MusicAndFilmStoreModel();
		ControllerMAFStore controller =  new ControllerMAFStore();
		
		controller.connect("root", "musicandfilmstore", "rioda");
		
//		ArtistOrDirector artistInfo = new ArtistOrDirector( 321,"'Pink'", "'USA'", "'ME'");
//		controller.insertArtist(artistInfo);
		
		//controller.search();
		//controller.insertMusic();
		
	}

}
