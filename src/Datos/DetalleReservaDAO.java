/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.ModeloReserva;
import Modelo.ModeloUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DetalleReservaDAO extends SQLQuery {
    private ArrayList<ModeloReserva> reservas;
    private ModeloReserva reserva;
    private ArrayList <ModeloUsuario>  usuarios;
    private ModeloUsuario usuario;
    
    
     public ArrayList<ModeloUsuario> traerDatosUsuario() {
        usuarios = new ArrayList();
        try {
            this.conectar("127.0.0.1", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("SELECT * from usuario ORDER BY id ");
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                usuario = new ModeloUsuario();
                usuario.setNombre(resultados.getString(1));
                usuario.setApellido(resultados.getString(2));
                usuario.setDNI(resultados.getLong(3));
                usuarios.add(usuario);
                

            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
      
        return usuarios;
    
}

public ArrayList<ModeloReserva> traerDatosReserva() {
        reservas = new ArrayList();
        try {
            this.conectar("127.0.0.1", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("SELECT * from reserva ORDER BY id ");
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                reserva = new ModeloReserva();
                reserva.setDni(resultados.getLong(1));
                reserva.setNombreObra(resultados.getString(2));
                reserva.setHorarios(resultados.getTime(3));
                
                reservas.add(reserva);
                

            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DetalleReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
      
        return reservas;
    
}}