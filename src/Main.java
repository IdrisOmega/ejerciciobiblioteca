import java.util.Scanner;











public class Main {
    public static void main(String[] args) {
        Libros libro1 = new Libros("Principito", "Antoine Marie Jean-Baptiste Roger", "GH&675JFH", true);
        Libros libro2 = new Libros("Geronimo Steelton", "Antoine Marie Jean-Baptiste Roger", "WERXV4235V", true);
        Libros libro3 = new Libros("IT", "Stephen King", "SDKF54654KLJ", true);
        Libros libro4 = new Libros("Hercule Poirot", "Agatha Christie", "SDFJ45JLKJ", true);

        Usuarios usuario1 = new Usuarios("Pablo", "Prerez", 698234567, "pablo@gmail.com");
        Usuarios usuario2 = new Usuarios("Soraya", "Vilas", 678234092, "soraya@gmail.com");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);

        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        Scanner scanner = new Scanner(System.in);

        boolean menuActivo = true;
        while (menuActivo) {
            System.out.println("""
                Menú:
                1. Ver libros disponibles
                2. Ver libros a devolver
                3. Pedir un libro
                4. Devolver un libro
                5. Salir
                Elija una opción:""");
            int opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.println("Libros disponibles:");
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del usuario para ver los libros a devolver:");
                    scanner.nextLine();
                    String nombreUsuario = scanner.nextLine();
                    Usuarios usuario = buscarUsuario(nombreUsuario, biblioteca);
                    if (usuario != null) {
                        biblioteca.mostrarLibrosPendientesUsuario(usuario);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del usuario:");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    Usuarios usuarioPedido = buscarUsuario(nombre, biblioteca);
                    if (usuarioPedido != null) {
                        System.out.println("Ingrese el título del libro que desea pedir:");
                        String tituloLibroPedido = scanner.nextLine();
                        Libros libroPedido = buscarLibro(tituloLibroPedido, biblioteca);
                        if (libroPedido != null) {
                            biblioteca.pedirLibro(usuarioPedido, libroPedido);
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del usuario:");
                    scanner.nextLine();
                    String nombreDevolver = scanner.nextLine();
                    Usuarios usuarioDevolver = buscarUsuario(nombreDevolver, biblioteca);
                    if (usuarioDevolver != null) {
                        System.out.println("Ingrese el título del libro que desea devolver:");
                        String tituloLibroDevolver = scanner.nextLine();
                        Libros libroDevolver = buscarLibro(tituloLibroDevolver, biblioteca);
                        if (libroDevolver != null) {
                            biblioteca.devolverLibro(usuarioDevolver, libroDevolver);
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    menuActivo = false;
                    break;

            }
        }

        scanner.close();
    }

    private static Usuarios buscarUsuario(String nombre, Biblioteca biblioteca) {
        for (Usuarios usuario : biblioteca.getUsuarios()) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    private static Libros buscarLibro(String titulo, Biblioteca biblioteca) {
        for (Libros libro : biblioteca.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}