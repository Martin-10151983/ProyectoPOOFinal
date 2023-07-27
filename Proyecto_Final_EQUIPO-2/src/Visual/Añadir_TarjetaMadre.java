package Visual;

import javax.swing.*;

import logico.TarjetaMadre;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dialog.ModalExclusionType;

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
	private JCheckBox sataCheckBox;
	private JCheckBox sata2CheckBox;
	private JCheckBox sata3CheckBox;
	private JPanel panel;

	public Añadir_TarjetaMadre(InterfazPrincipal parent, Tienda tienda) {
		super(parent, "Agregar Tarjeta Madre", true);
		setAutoRequestFocus(false);
		this.tienda = tienda;
		this.conexionesDiscosDurosSeleccionadas = new ArrayList<>();
		setSize(509, 470);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);


	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	private void initComponents() {
		// Crear el contenido del diálogo para agregar una Tarjeta Madre
		panel = new JPanel();
		panel.setLayout(null);
		JLabel label_6 = new JLabel("Marca:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(152, 11, 114, 30);
		panel.add(label_6);
		marcaField = new JTextField(20);
		marcaField.setBounds(276, 11, 137, 30);
		panel.add(marcaField);
		JLabel label_1 = new JLabel("Modelo:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(152, 47, 114, 30);
		panel.add(label_1);
		modeloField = new JTextField(20);
		modeloField.setBounds(276, 47, 137, 30);
		panel.add(modeloField);
		JLabel label_7 = new JLabel("Precio:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(152, 83, 114, 30);
		panel.add(label_7);
		precioField = new JTextField(20);
		precioField.setBounds(276, 83, 137, 30);
		panel.add(precioField);
		JLabel label_5 = new JLabel("Cantidad Disponible:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(129, 119, 137, 30);
		panel.add(label_5);
		cantidadField = new JTextField(20);
		cantidadField.setBounds(276, 119, 137, 30);
		panel.add(cantidadField);
		JLabel label_3 = new JLabel("Número de Serie:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(139, 160, 127, 30);
		panel.add(label_3);
		numeroSerieField = new JTextField(20);
		numeroSerieField.setBounds(276, 155, 137, 30);
		panel.add(numeroSerieField);
		JLabel label = new JLabel("Tipo de Conexión para Microprocesador:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(31, 191, 235, 30);
		panel.add(label);
		tipoConexionMicroprocesadorField = new JTextField(20);
		tipoConexionMicroprocesadorField.setBounds(276, 191, 137, 30);
		panel.add(tipoConexionMicroprocesadorField);
		JLabel label_2 = new JLabel("Tipo de Memoria RAM:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(116, 227, 150, 30);
		panel.add(label_2);
		tipoMemoriaRamField = new JTextField(20);
		tipoMemoriaRamField.setBounds(276, 227, 137, 30);
		panel.add(tipoMemoriaRamField);
		JLabel label_4 = new JLabel("Conexiones para Discos Duros:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(75, 264, 191, 30);
		panel.add(label_4);
		sataCheckBox = new JCheckBox("SATA");
		sataCheckBox.setBounds(276, 264, 114, 30);
		panel.add(sataCheckBox);
		sata2CheckBox = new JCheckBox("SATA-2");
		sata2CheckBox.setBounds(276, 297, 114, 30);
		panel.add(sata2CheckBox);
		sata3CheckBox = new JCheckBox("SATA-3");
		sata3CheckBox.setBounds(276, 330, 114, 30);
		panel.add(sata3CheckBox);

		// Botón para agregar la Tarjeta Madre
		JButton botonAgregar = new JButton("Agregar Tarjeta Madre");
		botonAgregar.setBounds(10, 384, 247, 36);
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
		
		getContentPane().add(panel);
		
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBounds(265, 384, 218, 37);
        panel.add(btnSalir);
	}
}