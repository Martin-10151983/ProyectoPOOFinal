package Visual;

import javax.swing.*;

import logico.Disco;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_Disco extends JDialog {
    private Tienda tienda;

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionField;
    private JTextField capacidadAlmacenamientoField;

    public Añadir_Disco(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Agregar Disco Duro", true);
        this.tienda = tienda;

        // Configurar el diálogo
        setSize(493, 357);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void initComponents() {
        // Crear el contenido del diálogo para agregar un Disco Duro
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Marca:");
        label.setBounds(133, 11, 116, 25);
        panel.add(label);
        marcaField = new JTextField(20);
        marcaField.setBounds(259, 11, 116, 25);
        panel.add(marcaField);
        JLabel label_1 = new JLabel("Modelo:");
        label_1.setBounds(133, 47, 116, 25);
        panel.add(label_1);
        modeloField = new JTextField(20);
        modeloField.setBounds(259, 47, 116, 25);
        panel.add(modeloField);
        JLabel label_2 = new JLabel("Precio:");
        label_2.setBounds(133, 83, 116, 25);
        panel.add(label_2);
        precioField = new JTextField(20);
        precioField.setBounds(259, 83, 116, 25);
        panel.add(precioField);
        JLabel label_3 = new JLabel("Cantidad Disponible:");
        label_3.setBounds(133, 119, 116, 25);
        panel.add(label_3);
        cantidadField = new JTextField(20);
        cantidadField.setBounds(259, 117, 116, 25);
        panel.add(cantidadField);
        JLabel label_4 = new JLabel("Número de Serie:");
        label_4.setBounds(133, 155, 116, 25);
        panel.add(label_4);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(259, 153, 116, 25);
        panel.add(numeroSerieField);
        JLabel label_5 = new JLabel("Tipo de Conexión:");
        label_5.setBounds(133, 191, 116, 25);
        panel.add(label_5);
        tipoConexionField = new JTextField(20);
        tipoConexionField.setBounds(259, 189, 116, 25);
        panel.add(tipoConexionField);
        JLabel label_6 = new JLabel("Capacidad de Almacenamiento:");
        label_6.setBounds(77, 227, 172, 25);
        panel.add(label_6);
        capacidadAlmacenamientoField = new JTextField(20);
        capacidadAlmacenamientoField.setBounds(259, 227, 116, 25);
        panel.add(capacidadAlmacenamientoField);

        // Botón para agregar el Disco Duro
        JButton botonAgregar = new JButton("Agregar Disco Duro");
        botonAgregar.setBounds(10, 273, 224, 34);
        panel.add(botonAgregar);

        // Evento al presionar el botón de agregar Disco Duro
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int cantidadDisponible = Integer.parseInt(cantidadField.getText());
                String numeroSerie = numeroSerieField.getText();
                String tipoConexion = tipoConexionField.getText();
                int capacidadAlmacenamiento = Integer.parseInt(capacidadAlmacenamientoField.getText());

                // Crear el objeto Disco Duro y agregarlo a la tienda
                Disco discoDuro = new Disco(marca, modelo, precio, cantidadDisponible, numeroSerie, tipoConexion, capacidadAlmacenamiento);
                tienda.agregarComponente(discoDuro);
                JOptionPane.showMessageDialog(Añadir_Disco.this, "Disco Duro agregado exitosamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        // Mostrar el panel en el diálogo
        getContentPane().add(panel);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(243, 273, 224, 34);
        panel.add(btnSalir);
    }
}