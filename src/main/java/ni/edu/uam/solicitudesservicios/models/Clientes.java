package ni.edu.uam.solicitudesservicios.models;

public class Clientes {
    private String nombre;
    private String correo;
    private int telefono;
    private String tipo;

    public Clientes() {
    }

    public Clientes(String nombre, String correo, int telefono, String tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
