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
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear un panel para el contenido de la ventana
        JPanel panel = new JPanel(new BorderLayout());

        // Etiqueta para el título
        JLabel labelTitulo = new JLabel("Agregar Componente");
        panel.add(labelTitulo, BorderLayout.NORTH);

        // ComboBox para seleccionar el tipo de componente
        String[] tiposComponentes = {"Microprocesador", "Disco Duro", "Memoria RAM", "Tarjeta Madre"};
        DefaultComboBoxModel<String> modelTiposComponentes = new DefaultComboBoxModel<>(tiposComponentes);
        JComboBox<String> comboBoxTiposComponentes = new JComboBox<>(modelTiposComponentes);        
        panel.add(comboBoxTiposComponentes, BorderLayout.CENTER);

        // Botón para agregar el componente
        JButton botonAgregarComponente = new JButton("Agregar Componente");
        panel.add(botonAgregarComponente, BorderLayout.SOUTH);

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
        add(panel);

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

    // ...
}