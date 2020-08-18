/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.ModeloUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class UsuarioDAO extends SQLQuery {
    
   
    private ModeloUsuario usuario;

    public void setUsuario(ModeloUsuario usuario) {
        this.usuario = usuario;
    }
    
   public boolean cargaDatosDAO(ModeloUsuario usuario) {
        try {
            
            this.conectar("127.0.0.1", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO usuario (Nombre, Apellido, Dni) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setString(1, usuario.getNombre());
            preparedStmt.setString(2, usuario.getApellido());
            preparedStmt.setLong(3, usuario.getDNI());
            

            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean dniRepetidoDAO(ModeloUsuario usuario){
        
        try{
           this.conectar("127.0.0.1", "interbrain", "root", "mysql");
            this.consulta = this.conn.prepareStatement("select * from usuario where Dni=?");
            this.consulta.setLong(1, usuario.getDNI());
            ResultSet hojadeResultados = consulta.executeQuery();
            if(hojadeResultados.next()){
                return true;              
            }
            this.desconectar();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
   }
}
    

