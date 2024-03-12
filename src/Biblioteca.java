import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Usuarios> usuarios;
    private ArrayList<Libros> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    public void agregarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public void agregarLibro(Libros libro) {
        libros.add(libro);
    }

    public void mostrarLibrosDisponibles() {
        for (Libros libro : libros) {
            if (libro.isLibrodisponible()) {
                System.out.println(libro.getTitulo());
            }
        }
    }

    public void mostrarLibrosPendientesUsuario(Usuarios usuario) {
        System.out.println(usuario.getNombre());
        for (Libros libro : usuario.getLibrosPendientes()) {
            System.out.println(libro.getTitulo());
        }
    }

    public void pedirLibro(Usuarios usuario, Libros libro) {
        if (libro.isLibrodisponible()) {
            usuario.agregarLibroPendiente(libro);
            libro.setLibrodisponible(false);
            System.out.println("El libro " + libro.getTitulo() + "ha sido prestado a" + usuario.getNombre());
        } else {
            System.out.println("El libro " + libro.getTitulo() + "no está disponible para ser prestado");
        }
    }

    public void devolverLibro(Usuarios usuario, Libros libro) {
        if (usuario.tieneLibroPendiente(libro)) {
            usuario.quitarLibroPendiente(libro);
            libro.setLibrodisponible(true);
            System.out.println("El libro '" + libro.getTitulo() + "ha sido devuelto por " + usuario.getNombre());
        } else {
            System.out.println("El usuario no tiene el libro " + libro.getTitulo() + "pendiente de devolución.");
        }
    }

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Libros> getLibros() {
        return libros;
    }



}
