package co.edu.uniquindio.poo;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String preguntaSeguridad;
    private String respuestaSeguridad;
    private String tipoUsuario;

    public Usuario(String nombreUsuario, String contrasena, String preguntaSeguridad, String respuestaSeguridad, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.preguntaSeguridad = preguntaSeguridad;
        this.respuestaSeguridad = respuestaSeguridad;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    public boolean verificarRespuestaSeguridad(String respuesta) {
        return this.respuestaSeguridad.equalsIgnoreCase(respuesta);
    }

    public void setContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario + " | Tipo: " + tipoUsuario;
    }
}