package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAutenticacion {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(String nombreUsuario, String contrasena, String preguntaSeguridad, String respuestaSeguridad, String tipoUsuario) {
        usuarios.add(new Usuario(nombreUsuario, contrasena, preguntaSeguridad, respuestaSeguridad, tipoUsuario));
        System.out.println("Usuario registrado con éxito como " + tipoUsuario + ".");
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getTipoUsuario() + ".");
                return true;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos.");
        return false;
    }

    public void recuperarContrasena(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Pregunta de seguridad: " + usuario.getPreguntaSeguridad());
                System.out.print("Respuesta: ");
                String respuesta = scanner.nextLine();

                if (usuario.verificarRespuestaSeguridad(respuesta)) {
                    System.out.print("Introduce la nueva contraseña: ");
                    String nuevaContrasena = scanner.nextLine();
                    usuario.setContrasena(nuevaContrasena);
                    System.out.println("Contraseña actualizada con éxito.");
                } else {
                    System.out.println("Respuesta incorrecta.");
                }
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Usuarios registrados:\n");
        for (Usuario usuario : usuarios) {
            sb.append(usuario).append("\n");
        }
        return sb.toString();
    }
}
