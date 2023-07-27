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
        setResizable(false);
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
        JLabel labelMarca = new JLabel("Marca:");
        labelMarca.setHorizontalAlignment(SwingConstants.RIGHT);
        labelMarca.setBounds(133, 11, 116, 25);
        panel.add(labelMarca);
        marcaField = new JTextField(20);
        marcaField.setBounds(259, 11, 137, 25);
        panel.add(marcaField);
        JLabel labelModelo = new JLabel("Modelo:");
        labelModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        labelModelo.setBounds(133, 47, 116, 25);
        panel.add(labelModelo);
        modeloField = new JTextField(20);
        modeloField.setBounds(259, 47, 137, 25);
        panel.add(modeloField);
        JLabel labelPrecio = new JLabel("Precio:");
        labelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPrecio.setBounds(133, 83, 116, 25);
        panel.add(labelPrecio);
        precioField = new JTextField(20);
        precioField.setBounds(259, 83, 137, 25);
        panel.add(precioField);
        JLabel labelCantidadDis = new JLabel("Cantidad Disponible:");
        labelCantidadDis.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCantidadDis.setBounds(133, 119, 116, 25);
        panel.add(labelCantidadDis);
        cantidadField = new JTextField(20);
        cantidadField.setBounds(259, 117, 137, 25);
        panel.add(cantidadField);
        JLabel labelNumeroSerie = new JLabel("Número de Serie:");
        labelNumeroSerie.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNumeroSerie.setBounds(133, 155, 116, 25);
        panel.add(labelNumeroSerie);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(259, 153, 137, 25);
        panel.add(numeroSerieField);
        JLabel labelTipoConexion = new JLabel("Tipo de Conexión:");
        labelTipoConexion.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTipoConexion.setBounds(133, 191, 116, 25);
        panel.add(labelTipoConexion);
        tipoConexionField = new JTextField(20);
        tipoConexionField.setBounds(259, 189, 137, 25);
        panel.add(tipoConexionField);
        JLabel labelCapacidad = new JLabel("Capacidad de Almacenamiento:");
        labelCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCapacidad.setBounds(68, 227, 181, 25);
        panel.add(labelCapacidad);
        capacidadAlmacenamientoField = new JTextField(20);
        capacidadAlmacenamientoField.setBounds(259, 227, 137, 25);
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
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBounds(243, 273, 224, 34);
        panel.add(btnSalir);
    }
}