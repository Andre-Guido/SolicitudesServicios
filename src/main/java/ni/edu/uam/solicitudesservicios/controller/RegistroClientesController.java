package ni.edu.uam.solicitudesservicios.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import ni.edu.uam.solicitudesservicios.models.Clientes;

import java.io.File;

public class RegistroClientesController {
    private final ObservableList<Clientes> clientes = FXCollections.observableArrayList();

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbTipo;
    @FXML
    private TextField txtArchivo;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnSeleccionarArchivo;
    @FXML
    private Button btnAgregarDirectorio;

    @FXML
    private void seleccionarArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo TXT", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivo Word", "*.docx")
        );
        File f = fc.showOpenDialog(btnSeleccionarArchivo.getScene().getWindow());
        if (f != null) {
            txtArchivo.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f = dc.showDialog(btnAgregarDirectorio.getScene().getWindow());
        if (f != null) {
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarRegistro(){

    }

    @FXML
    private void crearRegistro(){

    }

    @FXML
    private void limpiarRegistro(){
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtArchivo.clear();
        txtDirectorio.clear();
    }

    @FXML
    private void cerrarRegistro(){

    }
}
