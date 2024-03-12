import java.util.ArrayList;

public class Libros {
    String titulo;
    String autor;
    String isbn;
    boolean librodisponible;


    public Libros(String titulo, String autor, String isbn, boolean librodisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.librodisponible = librodisponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isLibrodisponible() {
        return librodisponible;
    }

    public void setLibrodisponible(boolean librodisponible) {
        this.librodisponible = librodisponible;
    }

}

