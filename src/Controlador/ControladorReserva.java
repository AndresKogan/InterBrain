/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloReserva;
import Vista.VistaReserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorReserva implements ActionListener {

    VistaReserva vistaReserva;
    ModeloReserva modeloReserva;

    public ControladorReserva(VistaReserva vistaReserva, ModeloReserva modeloReserva) {
        this.vistaReserva = vistaReserva;
        this.modeloReserva = modeloReserva;
        vistaReserva.setVisible(true);;
        vistaReserva.setTitle("Reserva");
        vistaReserva.setLocationRelativeTo(null);
        boton();
        nombreObra();
        horariosFuncion();
       
        

    }

    public void boton() {
        vistaReserva.getBoton_Siguiente().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource().equals(this.vistaReserva.getBoton_Siguiente())) {

            if ((this.vistaReserva.getHorarios().getSelectedIndex()<0)
                    || modeloReserva.validaCarga(this.vistaReserva.getObras().getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un horario");

            
        } else {
            this.modeloReserva.setDni(this.modeloReserva.dniUsuario().getDNI());
            this.modeloReserva.setNombreObra(this.vistaReserva.getObras().getSelectedItem().toString());
            this.modeloReserva.setHorarios(this.vistaReserva.getHorarios().getItemAt(this.vistaReserva.getHorarios().getSelectedIndex()));
            this.modeloReserva.cargaDatos(modeloReserva);
            JOptionPane.showMessageDialog(null, "reserva realizada con éxito");
            Modelo.ModeloDetalleReserva modeloDetalle = new Modelo.ModeloDetalleReserva();
            Vista.VistaDetalleReserva vis = new Vista.VistaDetalleReserva();
            Controlador.ControladorDetalleReserva controladorDetalle = new Controlador.ControladorDetalleReserva(vis, modeloDetalle);
            this.vistaReserva.dispose();

        }
    }}

    public void horariosFuncion() {
        Set<Time> horarios = this.modeloReserva.horarios();
        Iterator<Time> codIterator = horarios.iterator();
        while (codIterator.hasNext()) {
            this.vistaReserva.getHorarios().addItem(codIterator.next());

        }
    }

    public void nombreObra() {
        Set<String> obras = this.modeloReserva.nombreObras();
        Iterator<String> codIterator = obras.iterator();
        while (codIterator.hasNext()) {
            this.vistaReserva.getObras().addItem(codIterator.next());

        }
    }
   
    
}
