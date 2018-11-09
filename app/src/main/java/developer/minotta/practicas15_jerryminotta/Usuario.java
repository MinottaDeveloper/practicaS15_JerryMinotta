package developer.minotta.practicas15_jerryminotta;

public class Usuario {

    String Uid, nombre, correo, contrasena;

    public Usuario(){

    }

    public Usuario(String uid, String nombre, String correo, String contrasena) {
        Uid = uid;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

}
