package ni.edu.uam.solicitudesservicios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MenuPrincipalApplication.class.getResource("menu-principal-view.fxml"));
        Scene scene = new Scene(loader.load(), 550,550);
        primaryStage.setTitle("Menú Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
