package Visual;

import javax.swing.*;

import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_Componente extends JDialog {
    private Tienda tienda;

    public Añadir_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Añadir Componente", true);
        this.tienda = tienda;

        // Configurar la ventana
        setSize(400, 212);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear un panel para el contenido de la ventana
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ComboBox para seleccionar el tipo de componente
        String[] tiposComponentes = {"Microprocesador", "Disco Duro", "Memoria RAM", "Tarjeta Madre"};
        DefaultComboBoxModel<String> modelTiposComponentes = new DefaultComboBoxModel<>(tiposComponentes);
        JComboBox<String> comboBoxTiposComponentes = new JComboBox<>(modelTiposComponentes);        
        comboBoxTiposComponentes.setBounds(201, 28, 144, 47);
        panel.add(comboBoxTiposComponentes);

        // Botón para agregar el componente
        JButton botonAgregarComponente = new JButton("Agregar Componente");
        botonAgregarComponente.setBounds(10, 115, 178, 47);
        panel.add(botonAgregarComponente);

        // Evento al seleccionar un tipo de componente
        comboBoxTiposComponentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoComponenteSeleccionado = (String) comboBoxTiposComponentes.getSelectedItem();
                abrirDialogoAgregarComponente(tipoComponenteSeleccionado);
            }
        });

        // Evento al presionar el botón de agregar componente
        botonAgregarComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Añadir_Componente.this, "Por favor, seleccione un tipo de componente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Mostrar el panel en la ventana
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Tipo de Componente");
        lblNewLabel.setBounds(69, 28, 122, 47);
        panel.add(lblNewLabel);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCancelar.setBounds(196, 115, 178, 47);
        panel.add(btnCancelar);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    private void abrirDialogoAgregarComponente(String tipoComponente) {
        switch (tipoComponente) {
            case "Microprocesador":
                Añadir_Microprocesador AñadirMicroprocesador = new Añadir_Microprocesador(null, tienda);
                AñadirMicroprocesador.setTienda(tienda);
                AñadirMicroprocesador.setVisible(true);
                break;
            case "Disco Duro":
                Añadir_Disco AñadirDisco = new Añadir_Disco(null, tienda);
                AñadirDisco.setTienda(tienda);
                AñadirDisco.setVisible(true);
                break;
            case "Memoria RAM":
                Añadir_Ram AñadirRam = new Añadir_Ram(null, tienda);
                AñadirRam.setTienda(tienda);
                AñadirRam.setVisible(true);
                break;
            case "Tarjeta Madre":
                Añadir_TarjetaMadre AñadirTarjetaMadre = new Añadir_TarjetaMadre(null, tienda);
                AñadirTarjetaMadre.setTienda(tienda);
                AñadirTarjetaMadre.setVisible(true);
                break;
        }
    }
}