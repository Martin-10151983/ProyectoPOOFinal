package Visual;

import logico.Ram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Editar_Ram extends JDialog {
    private Ram memoriaRAM;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField capacidadField;
    private JComboBox<String> tipoMemoriaCombo;
    private JButton button;

    public Editar_Ram(Ver_Componente parent, Ram memoriaRAM) {
        super(parent, "Editar Memoria RAM", true);
        this.memoriaRAM = memoriaRAM;
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 384);
        panel.setLayout(null);

        JLabel label = new JLabel("Marca:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(111, 11, 94, 32);
        panel.add(label);
        marcaField = new JTextField(memoriaRAM.getMarca());
        marcaField.setBounds(229, 11, 94, 32);
        panel.add(marcaField);

        JLabel label_1 = new JLabel("Modelo:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(111, 54, 94, 32);
        panel.add(label_1);
        modeloField = new JTextField(memoriaRAM.getModelo());
        modeloField.setBounds(229, 54, 94, 32);
        panel.add(modeloField);

        JLabel label_2 = new JLabel("Precio:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(111, 97, 94, 32);
        panel.add(label_2);
        precioField = new JTextField(String.valueOf(memoriaRAM.getPrecio()));
        precioField.setBounds(229, 97, 94, 32);
        panel.add(precioField);

        JLabel label_3 = new JLabel("Cantidad Disponible:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(55, 226, 150, 32);
        panel.add(label_3);
        cantidadField = new JTextField(String.valueOf(memoriaRAM.getCantidadDisponible()));
        cantidadField.setBounds(229, 226, 94, 32);
        panel.add(cantidadField);

        JLabel label_4 = new JLabel("Número de Serie:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(65, 183, 140, 32);
        panel.add(label_4);
        numeroSerieField = new JTextField(memoriaRAM.getNumeroSerie());
        numeroSerieField.setBounds(229, 183, 94, 32);
        panel.add(numeroSerieField);

        JLabel label_5 = new JLabel("Capacidad:");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(79, 140, 126, 32);
        panel.add(label_5);
        capacidadField = new JTextField(String.valueOf(memoriaRAM.getCapacidadMemoria()));
        capacidadField.setBounds(229, 140, 94, 32);
        panel.add(capacidadField);

        JLabel label_6 = new JLabel("Tipo de Memoria:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(65, 269, 140, 32);
        panel.add(label_6);
        String[] tiposMemoria = { "DDR3", "DDR4", "DDR5", "DDR6" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(tiposMemoria);
        tipoMemoriaCombo = new JComboBox<>(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR2", "DDR3", "DDR4"}));
        tipoMemoriaCombo.setBounds(229, 269, 94, 32);
        tipoMemoriaCombo.setSelectedItem(memoriaRAM.getTipoMemoria());
        panel.add(tipoMemoriaCombo);

        JButton guardarButton = new JButton("Guardar Cambios");
        guardarButton.setBounds(10, 330, 195, 43);
        guardarButton.addActionListener(this::guardarCambios);
        getContentPane().setLayout(null);
        panel.add(guardarButton);

        getContentPane().add(panel);
        
        button = new JButton("Guardar Cambios");
        button.setBounds(229, 330, 195, 43);
        panel.add(button);

        setLocationRelativeTo(null);
    }

    private void guardarCambios(ActionEvent e) {
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        double precio = Double.parseDouble(precioField.getText());
        int cantidad = Integer.parseInt(cantidadField.getText());
        String numeroSerie = numeroSerieField.getText();
        int capacidad = Integer.parseInt(capacidadField.getText());
        String tipoMemoria = (String) tipoMemoriaCombo.getSelectedItem();

        memoriaRAM.setMarca(marca);
        memoriaRAM.setModelo(modelo);
        memoriaRAM.setPrecio(precio);
        memoriaRAM.setCantidadDisponible(cantidad);
        memoriaRAM.setNumeroSerie(numeroSerie);
        memoriaRAM.setCapacidadMemoria(capacidad);
        memoriaRAM.setTipoMemoria(tipoMemoria);

        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Guardar Cambios", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}