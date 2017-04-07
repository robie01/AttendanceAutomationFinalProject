/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import BE.Lesson;
import java.util.Date;

/**
 * The log in view that allow students to get access of their attendance.
 * @author robiesun
 */
public class MainClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/LogInView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/myStyleSheet.css");
     
        stage.setTitle("");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);

   }
    
    
}
