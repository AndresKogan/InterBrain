/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Usuario
 */
public class InterBrain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Vista.VistaUsuario vista = new Vista.VistaUsuario();
      Modelo.ModeloUsuario modelo = new Modelo.ModeloUsuario();
      ControladorUsuario controlador = new ControladorUsuario(vista, modelo);
    
    
}}
