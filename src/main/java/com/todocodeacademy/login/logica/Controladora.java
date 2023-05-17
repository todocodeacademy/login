package com.todocodeacademy.login.logica;

import com.todocodeacademy.login.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis;// = new ControladoraPersistencia();

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    
    public Usuario validarUsuario(String usuario, String contrasenia) {
        
       // String mensaje="";
       Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        for (Usuario usu : listaUsuarios) {  
            if (usu.getNombreUsuario().equals(usuario)) {
                if(usu.getContrasenia().equals(contrasenia)) {
                   // mensaje = "Usuario y contraseña correctos. Bienvenido/a!";
                   usr = usu;
                    return usr;
                }
                else {
                   // mensaje = "Contraseña incorrecta";
                   usr = null;
                    return usr;
                }
            }
            else {
                //mensaje = "Usuario no encontrado";
               // return mensaje;
               usr = null;
                    //return usr;
            }
        
        }
        
        return usr;
        
    }

    public List<Usuario> traerUsuarios() {

           return controlPersis.traerUsuarios();
        
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
        
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        
        Usuario usu = new Usuario ();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado!=null) {
            usu.setUnRol(rolEncontrado);
        }
     
        int id = this.buscarUltimaIdUsuarios();
        usu.setId(id+1);
        
        controlPersis.crearUsuario(usu);
        
        
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        
        for (Rol rol:listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
            
        }
        
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);    
        return usu.getId();
    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario (id_usuario);
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {
        
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado!=null) {
            usu.setUnRol(rolEncontrado);
        }
        
        controlPersis.editarUsuario(usu);
        
        
    }

    
    
}
