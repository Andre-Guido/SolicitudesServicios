module ni.edu.uam.solicitudesservicios {
    requires javafx.controls;
    requires javafx.fxml;
    opens ni.edu.uam.solicitudesservicios.controller to javafx.fxml;
    opens ni.edu.uam.solicitudesservicios.models to javafx.base;
    opens ni.edu.uam.solicitudesservicios to javafx.fxml;
    exports ni.edu.uam.solicitudesservicios;
}