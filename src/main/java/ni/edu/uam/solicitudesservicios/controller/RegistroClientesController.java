package ni.edu.uam.solicitudesservicios.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ni.edu.uam.solicitudesservicios.models.Clientes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

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
    private void initialize(){
        cmbTipo.setItems(FXCollections.observableArrayList(
                "Individual",
                "Empresa",
                "Institucional"
        ));
    }

    @FXML
    private void seleccionarArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Documento");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Imagen JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("Imagen PNG", "*.png"),
                new FileChooser.ExtensionFilter("Imagen JPEG", "*.jpeg")
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
        if (!validarFormulario()){
            return;
        }
        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Cliente registrado",
                "Los datos del cleinte han sido registrado exitosamente."
        );
    }

    @FXML
    private void crearRegistro(){
        if (!validarFormulario()){
            return;
        }
        Clientes cliente = construirClientes();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ni/edu/uam/solicitudesservicios/registro-clientes-view.fxml"));
            Parent root = loader.load();
            SolicitudServicioController controller = loader.getController();
            controller.recibirCliente(cliente);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException e){
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No fue posible abrir el formulario. \n" + e.getMessage()
            );
        }
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
    private void cerrarRegistro(ActionEvent event){
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Desea cerrar la ventana? Los datos no guardados se perderán.");
        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        }
    }

    private boolean validarFormulario() {
        StringBuilder errores = new StringBuilder();
        if (txtNombre.getText() == null || txtNombre.getText().trim().isEmpty()) {
            errores.append("- El Nombre es obligatorio.\n");
        }
        if (txtCorreo.getText() == null || txtCorreo.getText().trim().isEmpty()) {
            errores.append("- El Correo es obligatorio.\n");
        }
        if (txtTelefono.getText() == null || txtTelefono.getText().trim().isEmpty()) {
            errores.append("- El Teléfono es obligatorio.\n");
        }
        if (cmbTipo.getValue() == null) {
            errores.append("- Debe seleccionar un Tipo.\n");
        }
        if (txtArchivo.getText() == null || txtArchivo.getText().trim().isEmpty()) {
            errores.append("- Debe seleccionar un Archivo.\n");
        }
        if (txtDirectorio.getText() == null || txtDirectorio.getText().trim().isEmpty()) {
            errores.append("- Debe agregar un Directorio.\n");
        }
        if (!errores.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos incompletos");
            alerta.setHeaderText("Complete los siguientes campos:");
            alerta.setContentText(errores.toString());
            alerta.showAndWait();
            return true;
        }
        return false;
    }

    private Clientes construirClientes(){
        return new Clientes(
                txtNombre.getText().trim(),
                txtCorreo.getText().trim(),
                txtTelefono.getText().trim(),
                cmbTipo.getValue(),
                txtArchivo.getText().trim(),
                txtDirectorio.getText().trim()
        );
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
