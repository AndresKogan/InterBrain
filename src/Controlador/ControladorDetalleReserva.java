/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloDetalleReserva;
import Vista.VistaDetalleReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorDetalleReserva implements ActionListener{
    VistaDetalleReserva vistaDetalleReserva;
    ModeloDetalleReserva modeloDetalleReserva;

    public ControladorDetalleReserva(VistaDetalleReserva vistaDetalleReserva, ModeloDetalleReserva modeloDetalleReserva) {
    this.modeloDetalleReserva = modeloDetalleReserva;    
    this.vistaDetalleReserva = vistaDetalleReserva;
       vistaDetalleReserva.setVisible(true);;
        vistaDetalleReserva.setTitle("Detalle");
        vistaDetalleReserva.setLocationRelativeTo(null);
        cargarDatos();
        boton();
        vistaDetalleReserva.getTextoApellido().setEditable(false);
        vistaDetalleReserva.getTextoHorario().setEditable(false);
        vistaDetalleReserva.getTextoNombre().setEditable(false);
        vistaDetalleReserva.getTextoObra().setEditable(false);
    }

    
    public void cargarDatos(){
       
   vistaDetalleReserva.getTextoApellido().setText(this.modeloDetalleReserva.usuarioActual().getApellido());
   vistaDetalleReserva.getTextoNombre().setText(this.modeloDetalleReserva.usuarioActual().getNombre());
   vistaDetalleReserva.getTextoObra().setText(this.modeloDetalleReserva.reservaActual().getNombreObra());
   vistaDetalleReserva.getTextoHorario().setText(String.valueOf(this.modeloDetalleReserva.reservaActual().getHorarios()));
    }
    
    public void boton(){
   vistaDetalleReserva.getBotonTerminar().addActionListener(this);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JOptionPane.showMessageDialog(null, "Gracias por su reserva");
       vistaDetalleReserva.dispose();  }
    
   
    
    
    
    
}
