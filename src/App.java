/**
 * Date 25/05/2021
 * Post it note application
 * Assignment 2a
 * @author Jan-Robbie Boddey BODJY005
 * @version 1.0
 * 
 *  -------------- Post it note main class ---------------
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * 
 * 
 *
 */
public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
	new AppStage(200, 200, 0, 0);
	System.out.println("Starting Post-It Note application...\nAuthor: Jan-Robbie Boddey - BODJY005");
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

