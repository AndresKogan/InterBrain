/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.ReservaDAO;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class ModeloReserva {
    
    private long Dni;
    private String nombreObra;
   
    private Time Horarios;
    private ReservaDAO dato = new ReservaDAO();

    public long getDni() {
        return Dni;
    }

    public void setDni(long Dni) {
        this.Dni = Dni;
    }
            
    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

  
    public Time getHorarios() {
        return Horarios;
    }

    public void setHorarios(Time Horarios) {
        this.Horarios = Horarios;
    }
    
    public Set <Time> horarios(){
    
        return dato.traerHorarios();
    
    }
    public Set <String> nombreObras(){
    
        return dato.traerObras();
    
    }
    
    public ModeloUsuario dniUsuario(){
    
    return dato.traerDatosUsuario().get(dato.traerDatosUsuario().size()-1);
    }
    
   
     public boolean cargaDatos(ModeloReserva modeloFunciones) {

        return dato.cargaDatosDAO(modeloFunciones);
    }
    
    
    
    public boolean validaCarga(String a) {
        if (a.length() == 0) {
            return true;
        } else {
            return false;

        }
    }
}
