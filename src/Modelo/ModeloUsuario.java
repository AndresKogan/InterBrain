/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.UsuarioDAO;
import java.sql.Time;

/**
 *
 * @author Usuario
 */
public class ModeloUsuario {
    private String nombre;
    private String apellido;
    private long DNI;

    private UsuarioDAO dato = new UsuarioDAO();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public UsuarioDAO getDato() {
        return dato;
    }

    public void setDato(UsuarioDAO dato) {
        this.dato = dato;
    }

  
    public boolean validaCarga (String a){
    if (a.length()==0){
        return true;
    }
    else {return false;
    
    }}    
    
     public boolean validaDNI (String datos){
        try {DNI = Long.parseLong(datos);
        return false;
        }
        catch (NumberFormatException nfe){
                return true;
    }
    }
     public boolean dniRepetido(ModeloUsuario usuario){
    return dato.dniRepetidoDAO(usuario);
      
    
    }
   
     public boolean cargaDatos (ModeloUsuario modeloUsuario){
        
        return dato.cargaDatosDAO(modeloUsuario);
    }
    
     
     
}
