/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.ModeloReserva;
import Modelo.ModeloUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ReservaDAO extends SQLQuery {

    private ArrayList<ModeloReserva> funciones;
    private ModeloReserva funcion;
    private ArrayList <ModeloUsuario>  usuarios;
    private ModeloUsuario usuario;

    public ArrayList<ModeloReserva> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<ModeloReserva> funciones) {
        this.funciones = funciones;
    }

 public boolean cargaDatosDAO(ModeloReserva reserva) {
        try {
            
            this.conectar("127.0.0.1", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO reserva (Dni, Nombre_Obra, Horario_Funcion) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setLong(1, reserva.getDni());
            preparedStmt.setString(2, reserva.getNombreObra());
            preparedStmt.setTime(3, reserva.getHorarios());
           

            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 public Set<Time> traerHorarios() {

        Set<Time> horario = new HashSet<>();

        try {
            this.conectar("localhost", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("select horarios from horarios");
            ResultSet resultados = consulta.executeQuery();
            horario.add(null);
            while (resultados.next()) {
                horario.add(resultados.getTime(1));

            }

            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;

    }
 public Set<String> traerObras() {

        Set<String> obras = new HashSet<>();

        try {
            this.conectar("localhost", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("select Nombre_Obra from obras");
            ResultSet resultados = consulta.executeQuery();
            obras.add("");
            while (resultados.next()) {
                obras.add(resultados.getString(1));

            }

            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obras;

    }
 
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
 
   
 
 
 
 

    }}


