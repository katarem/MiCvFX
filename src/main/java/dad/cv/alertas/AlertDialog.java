package dad.cv.alertas;

import dad.cv.models.Email;
import dad.cv.models.Telefono;
import dad.cv.models.TipoTelefono;
import dad.cv.models.Web;
import javafx.geometry.Insets;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
 
 
public class AlertDialog {

    private String numero, url, email;
    private TipoTelefono t;

    public Telefono setTelefono() {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
         
        TextField text1 = new TextField();
        ChoiceBox<TipoTelefono> choice2 = new ChoiceBox<TipoTelefono>();
        choice2.getItems().add(TipoTelefono.DOMICILIO);
        choice2.getItems().add(TipoTelefono.MOVIL);
        Button button = new Button("Submit");
        button.setOnAction(e -> {
             numero = text1.getText();
             t = choice2.getValue();
             stage.close();
        });
     
        Label label1 = new Label("Introduzca el nuevo número de teléfono.");
        Label label2 = new Label("Número:");
        Label label3 = new Label("Tipo:");
         
        GridPane layout = new GridPane();
         
        layout.setPadding(new Insets(10, 10, 10, 10)); 
        layout.setVgap(5); 
        layout.setHgap(5); 
         
        layout.add(text1, 1,1);
        layout.add(choice2, 1,2);
        layout.add(button, 1,3);
        layout.add(label1, 1,0);
        layout.add(label2, 0,1);
        layout.add(label3, 0,2);
         
        Scene scene = new Scene(layout, 250, 150);          
        stage.setTitle("Nuevo teléfono");
        stage.setScene(scene);
        stage.showAndWait();
         
        return new Telefono(numero,t);
    }

    public Email setEmail() {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
         
        TextField text1 = new TextField();
         
        Button button = new Button("Submit");
        button.setOnAction(e -> {
             email = text1.getText();
             stage.close();
        });
     
        Label label1 = new Label("Introduzca Email.");
        Label label2 = new Label("e-mail:");
         
        GridPane layout = new GridPane();
         
        layout.setPadding(new Insets(10, 10, 10, 10)); 
        layout.setVgap(5); 
        layout.setHgap(5); 
         
        layout.add(text1, 1,1);
        layout.add(button, 1,3);
        layout.add(label1, 1,0);
        layout.add(label2, 0,1);
         
        Scene scene = new Scene(layout, 250, 150);          
        stage.setTitle("Nuevo e-mail");
        stage.setScene(scene);
        stage.showAndWait();
         
        return new Email(email);
    }

    public Web setWeb() {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
         
        TextField text1 = new TextField();
         
        Button button = new Button("Submit");
        button.setOnAction(e -> {
             url = text1.getText();
             stage.close();
        });
     
        Label label1 = new Label("Introduzca web.");
        Label label2 = new Label("URL:");
         
        GridPane layout = new GridPane();
         
        layout.setPadding(new Insets(10, 10, 10, 10)); 
        layout.setVgap(5); 
        layout.setHgap(5); 
         
        layout.add(text1, 1,1);
        layout.add(button, 1,3);
        layout.add(label1, 1,0);
        layout.add(label2, 0,1);
         
        Scene scene = new Scene(layout, 250, 150);          
        stage.setTitle("Nueva web.");
        stage.setScene(scene);
        stage.showAndWait();
         
        return new Web(url);
    }
    }
