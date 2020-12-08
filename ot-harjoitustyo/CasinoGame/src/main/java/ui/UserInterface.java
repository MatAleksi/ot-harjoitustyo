
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
import javafx.scene.layout.HBox;
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
        Label playerBank = new Label("Bank: " + player.getBank());
        VBox betButtons = new VBox();
        
        HBox betblackhbox = new HBox();
        Button betBlack = new Button("Bet Black");
        Label betBlackAmount = new Label(":" + roulette.getBlackBets());
        betBlack.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.betBlack(100);
                betBlackAmount.setText(":" + roulette.getBlackBets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        betblackhbox.getChildren().add(betBlack);
        betblackhbox.getChildren().add(betBlackAmount);
        betButtons.getChildren().add(betblackhbox);
        
        HBox betredhbox = new HBox();
        Button betRed = new Button("Bet Red");
        Label betRedAmount = new Label(":" + roulette.getRedBets());
        betRed.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.betRed(100);
                betRedAmount.setText(":" + roulette.getRedBets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        betredhbox.getChildren().add(betRed);
        betredhbox.getChildren().add(betRedAmount);
        betButtons.getChildren().add(betredhbox);
        
        HBox betoddhbox = new HBox();
        Button betOdd = new Button("Bet Odd");
        Label betOddAmount = new Label(":" + roulette.getOddBets());
        betOdd.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.betOdd(100);
                betOddAmount.setText(":" + roulette.getOddBets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        betoddhbox.getChildren().add(betOdd);
        betoddhbox.getChildren().add(betOddAmount);
        betButtons.getChildren().add(betoddhbox);
        
        HBox betevenhbox = new HBox();
        Button betEven = new Button("Bet Even");
        Label betEvenAmount = new Label(":" + roulette.getEvenBets());
        betEven.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.betEven(100);
                betEvenAmount.setText(":" + roulette.getEvenBets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        betevenhbox.getChildren().add(betEven);
        betevenhbox.getChildren().add(betEvenAmount);
        betButtons.getChildren().add(betevenhbox);
        
        HBox bet1to18hbox = new HBox();
        Button bet1to18 = new Button("Bet 1to18");
        Label bet1to18Amount = new Label(":" + roulette.get1to18Bets());
        bet1to18.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.bet1to18(100);
                bet1to18Amount.setText(":" + roulette.get1to18Bets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        bet1to18hbox.getChildren().add(bet1to18);
        bet1to18hbox.getChildren().add(bet1to18Amount);
        betButtons.getChildren().add(bet1to18hbox);
        
        HBox bet19to36hbox = new HBox();
        Button bet19to36 = new Button("Bet 19to36");
        Label bet19to36Amount = new Label(":" + roulette.get19to36Bets());
        bet19to36.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.bet19to36(100);
                bet19to36Amount.setText(":" + roulette.get19to36Bets());
                playerBank.setText("Bank: " + player.getBank());
            }
        });
        bet19to36hbox.getChildren().add(bet19to36);
        bet19to36hbox.getChildren().add(bet19to36Amount);
        betButtons.getChildren().add(bet19to36hbox);
        
        Label result = new Label("Result: --");
        Button spin = new Button("Spin");
        spin.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                int spinResult = roulette.spin();
                betBlackAmount.setText(":" + roulette.getBlackBets());
                betRedAmount.setText(":" + roulette.getRedBets());
                betEvenAmount.setText(":" + roulette.getEvenBets());
                betOddAmount.setText(":" + roulette.getOddBets());
                bet1to18Amount.setText(":" + roulette.get1to18Bets());
                bet19to36Amount.setText(":" + roulette.get19to36Bets());
                playerBank.setText("Bank: " + player.getBank());
                result.setText("Result: " + spinResult);
            }
        });
        
        Button returnToMenu = new Button("Main menu");
        returnToMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                stage.setScene(menuScene);
            }
        });
        VBox spinAndBank = new VBox();
        spinAndBank.getChildren().add(playerBank);
        spinAndBank.getChildren().add(spin);
        spinAndBank.getChildren().add(result);
        roulettemenu.add(betButtons, 2, 0);
        roulettemenu.add(returnToMenu, 0, 2);
        roulettemenu.add(spinAndBank, 0, 0);
        rouletteScene = new Scene(roulettemenu, 300, 180);
        
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
