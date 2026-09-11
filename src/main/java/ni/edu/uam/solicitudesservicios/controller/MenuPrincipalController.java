package ni.edu.uam.solicitudesservicios.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    @FXML
    private AnchorPane apPrincipal;

    @FXML
    private void abrirRegistroClientes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/solicitudesservicios/registro-clientes-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro Clientes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirSolicitudServicios () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/solicitudesservicios/solicitud-servicios-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Solicitud de Servicios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cerrarPrograma() {
        ((Stage) apPrincipal.getScene().getWindow()).close();
    }
}
