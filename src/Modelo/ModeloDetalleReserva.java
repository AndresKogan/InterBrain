/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Datos.DetalleReservaDAO;
import Datos.ReservaDAO;
import java.sql.Time;
/**
 *
 * @author Usuario
 */
public class ModeloDetalleReserva {
    
    private String nombre;
    private String apellido;
    private String nombreObra;
    private Time horario;
    private DetalleReservaDAO dato = new DetalleReservaDAO();
            
    
      public ModeloUsuario usuarioActual(){
    
    return dato.traerDatosUsuario().get(dato.traerDatosUsuario().size()-1);
    }
    
       public ModeloReserva reservaActual(){
    
    return dato.traerDatosReserva().get(dato.traerDatosReserva().size()-1);
    }
    
    
    
}
