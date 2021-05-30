

import javafx.event.EventHandler;

//AppStage.java Template Written by Jan-Robbie Boddey



import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class AppStage {

	Stage stage; //Jan-Robbie
	BorderPane content;//Jan-Robbie
	double newX, newY, xOffset, yOffset, oldX, oldY, mapWidth, mapHeight; // Mark
	
	public AppStage(double sizeX, double sizeY, double positionX, double positionY) {//Jan-Robbie
		
		stage = new Stage();//Jan-Robbie
		stage.setX(positionX);//Jan-Robbie
		stage.setY(positionY);//Jan-Robbie
		content = new BorderPane();//Jan-Robbie

		Image mapImage = new Image("file:panorama.jpg");
		ImageView mapGrid = new ImageView(mapImage);
		
		mapWidth = mapImage.getWidth();
		mapHeight = mapImage.getHeight();
		
		System.out.println(mapWidth + ":" + mapHeight);
		
		// Drag MouseEvent
		EventHandler<MouseEvent> dragClick = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				xOffset = e.getSceneX() - content.getLayoutX();
                yOffset = e.getSceneY() - content.getLayoutY();

			}};
			
		mapGrid.setOnMousePressed(dragClick);
        
        EventHandler<MouseEvent> dragDragged = new EventHandler<MouseEvent>() {

        	@Override
			public void handle(MouseEvent e) {
        		
        		oldX = content.getLayoutX();
        		oldY = content.getLayoutY();
        		
        		newX = e.getSceneX() - xOffset;
        		newY = e.getSceneY() - yOffset;

        		if ((newX > 0) || (newX < ((mapWidth-sizeX)*-1)))
        			newX = oldX;
        		if ((newY > 0) || (newY < ((mapHeight-sizeY)*-1)))
        			newY = oldY;

        		content.relocate(newX, newY);
        		
			}};

		content.setOnMouseDragged(dragDragged);
		
		EventHandler<MouseEvent> rightClick = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.SECONDARY) {
					stage.close();
				}
				
			}};
		
		mapGrid.setOnMouseReleased(rightClick);
		
		
		content.setTop(mapGrid);
		stage.initStyle(StageStyle.UNDECORATED);
		
		Scene scene = new Scene(content, sizeX, sizeY);//Jan-Robbie
		stage.setScene(scene);//Jan-Robbie
		//Show stage
		stage.show(); //Jan-Robbie
		
		
		
		
		
	}
}
