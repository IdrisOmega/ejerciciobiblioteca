import java.util.ArrayList;

public class Usuarios {
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private ArrayList<Libros> librosPendientes;

    public Usuarios(String nombre, String apellido, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.librosPendientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Libros> getLibrosPendientes() {
        return librosPendientes;
    }

    public void agregarLibroPendiente(Libros libro) {
        librosPendientes.add(libro);
    }

    public void quitarLibroPendiente(Libros libro) {
        librosPendientes.remove(libro);
    }

    public boolean tieneLibroPendiente(Libros libro) {
        return librosPendientes.contains(libro);
    }
}

