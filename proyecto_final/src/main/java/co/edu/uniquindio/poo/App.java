package co.edu.uniquindio.poo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        SistemaAutenticacion sistema = new SistemaAutenticacion();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Autenticación ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Recuperar contraseña");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("Pregunta de seguridad: ");
                    String pregunta = scanner.nextLine();
                    System.out.print("Respuesta de seguridad: ");
                    String respuesta = scanner.nextLine();
                    System.out.print("Tipo de usuario (empleado/administrador): ");
                    String tipoUsuario = scanner.nextLine().toLowerCase();

                    while (!tipoUsuario.equals("empleado") && !tipoUsuario.equals("administrador")) {
                        System.out.println("Tipo de usuario no válido. Por favor, elige 'empleado' o 'administrador'.");
                        System.out.print("Tipo de usuario: ");
                        tipoUsuario = scanner.nextLine().toLowerCase();
                    }

                    sistema.registrarUsuario(nombreUsuario, contrasena, pregunta, respuesta, tipoUsuario);
                    break;

                case 2:
                    System.out.print("Nombre de usuario: ");
                    String usuarioLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();
                    sistema.iniciarSesion(usuarioLogin, contrasenaLogin);
                    break;

                case 3:
                    System.out.print("Nombre de usuario: ");
                    String usuarioRecuperar = scanner.nextLine();
                    sistema.recuperarContrasena(usuarioRecuperar);
                    break;

                case 4:
                    mostrarMensaje(sistema.toString());
                    break;

                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }
}

