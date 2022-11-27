package dad.cv.controllers;

import java.util.ArrayList;

import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.cv.models.Titulo;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FormacionController implements Initializable{

    @FXML private AnchorPane view;


    private ArrayList<Titulo> formacion = new ArrayList<Titulo>();

    public FormacionController(){
        try{
            FXMLLoader l = new FXMLLoader(getClass().getResource("/vistas/FormacionView.fxml"));
            l.setController(this);
            l.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public AnchorPane getView(){
        return view;
    }

    public void añadir(){
        formacion.add(new Titulo(null, null, null, null));
    }

    public void initialize(URL location, ResourceBundle resources){


    }

}
