package Visual;

import logico.TarjetaMadre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editar_TarjetaMadre extends JDialog {
    private TarjetaMadre tarjetaMadre;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionMicroprocesadorField;
    private JTextField tipoMemoriaRamField;
    private JCheckBox sataCheckBox;
    private JCheckBox sata2CheckBox;
    private JCheckBox sata3CheckBox;
    private JButton btnCanc;

    public Editar_TarjetaMadre(Ver_Componente parent, TarjetaMadre tarjetaMadre) {
        super(parent, "Editar Tarjeta Madre", true);
        setResizable(false);
        this.tarjetaMadre = tarjetaMadre;
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Marca:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(96, 11, 134, 29);
        panel.add(label);
        marcaField = new JTextField(tarjetaMadre.getMarca());
        marcaField.setBounds(240, 11, 144, 29);
        panel.add(marcaField);

        JLabel label_1 = new JLabel("Modelo:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(96, 51, 134, 29);
        panel.add(label_1);
        modeloField = new JTextField(tarjetaMadre.getModelo());
        modeloField.setBounds(240, 51, 144, 29);
        panel.add(modeloField);

        JLabel label_2 = new JLabel("Precio:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(96, 91, 134, 29);
        panel.add(label_2);
        precioField = new JTextField(String.valueOf(tarjetaMadre.getPrecio()));
        precioField.setBounds(240, 91, 144, 29);
        panel.add(precioField);

        JLabel label_3 = new JLabel("Cantidad Disponible:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(96, 131, 134, 29);
        panel.add(label_3);
        cantidadField = new JTextField(String.valueOf(tarjetaMadre.getCantidadDisponible()));
        cantidadField.setBounds(240, 131, 144, 29);
        panel.add(cantidadField);

        JLabel label_4 = new JLabel("Número de Serie:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(96, 171, 134, 29);
        panel.add(label_4);
        numeroSerieField = new JTextField(tarjetaMadre.getNumeroSerie());
        numeroSerieField.setBounds(240, 171, 144, 29);
        panel.add(numeroSerieField);

        JLabel label_5 = new JLabel("Tipo de Conexión para Microprocesador:");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(10, 211, 220, 29);
        panel.add(label_5);
        tipoConexionMicroprocesadorField = new JTextField(tarjetaMadre.getTipoConexionMicro());
        tipoConexionMicroprocesadorField.setBounds(240, 211, 144, 29);
        panel.add(tipoConexionMicroprocesadorField);

        JLabel label_6 = new JLabel("Tipo de Memoria RAM:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(96, 251, 134, 29);
        panel.add(label_6);
        tipoMemoriaRamField = new JTextField(tarjetaMadre.getTipoMemoriaRam());
        tipoMemoriaRamField.setBounds(240, 251, 144, 29);
        panel.add(tipoMemoriaRamField);

        JLabel label_7 = new JLabel("Conexiones para Discos Duros:");
        label_7.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7.setBounds(42, 291, 188, 29);
        panel.add(label_7);
        sataCheckBox = new JCheckBox("SATA");
        sataCheckBox.setBounds(240, 291, 144, 29);
        sataCheckBox.setSelected(tarjetaMadre.getConexionesDiscosDuros().contains("SATA"));
        panel.add(sataCheckBox);
        sata2CheckBox = new JCheckBox("SATA-2");
        sata2CheckBox.setBounds(240, 327, 144, 29);
        sata2CheckBox.setSelected(tarjetaMadre.getConexionesDiscosDuros().contains("SATA-2"));
        panel.add(sata2CheckBox);
        sata3CheckBox = new JCheckBox("SATA-3");
        sata3CheckBox.setBounds(240, 359, 144, 29);
        sata3CheckBox.setSelected(tarjetaMadre.getConexionesDiscosDuros().contains("SATA-3"));
        panel.add(sata3CheckBox);

        JButton guardarButton = new JButton("Guardar ");
        guardarButton.setBounds(248, 412, 108, 29);
        guardarButton.addActionListener(this::guardarCambios);
        getContentPane().setLayout(new BorderLayout(0, 0));
        panel.add(guardarButton);

        getContentPane().add(panel);
        
        btnCanc = new JButton("Cancelar");
        btnCanc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCanc.setBounds(366, 412, 108, 29);
        panel.add(btnCanc);

        setLocationRelativeTo(null);
    }

    private void guardarCambios(ActionEvent e) {
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        double precio = Double.parseDouble(precioField.getText());
        int cantidad = Integer.parseInt(cantidadField.getText());
        String numeroSerie = numeroSerieField.getText();
        String tipoConexionMicroprocesador = tipoConexionMicroprocesadorField.getText();
        String tipoMemoriaRam = tipoMemoriaRamField.getText();

        tarjetaMadre.setMarca(marca);
        tarjetaMadre.setModelo(modelo);
        tarjetaMadre.setPrecio(precio);
        tarjetaMadre.setCantidadDisponible(cantidad);
        tarjetaMadre.setNumeroSerie(numeroSerie);
        tarjetaMadre.setTipoConexionMicro(tipoConexionMicroprocesador);
        tarjetaMadre.setTipoMemoriaRam(tipoMemoriaRam);

        tarjetaMadre.getConexionesDiscosDuros().clear();
        if (sataCheckBox.isSelected()) {
            tarjetaMadre.getConexionesDiscosDuros().add("SATA");
        }
        if (sata2CheckBox.isSelected()) {
            tarjetaMadre.getConexionesDiscosDuros().add("SATA-2");
        }
        if (sata3CheckBox.isSelected()) {
            tarjetaMadre.getConexionesDiscosDuros().add("SATA-3");
        }

        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Guardar Cambios", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    
}
