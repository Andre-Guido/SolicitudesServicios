package ni.edu.uam.solicitudesservicios.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SolicitudServicioController {
    private final ObservableList<String> tiposServicio = FXCollections.observableArrayList(
            "Soporte Técnico",
            "Mantenimiento",
            "Instalación de Software",
            "Instalación de Hardware",
            "Configuración de Red",
            "Recuperación de Datos",
            "Capacitación",
            "Otro"
    );

    @FXML
    private TextField txtCliente;
    @FXML
    private TextField txtCorreoCliente;
    @FXML
    private TextField txtTipoCliente;
    @FXML
    private TextField txtAsunto;
    @FXML
    private ComboBox<String> cmbServicio;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtArchivoSolicitud;
    @FXML
    private TextField txtEvidencia;
    @FXML
    private Button btnGuardarSolicitud;
    @FXML
    private Button btnCrearSolicitud;
    @FXML
    private Button btnLimpiarSolicitud;
    @FXML
    private Button btnCerrarSolicitud;

    @FXML
    private void initialize() {
        cmbServicio.setItems(tiposServicio);
    }

    @FXML
    private void guardarSolicitud() {

    }

    @FXML
    private void crearsolicitud() {

    }

    @FXML
    private void limpiarSolicitud() {
        txtCliente.clear();
        txtCorreoCliente.clear();
        txtTipoCliente.clear();
        txtAsunto.clear();
        cmbServicio.getSelectionModel().clearSelection();
        txtDescripcion.clear();
        txtArchivoSolicitud.clear();
        txtEvidencia.clear();
    }

    @FXML
    private void cerrarSolicitud() {
        ((javafx.stage.Stage) btnCerrarSolicitud.getScene().getWindow()).close();
    }
}
