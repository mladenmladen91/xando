
package tictac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTac extends Application {
    public static VBox root;
    public static GridPane net(){
        GridPane gp = (GridPane)root.getChildren().get(0);
        return gp;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       root =FXMLLoader.<VBox>load(getClass().getResource("/view/enterrieur.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}
