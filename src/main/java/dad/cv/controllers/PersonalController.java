package dad.cv.controllers;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dad.cv.App;
import dad.cv.models.Nacionalidad;
import dad.cv.models.Personal;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable{

    @FXML private GridPane view;

    @FXML private TextField dniLabel, nombreLabel, apellidoLabel, postalLabel, localidadLabel;

    @FXML private TextArea direccionLabel;

    @FXML private DatePicker fechaNacLabel;

    @FXML private ComboBox<String> paisBox;

    @FXML private ListView<Nacionalidad> nacionalidadesList;

    private ListProperty<Nacionalidad> nacionalidades = new SimpleListProperty<>(FXCollections.observableArrayList());;

    private Personal model = new Personal();
    //Constructor 
    public PersonalController(){
    //Carga el documento FXML    
        try{
            FXMLLoader l = new FXMLLoader(getClass().getResource("/vistas/PersonalView.fxml"));
            l.setController(this);
            l.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public GridPane getView(){
        return view;
    }

    public void initialize(URL location, ResourceBundle resources){
        
        //Cargar datos
		try {
			Path paisesFile = Paths.get(getClass().getResource("/csv/paises.csv").toURI());
			Path nacionalidadesFile = Paths.get(getClass().getResource("/csv/nacionalidades.csv").toURI());

			List<String> paises = Files.readAllLines(paisesFile, StandardCharsets.UTF_8);
			paisBox.getItems().setAll(paises); 
			List<String> lista = Files.readAllLines(nacionalidadesFile, StandardCharsets.UTF_8);
            for (String string : lista) {
                nacionalidades.add(new Nacionalidad(string));
            }

        } catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
        //Bindings
        model.identificacionProperty().bind(dniLabel.textProperty());
        model.nombreProperty().bind(nombreLabel.textProperty());
        model.apellidosProperty().bind(apellidoLabel.textProperty());
        model.codigoPostalProperty().bind(postalLabel.textProperty());
        model.localidadProperty().bind(localidadLabel.textProperty());
        model.direccionProperty().bind(direccionLabel.textProperty());
        model.paisProperty().bind(paisBox.getSelectionModel().selectedItemProperty());
        model.fechaNacProperty().bind(fechaNacLabel.valueProperty());
        model.nacionalidadesProperty().bind(nacionalidadesList.itemsProperty());

    }  

    @FXML public void añadirNacionalidad(){
        ChoiceDialog<Nacionalidad> dialog = new ChoiceDialog<>();
		dialog.initOwner(App.stage);
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Añadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad");
		dialog.getItems().setAll(nacionalidades.stream().map(s -> {Nacionalidad n = new Nacionalidad(s.getdenominacion());return n;}).collect(Collectors.toList()));
		dialog.setSelectedItem(dialog.getItems().get(0));
		Nacionalidad nacionalidad = dialog.showAndWait().orElse(null);
		
		if(nacionalidad != null) {
			model.getNacionalidades().add(nacionalidad);
		}
		
    }

    @FXML public void quitarNacionalidad(){
        model.getNacionalidades().remove(nacionalidadesList.getSelectionModel().getSelectedItem());
    }

    public Personal getModel(){
        return model;
    }

}