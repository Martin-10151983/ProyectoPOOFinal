package Visual;

import javax.swing.*;

import logico.Microprocesador;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_Microprocesador extends JDialog {
    private Tienda tienda;

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionMicroField;
    private JTextField velocidadProcesamientoField;

    public Añadir_Microprocesador(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Agregar Microprocesador", true);
        setResizable(false);
        this.tienda = tienda;

       
        setSize(500, 375);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void initComponents() {
       
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label_Marca = new JLabel("Marca:");
        label_Marca.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Marca.setBounds(169, 11, 62, 24);
        panel.add(label_Marca);
        marcaField = new JTextField(20);
        marcaField.setBounds(241, 11, 153, 24);
        panel.add(marcaField);
        JLabel label_Modelo = new JLabel("Modelo:");
        label_Modelo.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Modelo.setBounds(169, 46, 62, 24);
        panel.add(label_Modelo);
        modeloField = new JTextField(20);
        modeloField.setBounds(241, 46, 153, 24);
        panel.add(modeloField);
        JLabel label_Precio = new JLabel("Precio:");
        label_Precio.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Precio.setBounds(169, 81, 62, 24);
        panel.add(label_Precio);
        precioField = new JTextField(20);
        precioField.setBounds(241, 81, 153, 24);
        panel.add(precioField);
        JLabel label_CantidadD = new JLabel("Cantidad Disponible:");
        label_CantidadD.setHorizontalAlignment(SwingConstants.RIGHT);
        label_CantidadD.setBounds(107, 116, 124, 24);
        panel.add(label_CantidadD);
        cantidadField = new JTextField(20);
        cantidadField.setBounds(241, 116, 153, 24);
        panel.add(cantidadField);
        JLabel label_NumeroS = new JLabel("Número de Serie:");
        label_NumeroS.setHorizontalAlignment(SwingConstants.RIGHT);
        label_NumeroS.setBounds(119, 151, 112, 24);
        panel.add(label_NumeroS);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(241, 151, 153, 24);
        panel.add(numeroSerieField);
        JLabel label_Conexion = new JLabel("Tipo de Conexión Microprocesador:");
        label_Conexion.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Conexion.setBounds(32, 186, 199, 24);
        panel.add(label_Conexion);
        tipoConexionMicroField = new JTextField(20);
        tipoConexionMicroField.setBounds(241, 186, 153, 24);
        panel.add(tipoConexionMicroField);
        JLabel label_VelocidadP = new JLabel("Velocidad de Procesamiento:");
        label_VelocidadP.setHorizontalAlignment(SwingConstants.RIGHT);
        label_VelocidadP.setBounds(63, 221, 168, 24);
        panel.add(label_VelocidadP);
        velocidadProcesamientoField = new JTextField(20);
        velocidadProcesamientoField.setBounds(241, 221, 153, 24);
        panel.add(velocidadProcesamientoField);

       
        JButton botonAgregar = new JButton("Agregar Microprocesador");
        botonAgregar.setBounds(10, 288, 227, 37);
        panel.add(botonAgregar);

      
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int cantidadDisponible = Integer.parseInt(cantidadField.getText());
                String numeroSerie = numeroSerieField.getText();
                String tipoConexionMicro = tipoConexionMicroField.getText();
                double velocidadProcesamiento = Double.parseDouble(velocidadProcesamientoField.getText());

               
                Microprocesador microprocesador = new Microprocesador(marca, modelo, precio, cantidadDisponible, numeroSerie, tipoConexionMicro, velocidadProcesamiento);
                tienda.agregarComponente(microprocesador);
                JOptionPane.showMessageDialog(Añadir_Microprocesador.this, "Microprocesador agregado exitosamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

       
        getContentPane().add(panel);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBounds(247, 288, 227, 37);
        panel.add(btnSalir);
    }
}
