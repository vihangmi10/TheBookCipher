/*
 * Copyright (c) 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package beproject;









import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    
    
    public  static class ValidationResult  extends Login {
    public enum Type { ERROR, WARNING, SUCCESS }
    private final String message;
    private final Type type;

    public ValidationResult(String message, Type type) {
        this.message = message;
        this.type = type;
    }

    public final String getMessage() {
        return message;
    }

    public final Type getType() {
        return type;
    }
}    

private static interface Validator<C extends Control> {
    public ValidationResult validate(C control);
}

public static class ValidationEvent extends Event {
    public static final EventType<ValidationEvent> ANY =
            new EventType<ValidationEvent>(Event.ANY, "VALIDATION");

    private final ValidationResult result;

    public ValidationEvent(ValidationResult result) {
        super(ANY);
        this.result = result;
    }

    public final ValidationResult getResult() { return result; }
}

private abstract class ValidatorPane<C extends Control> extends Region {
    /**
     * The content for the validator pane is the control it should work with.
     */
    private ObjectProperty<C> content = new SimpleObjectProperty<C>(this, "content", null);
    public final C getContent() { return content.get(); }
    public final void setContent(C value) { content.set(value); }
    public final ObjectProperty<C> contentProperty() { return content; }

    /**
     * The validator
     */
    private ObjectProperty<Validator<C>> validator = new SimpleObjectProperty<Validator<C>>(this, "validator");
    public final Validator<C> getValidator() { return validator.get(); }
    public final void setValidator(Validator<C> value) { validator.set(value); }
    public final ObjectProperty<Validator<C>> validatorProperty() { return validator; }

    /**
     * The validation result
     */
    private ReadOnlyObjectWrapper<ValidationResult> validationResult = new ReadOnlyObjectWrapper<ValidationResult>(this, "validationResult");
    public final ValidationResult getValidationResult() { return validationResult.get(); }
    public final ReadOnlyObjectProperty<ValidationResult> validationResultProperty() { return validationResult.getReadOnlyProperty(); }

    /**
     *  The event handler
     */
    private ObjectProperty<EventHandler<ValidationEvent>> onValidation =
            new SimpleObjectProperty<EventHandler<ValidationEvent>>(this, "onValidation");
    public final EventHandler<ValidationEvent> getOnValidation() { return onValidation.get(); }
    public final void setOnValidation(EventHandler<ValidationEvent> value) { onValidation.set(value); }
    public final ObjectProperty<EventHandler<ValidationEvent>> onValidationProperty() { return onValidation; }

    public ValidatorPane() {
        content.addListener(new ChangeListener<Control>() {
            public void changed(ObservableValue<? extends Control> ov, Control oldValue, Control newValue) {
                if (oldValue != null) getChildren().remove(oldValue);
                if (newValue != null) getChildren().add(0, newValue);
            }
        });
    }

    protected void handleValidationResult(ValidationResult result) {
        getStyleClass().removeAll("validation-error", "validation-warning");
        if (result != null) {
            if (result.getType() == ValidationResult.Type.ERROR) {
                getStyleClass().add("validation-error");
            } else if (result.getType() == ValidationResult.Type.WARNING) {
                getStyleClass().add("validation-warning");
            }
        }
        validationResult.set(result);
        fireEvent(new ValidationEvent(result));
    }

    @Override
    protected void layoutChildren() {
        Control c = content.get();
        if (c != null) {
            c.resizeRelocate(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    protected double computeMaxHeight(double d) {
        Control c = content.get();
        return c == null ? super.computeMaxHeight(d) : c.maxHeight(d);
    }

    @Override
    protected double computeMinHeight(double d) {
        Control c = content.get();
        return c == null ? super.computeMinHeight(d) : c.minHeight(d);
    }

    @Override
    protected double computePrefHeight(double d) {
        Control c = content.get();
        return c == null ? super.computePrefHeight(d) : c.prefHeight(d);
    }

    @Override
    protected double computePrefWidth(double d) {
        Control c = content.get();
        return c == null ? super.computePrefWidth(d) : c.prefWidth(d);
    }

    @Override
    protected double computeMaxWidth(double d) {
        Control c = content.get();
        return c == null ? super.computeMaxWidth(d) : c.maxWidth(d);
    }

    @Override
    protected double computeMinWidth(double d) {
        Control c = content.get();
        return c == null ? super.computeMinWidth(d) : c.minWidth(d);
    }
}


private class TextInputValidatorPane<C extends TextInputControl> extends ValidatorPane<C> {

    private InvalidationListener textListener = new InvalidationListener() {           
        @Override public void invalidated(Observable o) {
            final Validator v = getValidator();
            final ValidationResult result = v != null ?
                v.validate(getContent()) :
                new ValidationResult("", ValidationResult.Type.SUCCESS);

            handleValidationResult(result);
        }
    };

    public TextInputValidatorPane() {
        contentProperty().addListener(new ChangeListener<C>() {                
            @Override public void changed(ObservableValue<? extends C> ov, C oldValue, C newValue) {
                if (oldValue != null) oldValue.textProperty().removeListener(textListener);
                if (newValue != null) newValue.textProperty().addListener(textListener);
            }
        });
    }

    public TextInputValidatorPane(C field) {
        this();
        setContent(field);
    }

}    

        
    
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage1) {
        primaryStage1.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        scenetitle.setFill(Color.WHITE);

        Label userName = new Label("User Name:");
       // grid.
        grid.add(userName, 0, 1);
        
        //final TextField userTextField = new TextField();
        //grid.add(userTextField, 1, 1);

         final Label message = new Label("");
        
        
       String validatorCss = Login.class.getResource("Validators.css").toExternalForm();
         
         
        final TextField userTextField = new TextField();
        userTextField.setPromptText("Enter username");
        userTextField.setMaxHeight(TextField.USE_PREF_SIZE);
        //grid.add(userTextField, 1, 1);

        TextInputValidatorPane<TextField> pane = new TextInputValidatorPane<TextField>();
        pane.setContent(userTextField);
        pane.setValidator(new Validator<TextField>() {
            public ValidationResult validate(TextField control) {
                try {
                    String text = control.getText();
                    if (text == null || text.trim().equals("")) return null;
                   // double d = Double.parseDouble(text);
                    
                    
                    
                    
                    if (control.getLength() < 5) {
                        return new ValidationResult("Should be > 1000", ValidationResult.Type.WARNING);
                    }
                    return null; // succeeded
                } catch (Exception e) {
                    // failed
                    return new ValidationResult("Bad number", ValidationResult.Type.ERROR);
                }
            }
        });
        
        
        
        
        StackPane rootSP = new StackPane();
        rootSP.setPadding(new Insets(12));
        rootSP.getChildren().add(pane);
        pane.getStylesheets().add(validatorCss);
        grid.add(rootSP,1,1);
        
    
        
        
        
        

         
         
        /*
         userTextField.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        if (!userTextField.getText().matches()) {
            message.setText("Your password is incorrect!");
            message.setTextFill(Color.rgb(210, 39, 30));
        } else {
            message.setText("Your password has been confirmed");
            message.setTextFill(Color.rgb(21, 117, 84));
        }
        userTextField.clear();
    }
});
        
        
        */
        
        
        
        
        
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

       final PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        
        
        
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
           
        
        
        
        

        
        
        
        
        
        
        
        

 

        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            
            
            
            @Override
            public void handle(ActionEvent e) {
                
          if ( userTextField.getText().matches("RASIKA")) {
               actiontarget.setText("valid username");
               actiontarget.setFill(Color.BLUE);
              message.setText("good");
              primaryStage1.hide();
                 displayShelfSample1 ds1 = new displayShelfSample1();
              try {
                       ds1.start(primaryStage1);
              } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

              
              }
          }
              else {
              message.setText("try again");
            actiontarget.setText(" try again");
            actiontarget.setFill(Color.RED);
            userTextField.clear();
        }
        //userTextField.clear();      
                
                
                //actiontarget.setFill(Color.FIREBRICK);
                //actiontarget.setText("Sign in button pressed");
            }
        });  

        Scene scene = new Scene(grid, 700, 700);
        primaryStage1.setScene(scene);
        scene.getStylesheets().add
 (Login.class.getResource("Login.css").toExternalForm());
        primaryStage1.show();
    }
}
/*
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import beproject.displayShelfSample;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage1) {
        primaryStage1.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
                 primaryStage1.hide();
                 displayShelfSample1 ds1 = new displayShelfSample1();
              try {
                       ds1.start(primaryStage1);
              } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
              }
       
            }
        });

        Scene scene = new Scene(grid, 700, 700);
        primaryStage1.setScene(scene);
        scene.getStylesheets().add
 (Login.class.getResource("Login.css").toExternalForm());
        primaryStage1.show();
    }
}*/