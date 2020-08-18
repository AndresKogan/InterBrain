/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import Vista.VistaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorUsuario implements ActionListener {

    VistaUsuario vistaUsuario;
   ModeloUsuario modeloUsuario;

    public ControladorUsuario(VistaUsuario vistaUsuario, ModeloUsuario modeloUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.modeloUsuario = modeloUsuario;
        vistaUsuario.setVisible(true);
        vistaUsuario.setTitle("Nuevo Usuario");
        vistaUsuario.setLocationRelativeTo(null);
        botones();

    }

    public void botones() {

        vistaUsuario.getBoton_Elegir_Funcion().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vistaUsuario.getBoton_Elegir_Funcion())) {
            if (modeloUsuario.validaCarga(this.vistaUsuario.getNombre().getText())
                    || modeloUsuario.validaCarga(this.vistaUsuario.getApellido().getText())
                    || modeloUsuario.validaCarga(this.vistaUsuario.getDni().getText())) {
                JOptionPane.showMessageDialog(null, "Debe cargar los campos de Nombre, Apellido y Dni");
            } else if (modeloUsuario.validaDNI(this.vistaUsuario.getDni().getText())) {
                JOptionPane.showMessageDialog(null, "El DNI no es válido");
            } else if (modeloUsuario.dniRepetido(modeloUsuario)) {
                JOptionPane.showMessageDialog(null, "Ya hay un alumno con ese DNI cargado ");
            } else {
                this.modeloUsuario.setNombre(this.vistaUsuario.getNombre().getText());
                this.modeloUsuario.setApellido(this.vistaUsuario.getApellido().getText());
                this.modeloUsuario.setDNI(Long.valueOf(this.vistaUsuario.getDni().getText()));
                this.modeloUsuario.cargaDatos(modeloUsuario);
                JOptionPane.showMessageDialog(null, "Usuario cargado con éxito");

                Vista.VistaReserva vistaFuncion = new Vista.VistaReserva();
                Modelo.ModeloReserva modeloFuncion = new Modelo.ModeloReserva();
                ControladorReserva controladorFuncion = new ControladorReserva(vistaFuncion, modeloFuncion);
                this.vistaUsuario.dispose();;

            }
        }

    }
}
