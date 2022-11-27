package dad.cv.controllers;

import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.cv.alertas.AlertDialog;
import dad.cv.models.Contacto;
import dad.cv.models.Email;
import dad.cv.models.Telefono;
import dad.cv.models.TipoTelefono;
import dad.cv.models.Web;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContactoController implements Initializable{

    @FXML private Accordion view;

    @FXML private TableView<Telefono> telefonosTabla;
    @FXML private TableColumn<Telefono, String> numTelefono;
    @FXML private TableColumn<Telefono, String> tipoTelefono;

    @FXML private TableView<Email> correosTabla;
    @FXML private TableColumn<Email, String> direccionMail;

    @FXML private TableView<Web> websTabla;
    @FXML private TableColumn<Web, String> direccionWeb;

    private Contacto c = new Contacto();

    public ContactoController(){
        try{
            FXMLLoader l = new FXMLLoader(getClass().getResource("/vistas/ContactoView.fxml"));
            l.setController(this);
            l.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Accordion getView(){
        return view;
    }

    public void initialize(URL location, ResourceBundle resources){

        //Bindings
        telefonosTabla.itemsProperty().bind(c.telefonosProperty());

		numTelefono.setCellValueFactory(v ->v.getValue().numeroProperty());
		tipoTelefono.setCellValueFactory(v -> v.getValue().tipoProperty().asString());
        
    }

    public void añadirTelefono(){
        AlertDialog a = new AlertDialog();
        c.addTelefono(a.setTelefono());
    }

    public void añadirEmail(){
        AlertDialog a = new AlertDialog();
        c.addEmail(a.setEmail());
    }

    public void añadirWeb(){
        AlertDialog a = new AlertDialog();
        c.addWeb(a.setWeb());
    }

}
