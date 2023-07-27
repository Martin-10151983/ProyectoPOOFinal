package Visual;

import javax.swing.*;

import logico.TarjetaMadre;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Añadir_TarjetaMadre extends JDialog {
    private Tienda tienda;
    private ArrayList<String> conexionesDiscosDurosSeleccionadas;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionMicroprocesadorField;
    private JTextField tipoMemoriaRamField;

    private JCheckBox ideCheckBox;
    private JCheckBox sataCheckBox;
    private JCheckBox sata2CheckBox;
    private JCheckBox sata3CheckBox;
    private JPanel panel;

    public Añadir_TarjetaMadre(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Agregar Tarjeta Madre", true);
        this.tienda = tienda;
        this.conexionesDiscosDurosSeleccionadas = new ArrayList<>();
        setSize(431, 281);
        setLocationRelativeTo(null);
        initComponents();
        
        
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void initComponents() {
        // Crear el contenido del diálogo para agregar una Tarjeta Madre
        panel = new JPanel(new GridLayout(10, 2));
        panel.add(new JLabel("Marca:"));
        marcaField = new JTextField(20);
        panel.add(marcaField);

        panel.add(new JLabel("Modelo:"));
        modeloField = new JTextField(20);
        panel.add(modeloField);

        panel.add(new JLabel("Precio:"));
        precioField = new JTextField(20);
        panel.add(precioField);

        panel.add(new JLabel("Cantidad Disponible:"));
        cantidadField = new JTextField(20);
        panel.add(cantidadField);

        panel.add(new JLabel("Número de Serie:"));
        numeroSerieField = new JTextField(20);
        panel.add(numeroSerieField);

        panel.add(new JLabel("Tipo de Conexión para Microprocesador:"));
        tipoConexionMicroprocesadorField = new JTextField(20);
        panel.add(tipoConexionMicroprocesadorField);

        panel.add(new JLabel("Tipo de Memoria RAM:"));
        tipoMemoriaRamField = new JTextField(20);
        panel.add(tipoMemoriaRamField);

        // Crear los JCheckBox para seleccionar las conexiones de discos duros
        panel.add(new JLabel("Conexiones para Discos Duros:"));
        ideCheckBox = new JCheckBox("IDE");
        panel.add(ideCheckBox);
        sataCheckBox = new JCheckBox("SATA");
        panel.add(sataCheckBox);
        sata2CheckBox = new JCheckBox("SATA-2");
        panel.add(sata2CheckBox);
        sata3CheckBox = new JCheckBox("SATA-3");
        panel.add(sata3CheckBox);

        // Botón para agregar la Tarjeta Madre
        JButton botonAgregar = new JButton("Agregar Tarjeta Madre");
        panel.add(botonAgregar);

        // Evento al presionar el botón de agregar Tarjeta Madre
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int cantidadDisponible = Integer.parseInt(cantidadField.getText());
                String numeroSerie = numeroSerieField.getText();
                String tipoConexionMicroprocesador = tipoConexionMicroprocesadorField.getText();
                String tipoMemoriaRam = tipoMemoriaRamField.getText();

                // Obtener las conexiones de discos duros seleccionadas
                conexionesDiscosDurosSeleccionadas.clear();
                if (ideCheckBox.isSelected()) {
                    conexionesDiscosDurosSeleccionadas.add("IDE");
                }
                if (sataCheckBox.isSelected()) {
                    conexionesDiscosDurosSeleccionadas.add("SATA");
                }
                if (sata2CheckBox.isSelected()) {
                    conexionesDiscosDurosSeleccionadas.add("SATA-2");
                }
                if (sata3CheckBox.isSelected()) {
                    conexionesDiscosDurosSeleccionadas.add("SATA-3");
                }

                // Crear el objeto Tarjeta Madre y agregarlo a la tienda
                TarjetaMadre tarjetaMadre = new TarjetaMadre(marca, modelo, precio, cantidadDisponible, numeroSerie,
                        tipoConexionMicroprocesador, tipoMemoriaRam, conexionesDiscosDurosSeleccionadas);
                tienda.agregarComponente(tarjetaMadre);
                JOptionPane.showMessageDialog(Añadir_TarjetaMadre.this, "Tarjeta Madre agregada exitosamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        // Mostrar el panel en el diálogo
        getContentPane().add(panel);
        pack();
    }
}