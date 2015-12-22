/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beproject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import beproject.displayShelfSample1;
import beproject.Thanks1;
import static beproject.Thanks2.stuff;
import sun.awt.DesktopBrowse;

/**
 *
 * @author Rohit
 */

public final class Thanks21 extends Application {
 
    private Desktop desktop = Desktop.getDesktop();
 // private static final Image ICON_48 = new Image(Encryption.class.getResourceAsStream("icon-48x48.png"));
    @Override
    public void start(final Stage stage) {
        stage.setTitle("DECRYPTION");
        final String str,str1;
         GridPane grid = new GridPane();
        //grid.setAlignment(Pos.CENTER);
         
        grid.setHgap(10);
        grid.setVgap(40);
       grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        //Text scenetitle = new Text("ENCRYPTION");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        //grid.add(scenetitle, 0, 0, 1, 1);
        
        //grid.setLayoutX(80);
      //  grid.setLayoutY(155);
        
        //Group grid = new Group();
        stage.setResizable(false);
        Scene scene = new Scene(grid,700,700);
      //  stage.setScene(new Scene(grid, 700,700));
 
         stage.setScene(scene);
//         Scene scene1 = new Scene(grid, 700, 700);
  //      primaryStage1.setScene(scene1);
        scene.getStylesheets().add
 (Thanks1.class.getResource("Login.css").toExternalForm());
        stage.show();

 
 
// scene.getStylesheets().add
 //(TestingFileOPen.class.getResource("Login.css").toExternalForm());
 
 
 
 
 
        Text scenetitle = new Text("DECRYPTION");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 2, 0, 2, 1);
        grid.setAlignment(Pos.CENTER);
         scenetitle.setFill(Color.WHITE);
          Label userName = new Label("DECRYPTION COMPLETED");
        userName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.add(userName,1,1);
        
        
        
         
       
        
        Button submit = new Button("OPEN FILE");
        GridPane.setConstraints(submit, 4, 1);
        grid.getChildren().add(submit);
        submit.setStyle("-fx-base: rgb(30,170,255);"); 
       
      Button submit1 = new Button("RETURN TO HOME");
        GridPane.setConstraints(submit1, 4, 2);
        grid.getChildren().add(submit1);
        submit1.setStyle("-fx-base: rgb(30,170,255);"); 
       
        
       final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
       
                 final Label message = new Label("");
           
           
        
        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open a Picture...");
        final Button openMultipleButton = new Button("Open Pictures...");     
      
        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    Thanks1 th1 = new Thanks1();
                    Desktop desk = Desktop.getDesktop();
                    File dir = new File(th1.plain_text(stuff));
                    try {
                        desk.open(dir);
                    } catch (IOException ex) {
                        Logger.getLogger(Thanks21.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                            ;
                    

                }
            });
 
        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    Thanks2 th2 = new Thanks2();
                    Desktop desk = Desktop.getDesktop();
                    File dir = new File(th2.plain_text(stuff));
                    try {
                        desk.open(dir);
                    } catch (IOException ex) {
                        Logger.getLogger(Thanks21.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        
        
        
        
        
        
        
        
        /*
        
            submit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
           // System.out.println(pic.getId());
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
            }
        }
    }
                
);  */
        

        
        
        
        submit1.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent e) {
                 stage.hide();
                 displayShelfSample1 ds1 = new displayShelfSample1();
              try {
                       ds1.start(stage);
              } catch (Exception ex) {
                Logger.getLogger(Thanks1.class.getName()).log(Level.SEVERE, null, ex);
              }
       
            }
        });
 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //resultFilePath = file.getAbsolutePath();

 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(openButton, 0, 1);
        GridPane.setConstraints(openMultipleButton, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, openMultipleButton);
        
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        
        
                ///File file = new File("D:/login.css");
                //scene.getStylesheets().add(file.getAbsolutePath());
                 stage.show();
 

        
        
     //   stage.setScene(new Scene(rootGroup));
        
        //Scene scene = new Scene(grid, 700, 700);
        //stage.setScene(scene);
        //scene.getStylesheets().add
 //(TestingFileOPen.class.getResource("Login.css").toExternalForm());
   
       
           }
 
    
    
    public double getSampleWidth() { return 400; }

    public double getSampleHeight() { return 100; }

    public static void main(String[] args) {
        Application.launch(args);
    }
 
    private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }
 
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Thanks1.class.getName()).log(
                Level.SEVERE, null, ex
            );
        }
    }
}

