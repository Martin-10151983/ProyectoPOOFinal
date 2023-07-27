package Visual;

import javax.swing.*;

import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A�adir_Componente extends JDialog {
    private Tienda tienda;

    public A�adir_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "A�adir Componente", true);
        this.tienda = tienda;

        // Configurar la ventana
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear un panel para el contenido de la ventana
        JPanel panel = new JPanel(new BorderLayout());

        // Etiqueta para el t�tulo
        JLabel labelTitulo = new JLabel("Agregar Componente");
        panel.add(labelTitulo, BorderLayout.NORTH);

        // ComboBox para seleccionar el tipo de componente
        String[] tiposComponentes = {"Microprocesador", "Disco Duro", "Memoria RAM", "Tarjeta Madre"};
        DefaultComboBoxModel<String> modelTiposComponentes = new DefaultComboBoxModel<>(tiposComponentes);
        JComboBox<String> comboBoxTiposComponentes = new JComboBox<>(modelTiposComponentes);        
        panel.add(comboBoxTiposComponentes, BorderLayout.CENTER);

        // Bot�n para agregar el componente
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

        // Evento al presionar el bot�n de agregar componente
        botonAgregarComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(A�adir_Componente.this, "Por favor, seleccione un tipo de componente.", "Error", JOptionPane.ERROR_MESSAGE);
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
                A�adir_Microprocesador A�adirMicroprocesador = new A�adir_Microprocesador(null, tienda);
                A�adirMicroprocesador.setTienda(tienda);
                A�adirMicroprocesador.setVisible(true);
                break;
            case "Disco Duro":
                A�adir_Disco A�adirDisco = new A�adir_Disco(null, tienda);
                A�adirDisco.setTienda(tienda);
                A�adirDisco.setVisible(true);
                break;
            case "Memoria RAM":
                A�adir_Ram A�adirRam = new A�adir_Ram(null, tienda);
                A�adirRam.setTienda(tienda);
                A�adirRam.setVisible(true);
                break;
            case "Tarjeta Madre":
                A�adir_TarjetaMadre A�adirTarjetaMadre = new A�adir_TarjetaMadre(null, tienda);
                A�adirTarjetaMadre.setTienda(tienda);
                A�adirTarjetaMadre.setVisible(true);
                break;
        }
    }

    // ...
}