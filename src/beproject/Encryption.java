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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import beproject.Thanks1;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import encryption.readfiles1;
import pdftotext.Pdfprac2;

/**
 *
 * @author Rohit
 */


public final class Encryption extends Application {
 public static String user_txt;
 public static String ref_key;
    private Desktop desktop = Desktop.getDesktop();
  private static final Image ICON_48 = new Image(Encryption.class.getResourceAsStream("icon-48x48.png"));
    @Override
    public void start(final Stage stage) {
        stage.setTitle("ENCRYPTION");
        final String str,str1;
        GridPane grid = new GridPane();
        
         
        grid.setHgap(10);
        grid.setVgap(40);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        
        
        stage.setResizable(false);
        Scene scene = new Scene(grid,700,700);
      //  stage.setScene(new Scene(grid, 700,700));
 
         stage.setScene(scene);
//         Scene scene1 = new Scene(grid, 700, 700);
  //      primaryStage1.setScene(scene1);
        scene.getStylesheets().add
 (PuzzlePieces.class.getResource("Login.css").toExternalForm());
        stage.show();

 
 
// scene.getStylesheets().add
 //(TestingFileOPen.class.getResource("Login.css").toExternalForm());
 
 
 
 
 
        Text scenetitle = new Text("ENCRYPTION");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 2, 0, 2, 1);
        grid.setAlignment(Pos.CENTER);
        scenetitle.setFill(Color.WHITE);
        
        
        
        Label userName = new Label("PlainText :");
        userName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.add(userName,1,1);
        
        
        
        final TextField userTextField = new TextField();
        userTextField.setPromptText("Enter plaintext");
        userTextField.setMaxHeight(TextField.USE_PREF_SIZE);
        grid.add(userTextField, 2, 1);
       
        
        Button submit = new Button("UPLOAD");
        GridPane.setConstraints(submit, 4, 1);
        grid.getChildren().add(submit);
        submit.setStyle("-fx-base: rgb(30,170,255);"); 
       
      
        
          
        Label pw = new Label("KEY:");
        pw.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(pw, 1, 2);
        
        
       final TextField lastName = new TextField();
       lastName.setPromptText("Enter key.");
       GridPane.setConstraints(lastName, 2, 2);
       grid.getChildren().add(lastName);

        
       
        
        Button submit1 = new Button("UPLOAD");
        GridPane.setConstraints(submit1, 4, 2);
        grid.getChildren().add(submit1);
        submit1.setStyle("-fx-base: rgb(30,170,255);"); 

       
       
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
       
        
        ImageView imageView = new ImageView(ICON_48);
      // Button encrypt = new Button("ENCRYPT");
        Button encrypt = new Button(" ", imageView);
        encrypt.setContentDisplay(ContentDisplay.LEFT);
        
        GridPane.setConstraints(encrypt,1, 4);
        grid.getChildren().add(encrypt);
           encrypt.setStyle("-fx-base: red;");
       
                 final Label message = new Label("");
           
           
        
        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open a Picture...");
        final Button openMultipleButton = new Button("Open Pictures...");     
      
        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        String str;
                    str=file.getAbsolutePath();
                    
                    userTextField.setText(str);
                     //   openFile(file);
                    }
                    

                }
            });
 
        submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);                               
                    List<File> list = 
                        fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                                String str,str1;
                    str=file.getAbsolutePath();
                    
                    str1=str.substring(str.length()-4, str.length());
                    //System.out.println(str);
                    plain_text(str);
                    userTextField.setText(str);
                            //    openFile(file);
                        }
                    }
                }
            });
        
        
        
                submit1.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        openFile(file);
                    }
                }
            });
 
        submit1.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);                               
                    List<File> list = 
                        fileChooser.showOpenMultipleDialog(stage);
                    
                    if (list != null) {
                        for (File file : list) {
                                String str1;
                    str1=file.getAbsolutePath();
                    cipher_text(str1);
                    //System.out.println(str);
                    lastName.setText(str1);
                    
                        }
                        
                  /*  if (list != null) {
                        for (File file : list) {
                            openFile(file);
                        }*/
                    }
                }
            });

 
        
        
        
        
         encrypt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if(!userTextField.getText().matches("") && !lastName.getText().matches("") )
                {
                    //File file = fileChooser.showOpenDialog(stage);
                        
                   // userTextField.getAbsolutePath();
                       // str=userTextField.toString();
                        //str1=str.substring(str.length()-4, 4);
                        //System.out.println(str1);
                    user_txt=userTextField.getText();
                        
                    if(userTextField.getText().contains(".txt"))
                    {
                        ref_key=lastName.getText();
                        
                        stage.hide();
                        Thanks1 ds1 = new Thanks1();
                    try {
                       ds1.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                      }
                    if(lastName.getText().contains(".pdf")){
                        Pdfprac2 pdf = new Pdfprac2();
                        ref_key=pdf.pdftoText(lastName.getText());
                        System.out.println(ref_key);
                        stage.hide();
                        Thanks1 ds1 = new Thanks1();
                    try {
                       ds1.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    
                                        
                    else
                    {
                      actiontarget.setText("invalid file");
                        
                    }
                    }
                        
                        
                    
                
                 else
                {
                    
                    actiontarget.setText(" please enter reference key");
                    actiontarget.setFill(Color.RED);
                    message.setText("PLEASE ENTER REFERENCE KEY");
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
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
                //new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }
 
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Encryption.class.getName()).log(
                Level.SEVERE, null, ex
            );
        }
    }
    public String plain_text(String user_txt){
       return user_txt;
    }
    
    
    public String cipher_text(String ref_key){
        return ref_key;
    }
}
