package com.canastacampesina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Sesion {    
    @Id
    @Column(name="Cedula")
    private int cedula;
    @Column(name="Usuario")
    private String usuario;
    @Column(name="Contraseña")
    private String contrasena;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido; 
    @Column(name="Email")
    private String correo;
    @Column(name="Telefono")
    private String telefono;
    @Column(name="Rol")
    private String rol;

    public Sesion() {
    }

    public Sesion(int cedula, String usuario, String contrasena, String nombre, String apellido, String correo, String telefono,
            String rol) {
        this.cedula=cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }

    @Override
    public String toString() {
        String texto = "\n-------------------------------------------";
        texto += "\nUsuario:" + usuario;
        texto += "\nConstraseña: " + contrasena;
        texto += "\nNombre: " + nombre;
        texto += "\nApellido: " + apellido;
        texto += "\nCorreo: " + correo;
        texto += "\nTelefono: " + telefono;
        texto += "\nRol: " + rol;
        texto += "\n--------------------------------------------------------\n";
        return texto;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
        
}