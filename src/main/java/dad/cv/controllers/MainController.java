package dad.cv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{

    //Variables FXML
    @FXML private AnchorPane view;
    @FXML private TabPane tabsPane;
    @FXML private MenuBar menuPane, menuArchivo, menuHelp;
    @FXML private Tab personalTab, contactoTab, formacionTab, experienciaTab, conocimientosTab;
    @FXML private MenuItem newItem, openItem, saveItem, saveasItem, exitItem, aboutItem;

    //Controladores
    private PersonalController personalc = new PersonalController();
    private ContactoController contactoc = new ContactoController();

    //Constructor del controlador
    public MainController(){
        try{
            FXMLLoader l = new FXMLLoader(getClass().getResource("/vistas/MainView.fxml"));
            l.setController(this);
            l.load();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

   

    //Obtener view para que otro handler lo utilice
    public AnchorPane getView(){
        return view;
    }

    public void initialize(URL location, ResourceBundle resources) {
         //Asignación de pestañas:
        personalTab.setContent(personalc.getView());
        contactoTab.setContent(contactoc.getView());
        // formacionTab.setContent(menuPane);
        // experienciaTab.setContent(menuPane);
        // conocimientosTab.setContent(menuPane);

        //Menus:
        //Menu 1:
        newItem = new MenuItem();
        newItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/nuevo.gif"))));

    }
}
