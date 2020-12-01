
package ui;

import com.mycompany.casinogame.Player;
import com.mycompany.casinogame.Roulette;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application{
    
    private Scene menuScene;
    private Scene rouletteScene;
    
    private Player player;
    private Roulette roulette;
        
    @Override
    public void init()throws Exception{
        player = new Player();
        roulette = new Roulette(player);
    }
    
    @Override
    public void start(Stage stage){
        GridPane roulettemenu = new GridPane();
        
        VBox betButtons = new VBox();
        Button betBlack = new Button("Bet Black");
        betButtons.getChildren().add(betBlack);
        
        Button betRed = new Button("Bet Red");
        betButtons.getChildren().add(betRed);
        
        Button betOdd = new Button("Bet Odd");
        betButtons.getChildren().add(betOdd);
        
        Button betEven = new Button("Bet Even");
        betButtons.getChildren().add(betEven);
        
        Button returnToMenu = new Button("Main menu");
        returnToMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                stage.setScene(menuScene);
            }
        });
        roulettemenu.add(betButtons, 2, 0);
        roulettemenu.add(returnToMenu, 0, 0);
        rouletteScene = new Scene(roulettemenu, 250, 150);
        
        GridPane menu = new GridPane();
        Label playerMoney = new Label("Money: " + player.getBank());
        menu.add(playerMoney, 0, 1);
        Button rouletteButton = new Button("Roulette");
        rouletteButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                stage.setScene(rouletteScene);
            }
        });
        menu.add(rouletteButton, 1, 0);
        menuScene = new Scene(menu, 250, 150);
        stage.setScene(menuScene);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
