package Visual;

import javax.swing.*;

import logico.Ram;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_Ram extends JDialog {
    private Tienda tienda;

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField capacidadMemoriaField;
    private JButton btnSalir;
    private JComboBox<String> comboBoxTipoMemoria;

    public Añadir_Ram(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Agregar Memoria RAM", true);
        setResizable(false);
        this.tienda = tienda;

        // Configurar el diálogo
        setSize(515, 403);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void initComponents() {
        // Crear el contenido del diálogo para agregar una Memoria RAM
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Marca:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(133, 11, 102, 27);
        panel.add(label);
        marcaField = new JTextField(20);
        marcaField.setBounds(257, 11, 102, 27);
        panel.add(marcaField);
        JLabel label_1 = new JLabel("Modelo:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(133, 87, 102, 27);
        panel.add(label_1);
        modeloField = new JTextField(20);
        modeloField.setBounds(257, 87, 102, 27);
        panel.add(modeloField);
        JLabel label_2 = new JLabel("Precio:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(133, 49, 102, 27);
        panel.add(label_2);
        precioField = new JTextField(20);
        precioField.setBounds(257, 49, 102, 27);
        panel.add(precioField);
        JLabel label_3 = new JLabel("Cantidad Disponible:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(123, 125, 112, 27);
        panel.add(label_3);
        cantidadField = new JTextField(20);
        cantidadField.setBounds(257, 125, 102, 27);
        panel.add(cantidadField);
        JLabel label_4 = new JLabel("Número de Serie:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(133, 165, 102, 27);
        panel.add(label_4);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(257, 165, 102, 27);
        panel.add(numeroSerieField);
        JLabel label_5 = new JLabel("Capacidad de Memoria:");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(110, 203, 125, 27);
        panel.add(label_5);
        capacidadMemoriaField = new JTextField(20);
        capacidadMemoriaField.setBounds(257, 208, 102, 27);
        panel.add(capacidadMemoriaField);
        JLabel label_6 = new JLabel("Tipo de Memoria:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(133, 246, 102, 27);
        panel.add(label_6);

        // Botón para agregar la Memoria RAM
        JButton botonAgregar = new JButton("Agregar Memoria RAM");
        botonAgregar.setBounds(10, 315, 232, 37);
        panel.add(botonAgregar);

        // Evento al presionar el botón de agregar Memoria RAM
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int cantidadDisponible = Integer.parseInt(cantidadField.getText());
                String numeroSerie = numeroSerieField.getText();
                int capacidadMemoria = Integer.parseInt(capacidadMemoriaField.getText());
                String tipoMemoria = comboBoxTipoMemoria.getSelectedItem().toString();

                // Crear el objeto Memoria RAM y agregarlo a la tienda
                Ram memoriaRAM = new Ram(marca, modelo, precio, cantidadDisponible, numeroSerie, capacidadMemoria, tipoMemoria);
                tienda.agregarComponente(memoriaRAM);
                JOptionPane.showMessageDialog(Añadir_Ram.this, "Memoria RAM agregada exitosamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        // Mostrar el panel en el diálogo
        getContentPane().add(panel);
        
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBounds(257, 315, 232, 37);
        panel.add(btnSalir);
        
        comboBoxTipoMemoria = new JComboBox<String>();
        comboBoxTipoMemoria.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR-2", "DDR-3", "DDR-4"}));
        comboBoxTipoMemoria.setBounds(257, 249, 102, 27);
        panel.add(comboBoxTipoMemoria);
    }
}