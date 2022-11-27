package dad.cv;

import dad.cv.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    
    private MainController c = new MainController();
    public static Stage stage;
    @Override public void start(Stage stage) throws Exception {
        App.stage = stage;
        stage.setTitle("MiCV FX");
        stage.setScene(new Scene(c.getView()));
        stage.show();
        
    }

    public static void main(String[] args){
        launch(args);
    }
}