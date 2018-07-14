
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictac.Player;
import tictac.TicTac;

public class Game_engine implements Initializable{
    @FXML
    Label player1;
    
    @FXML
    Label player2;
    
    static List<Button>bl = new ArrayList();
    
    public void end(){
        int k = 0;
        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION,"DRAW!",ButtonType.OK);
      
        for (Button b : bl){
          if("X".equals(b.getId()) || "O".equals(b.getId())){
                   k++;
           }
          if(k == bl.size()){
            alert3.showAndWait();
            newGame();
         }  
       }
    
    }
    public void result(GridPane p, Button b){
    for(Node n : p.getChildren()){
          bl.add((Button)n);
       }
       if((bl.get(0).getId()).equals(bl.get(3).getId()) && (bl.get(0).getId()).equals(bl.get(6).getId()) || (bl.get(1).getId()).equals(bl.get(4).getId()) && (bl.get(1).getId()).equals(bl.get(7).getId()) || (bl.get(2).getId()).equals(bl.get(5).getId()) && (bl.get(2).getId()).equals(bl.get(8).getId()) || (bl.get(0).getId()).equals(bl.get(1).getId()) && (bl.get(0).getId()).equals(bl.get(2).getId()) || (bl.get(3).getId()).equals(bl.get(4).getId()) && (bl.get(3).getId()).equals(bl.get(5).getId()) || (bl.get(6).getId()).equals(bl.get(7).getId()) && (bl.get(6).getId()).equals(bl.get(8).getId()) || (bl.get(0).getId()).equals(bl.get(4).getText()) && (bl.get(0).getText()).equals(bl.get(8).getText()) || (bl.get(2).getText()).equals(bl.get(4).getId()) && (bl.get(2).getId()).equals(bl.get(6).getId())){
       String a="";    
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"",ButtonType.OK);
       if("X".equals(b.getId())){
          Player.player1++;
          a = "Player1";
          player1.setText(String.valueOf(Player.player1));
       }
       else{
          Player.player2++;
          a = "Player2";
          player2.setText(String.valueOf(Player.player2));
          
       }
       alert.setContentText(a+" wins!!!!");
       alert.showAndWait();
       
       
       for(int j=0; j < bl.size(); j++){
           bl.get(j).setText("+");
           bl.get(j).setId("b"+j);
       
       }
       
       
       }
    
    }
    
    @FXML
    public void runIt(ActionEvent e){
        Button b = (Button)e.getSource();
        Alert alert = new Alert(Alert.AlertType.WARNING,"You can't press already pressed button",ButtonType.OK);
        if("X".equals(b.getId()) || "O".equals(b.getId())){
            alert.showAndWait();
        }else{ 
        Player.game++;
     
         if(Player.game %2 == 0){
           b.setText("O");
           b.setId("O");
         }else{
           b.setText("X");
           b.setId("X");
         }
       
         GridPane gp = TicTac.net();
         result(gp,b);
         end();
        }  
    }
    
    @FXML
    public void newGame(){
      for(int j=0; j < bl.size(); j++){
           bl.get(j).setText("+");
           bl.get(j).setId("b"+j);
      }
    } 
     
public Game_engine(){
  
   }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         player1.setText(String.valueOf(Player.player1));
         player2.setText(String.valueOf(Player.player2)); 
    }    
}
