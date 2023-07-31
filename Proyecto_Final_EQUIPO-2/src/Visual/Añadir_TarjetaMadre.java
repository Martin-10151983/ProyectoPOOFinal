package Visual;

import javax.swing.*;

import logico.TarjetaMadre;
import logico.Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_TarjetaMadre extends JDialog {
    private Tienda tienda;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionMicroprocesadorField;
    private JTextField tipoMemoriaRamField;
    private JComboBox<String> conexionesDiscosDurosCombo; // Reemplazamos los JCheckBox por un JComboBox
    private JPanel panel;

    public Añadir_TarjetaMadre(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Agregar Tarjeta Madre", true);
        setResizable(false);
        setAutoRequestFocus(false);
        this.tienda = tienda;
        setSize(509, 412);
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    private void initComponents() {

        panel = new JPanel();
        panel.setLayout(null);

        JLabel label_6 = new JLabel("Marca:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(141, 11, 114, 30);
        panel.add(label_6);
        marcaField = new JTextField(20);
        marcaField.setBounds(265, 11, 137, 30);
        panel.add(marcaField);

        JLabel label_1 = new JLabel("Modelo:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(141, 47, 114, 30);
        panel.add(label_1);
        modeloField = new JTextField(20);
        modeloField.setBounds(265, 47, 137, 30);
        panel.add(modeloField);

        JLabel label_7 = new JLabel("Precio:");
        label_7.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7.setBounds(141, 83, 114, 30);
        panel.add(label_7);
        precioField = new JTextField(20);
        precioField.setBounds(265, 83, 137, 30);
        panel.add(precioField);

        JLabel label_5 = new JLabel("Cantidad Disponible:");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(118, 119, 137, 30);
        panel.add(label_5);
        cantidadField = new JTextField(20);
        cantidadField.setBounds(265, 119, 137, 30);
        panel.add(cantidadField);

        JLabel label_3 = new JLabel("Número de Serie:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(128, 160, 127, 30);
        panel.add(label_3);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(265, 155, 137, 30);
        panel.add(numeroSerieField);

        JLabel label = new JLabel("Tipo de Conexión para Microprocesador:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(20, 191, 235, 30);
        panel.add(label);
        tipoConexionMicroprocesadorField = new JTextField(20);
        tipoConexionMicroprocesadorField.setBounds(265, 191, 137, 30);
        panel.add(tipoConexionMicroprocesadorField);

        JLabel label_2 = new JLabel("Tipo de Memoria RAM:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(105, 227, 150, 30);
        panel.add(label_2);
        tipoMemoriaRamField = new JTextField(20);
        tipoMemoriaRamField.setBounds(265, 227, 137, 30);
        panel.add(tipoMemoriaRamField);

        JLabel label_4 = new JLabel("Conexiones para Discos Duros:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(64, 264, 191, 30);
        panel.add(label_4);

        String[] tiposConexcionDisco = { "SATA", "SATA-2", "SATA-3" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(tiposConexcionDisco);
        conexionesDiscosDurosCombo = new JComboBox<>(new DefaultComboBoxModel(new String[] {"<Seleccione>", "SATA", "SATA-2", "SATA-3"}));
        conexionesDiscosDurosCombo.setBounds(265, 264, 137, 30);
        panel.add(conexionesDiscosDurosCombo);

        JButton botonAgregar = new JButton("Agregar Tarjeta Madre");
        botonAgregar.setBounds(10, 324, 235, 36);
        panel.add(botonAgregar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int cantidadDisponible = Integer.parseInt(cantidadField.getText());
                String numeroSerie = numeroSerieField.getText();
                String tipoConexionMicroprocesador = tipoConexionMicroprocesadorField.getText();
                String tipoMemoriaRam = tipoMemoriaRamField.getText();

                // Obtenemos la conexión seleccionada del JComboBox
                String conexionDiscoSeleccionada = (String) conexionesDiscosDurosCombo.getSelectedItem();

                TarjetaMadre tarjetaMadre = new TarjetaMadre(marca, modelo, precio, cantidadDisponible, numeroSerie,
                        tipoConexionMicroprocesador, tipoMemoriaRam, conexionDiscoSeleccionada);
                tienda.agregarComponente(tarjetaMadre);
                JOptionPane.showMessageDialog(Añadir_TarjetaMadre.this, "Tarjeta Madre agregada exitosamente.", "Agregado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        getContentPane().add(panel);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setBounds(248, 324, 235, 37);
        panel.add(btnSalir);
    }
}