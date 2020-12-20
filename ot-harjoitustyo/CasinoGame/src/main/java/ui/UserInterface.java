
package ui;

import player.Player;
import blackjack.*;
import roulette.Roulette;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInterface extends Application{
    
    private Scene menuScene;
    private Scene rouletteScene;
    
    private Player player;
    private Roulette roulette;
    private BlackjackGame blackjack;
        
    @Override
    public void init()throws Exception{
        player = new Player();
        roulette = new Roulette(player);
        blackjack = new BlackjackGame(player);
    }
    
    @Override
    public void start(Stage stage){    
        Label playerMoney = new Label("Bank: " + player.getBank());
        Label playerBank = new Label("Bank: " + player.getBank());
        Label playerBank2 = new Label("Bank: " + player.getBank());
        Button returnToMenuB = new Button("Main menu");
        returnToMenuB.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                playerMoney.setText("Bank: " + player.getBank());
                stage.setScene(menuScene);
            }
        }); 
        Slider betSlider = new Slider(0, player.getBank(), 1);
        betSlider.setPrefWidth(200);
        Label betLabel = new Label();
        betLabel.textProperty().bind(Bindings.format("%.2f", betSlider.valueProperty()));
        VBox slider = new VBox(betLabel, betSlider);
        Slider betSlider2 = new Slider(0, player.getBank(), 1);
        betSlider2.setPrefWidth(200);
        Label betLabel2 = new Label();
        betLabel2.textProperty().bind(Bindings.format("%.2f", betSlider2.valueProperty()));
        VBox slider2 = new VBox(betLabel2, betSlider2);
        
        //Blackjack
        GridPane blackjackmenu = new GridPane();
        Label currentBet = new Label();
        currentBet.setText("Bet: " + 0);
        VBox gameInfo = new VBox(100);
        Label playerHand = new Label();
        if(blackjack.playerHand().length == 2){
            playerHand.setText("Your hand: " + blackjack.playerHand()[0] + "or" + blackjack.playerHand()[1]);
        }else{
            playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
        }
        Label dealerHand = new Label();
        dealerHand.setText("Dealer hand: " + blackjack.dealerHand());
        Label blackjackResult = new Label();
        gameInfo.getChildren().add(dealerHand);
        gameInfo.getChildren().add(blackjackResult);
        gameInfo.getChildren().add(playerHand);
        
        VBox buttonsDuringGame = new VBox(10);
        VBox buttonsBeforeGame = new VBox(10);
        
        Button stand = new Button("Stand");
        stand.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                blackjack.playerStand();
                playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                dealerHand.setText("Dealer hand: " + blackjack.dealerHand());
                int winner = blackjack.winner();
                if(winner == 0){
                    blackjackResult.setText("Tie!");
                }else if(winner == 1){
                    blackjackResult.setText("You won!");
                }else if(winner == 2){
                    blackjackResult.setText("You lost!");
                }else if(winner == 3){
                    blackjackResult.setText("You won, Blackjack!");
                }
                blackjackmenu.getChildren().remove(buttonsDuringGame);
                blackjackmenu.getChildren().add(buttonsBeforeGame);
                playerBank2.setText("Bank: " + player.getBank());
                betSlider2.setMax(player.getBank());
            }
        });
        Button hit = new Button("Hit");
        hit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                blackjack.playerHit();
                if(blackjack.playerHand().length == 2){
                    playerHand.setText("Your hand: " + blackjack.playerHand()[0] + "or" + blackjack.playerHand()[1]);
                        }else{
                    playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                }
                if(blackjack.hasPlayerLost()){
                    blackjack.playerStand();
                    playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                    dealerHand.setText("Dealer hand: " + blackjack.dealerHand());
                    int winner = blackjack.winner();
                    if(winner == 0){
                        blackjackResult.setText("Tie!");
                    }else if(winner == 1){
                        blackjackResult.setText("You won!");
                    }else if(winner == 2){
                        blackjackResult.setText("You lost!");
                    }else if(winner == 3){
                        blackjackResult.setText("You won, Blackjack!");
                    }
                    blackjackmenu.getChildren().remove(buttonsDuringGame);
                    blackjackmenu.getChildren().add(buttonsBeforeGame);
                    playerBank2.setText("Bank: " + player.getBank());
                    betSlider2.setMax(player.getBank());
                }
            }
        });
        Button doubleb = new Button("Double");
        doubleb.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                blackjack.playerDouble();
                currentBet.setText("Bet: " + blackjack.getBet());
                if(blackjack.playerHand().length == 2){
                    playerHand.setText("Your hand: " + blackjack.playerHand()[0] + "or" + blackjack.playerHand()[1]);
                        }else{
                    playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                }
                blackjack.playerStand();
                playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                dealerHand.setText("Dealer hand: " + blackjack.dealerHand());
                int winner = blackjack.winner();
                if(winner == 0){
                    blackjackResult.setText("Tie!");
                }else if(winner == 1){
                    blackjackResult.setText("You won!");
                }else if(winner == 2){
                    blackjackResult.setText("You lost!");
                }else if(winner == 3){
                    blackjackResult.setText("You won, Blackjack!");
                }
                blackjackmenu.getChildren().remove(buttonsDuringGame);
                blackjackmenu.getChildren().add(buttonsBeforeGame);
                playerBank2.setText("Bank: " + player.getBank());
                betSlider2.setMax(player.getBank());
                
            }
        });
        buttonsDuringGame.getChildren().add(hit);
        buttonsDuringGame.getChildren().add(stand);
        buttonsDuringGame.getChildren().add(doubleb);
        
        Button deal = new Button("Deal");
        deal.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                blackjack.bet((int)betSlider2.getValue());
                if(blackjack.getBet() != 0){
                    blackjackResult.setText("");
                    playerBank2.setText("Bank: " + player.getBank());
                    currentBet.setText("Bet: " + blackjack.getBet());
                    blackjackmenu.getChildren().remove(buttonsBeforeGame);
                    blackjack.start();
                    if(blackjack.playerHand().length == 2){
                        playerHand.setText("Your hand: " + blackjack.playerHand()[0] + "or" + blackjack.playerHand()[1]);
                            }else{
                        playerHand.setText("Your hand: " + blackjack.playerHand()[0]);
                    }
                    dealerHand.setText("Dealer hand: " + blackjack.dealerHand());
                    blackjackmenu.add(buttonsDuringGame, 2, 0);
                }
            }    
        });
        buttonsBeforeGame.getChildren().add(deal);
        buttonsBeforeGame.getChildren().add(slider2);
        
        blackjackmenu.getColumnConstraints().add(new ColumnConstraints(200));
        blackjackmenu.getColumnConstraints().add(new ColumnConstraints(200));
        blackjackmenu.getColumnConstraints().add(new ColumnConstraints(200));
        blackjackmenu.add(buttonsBeforeGame, 2, 0);
        blackjackmenu.add(gameInfo, 1, 0);
        blackjackmenu.add(playerBank2, 0, 1);
        blackjackmenu.add(returnToMenuB, 0, 2);
        blackjackmenu.add(currentBet, 0, 0);
        Scene blackjackScene = new Scene(blackjackmenu, 600, 300);
        
        //Roulette
        GridPane roulettemenu = new GridPane();
        VBox betButtons = new VBox(10);
        
        VBox betNumbers = new VBox();
        HBox row = new HBox(10);
        int rowSwap = 0;
        Label[] betLabels = new Label[37];
        for(int i = 0; i < 37; i++){
            if(rowSwap == 3){
                rowSwap = 0;
                betNumbers.getChildren().add(row);
                row = new HBox(5);
            }
            int buttonNumber = i;
            Button buttonI = new Button("" + buttonNumber);
            Label labelI = new Label();
            labelI.setText(":" + 0);
            buttonI.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    roulette.betNumber(buttonNumber, (int)betSlider.getValue());
                    playerBank.setText("Bank: " + player.getBank());
                    labelI.setText(":" + roulette.getNumberBet(buttonNumber));
                }
            });
            row.getChildren().add(buttonI);
            row.getChildren().add(labelI);
            betLabels[i] = labelI;
            rowSwap++;  
        }
            
        HBox betblackhbox = new HBox();
        Button betBlack = new Button("Bet Black");
        Label betBlackAmount = new Label(":" + roulette.getBlackBets());
        betBlack.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                roulette.betBlack((int)betSlider.getValue());
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
                roulette.betRed((int)betSlider.getValue());
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
                roulette.betOdd((int)betSlider.getValue());
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
                roulette.betEven((int)betSlider.getValue());
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
                roulette.bet1to18((int)betSlider.getValue());
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
                roulette.bet19to36((int)betSlider.getValue());
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
                for(int i = 0; i < 37; i++){
                    betLabels[i].setText(":" + roulette.getNumberBet(i));
                }
                playerBank.setText("Bank: " + player.getBank());
                result.setText("Result: " + spinResult);
                betSlider.setMax(player.getBank());
            }
        });
        
        Button returnToMenuR = new Button("Main menu");
        returnToMenuR.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                playerMoney.setText("Bank: " + player.getBank());
                stage.setScene(menuScene);
            }
        });
        VBox spinAndBank = new VBox();
        spinAndBank.getChildren().add(playerBank);
        spinAndBank.getChildren().add(spin);
        spinAndBank.getChildren().add(result);
        roulettemenu.getColumnConstraints().add(new ColumnConstraints(100));
        roulettemenu.getColumnConstraints().add(new ColumnConstraints(200));
        roulettemenu.getColumnConstraints().add(new ColumnConstraints(300));
        roulettemenu.add(slider, 1, 2);
        roulettemenu.add(betButtons, 1, 0);
        roulettemenu.add(betNumbers, 2, 0);
        roulettemenu.add(returnToMenuR, 0, 2);
        roulettemenu.add(spinAndBank, 0, 0);
        rouletteScene = new Scene(roulettemenu, 600, 600);
        
        //Main menu
        GridPane menu = new GridPane();
        menu.add(playerMoney, 0, 1);
        Button rouletteButton = new Button("Roulette");
        rouletteButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                betSlider.setMax(player.getBank());
                playerBank.setText("Bank: " + player.getBank());
                stage.setScene(rouletteScene);
            }
        });
        Button blackjackButton = new Button("BlackJack");
        blackjackButton.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent t){
                    betSlider2.setMax(player.getBank());
                    playerBank2.setText("Bank: " + player.getBank());
                    stage.setScene(blackjackScene);
                }
        });
        menu.add(blackjackButton, 1, 1);
        menu.add(rouletteButton, 1, 0);
        menuScene = new Scene(menu, 250, 150);
        stage.setScene(menuScene);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
