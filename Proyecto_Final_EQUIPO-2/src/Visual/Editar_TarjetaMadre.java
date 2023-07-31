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
	private JComboBox<String> tipoConexcionDiscoCombo;
	private JButton btnCanc;

	public Editar_TarjetaMadre(Ver_Componente parent, TarjetaMadre tarjetaMadre) {
		super(parent, "Editar Tarjeta Madre", true);
		setResizable(false);
		setSize(500, 440);
		this.tarjetaMadre = tarjetaMadre;
		initComponents();
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel label = new JLabel("Marca:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(111, 11, 134, 29);
		panel.add(label);
		marcaField = new JTextField(tarjetaMadre.getMarca());
		marcaField.setBounds(255, 11, 144, 29);
		panel.add(marcaField);

		JLabel label_1 = new JLabel("Modelo:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(111, 51, 134, 29);
		panel.add(label_1);
		modeloField = new JTextField(tarjetaMadre.getModelo());
		modeloField.setBounds(255, 51, 144, 29);
		panel.add(modeloField);

		JLabel label_2 = new JLabel("Precio:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(111, 91, 134, 29);
		panel.add(label_2);
		precioField = new JTextField(String.valueOf(tarjetaMadre.getPrecio()));
		precioField.setBounds(255, 91, 144, 29);
		panel.add(precioField);

		JLabel label_3 = new JLabel("Cantidad Disponible:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(111, 131, 134, 29);
		panel.add(label_3);
		cantidadField = new JTextField(String.valueOf(tarjetaMadre.getCantidadDisponible()));
		cantidadField.setBounds(255, 131, 144, 29);
		panel.add(cantidadField);

		JLabel label_4 = new JLabel("Número de Serie:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(111, 171, 134, 29);
		panel.add(label_4);
		numeroSerieField = new JTextField(tarjetaMadre.getNumeroSerie());
		numeroSerieField.setBounds(255, 171, 144, 29);
		panel.add(numeroSerieField);

		JLabel label_5 = new JLabel("Tipo de Conexión para Microprocesador:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(25, 211, 220, 29);
		panel.add(label_5);
		tipoConexionMicroprocesadorField = new JTextField(tarjetaMadre.getTipoConexionMicro());
		tipoConexionMicroprocesadorField.setBounds(255, 211, 144, 29);
		panel.add(tipoConexionMicroprocesadorField);

		JLabel label_6 = new JLabel("Tipo de Memoria RAM:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(111, 251, 134, 29);
		panel.add(label_6);
		tipoMemoriaRamField = new JTextField(tarjetaMadre.getTipoMemoriaRam());
		tipoMemoriaRamField.setBounds(255, 251, 144, 29);
		panel.add(tipoMemoriaRamField);

		JLabel label_7 = new JLabel("Conexiones para Discos Duros:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(57, 295, 188, 29);
		panel.add(label_7);

		JButton guardarButton = new JButton("Guardar ");
		guardarButton.setBounds(248, 361, 108, 29);
		guardarButton.addActionListener(this::guardarCambios);
		panel.add(guardarButton);

		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel);

		btnCanc = new JButton("Cancelar");
		btnCanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCanc.setBounds(366, 361, 108, 29);
		panel.add(btnCanc);

		String[] tiposConexcionDisco = { "IDE", "SATA", "SATA - 2", "SATA - 3" };
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(tiposConexcionDisco);
		tipoConexcionDiscoCombo = new JComboBox<>(new DefaultComboBoxModel(new String[] {"<Seleccione>", "IDE", "SATA", "SATA - 2", "SATA - 3"}));
		tipoConexcionDiscoCombo.setBounds(255, 295, 144, 29);
		tipoConexcionDiscoCombo.setSelectedItem(tarjetaMadre.getConexionesDiscosDuros());
		panel.add(tipoConexcionDiscoCombo);

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
		String conexionDiscoSeleccionada = (String) tipoConexcionDiscoCombo.getSelectedItem();
		
		tarjetaMadre.setMarca(marca);
		tarjetaMadre.setModelo(modelo);
		tarjetaMadre.setPrecio(precio);
		tarjetaMadre.setCantidadDisponible(cantidad);
		tarjetaMadre.setNumeroSerie(numeroSerie);
		tarjetaMadre.setTipoConexionMicro(tipoConexionMicroprocesador);
		tarjetaMadre.setTipoMemoriaRam(tipoMemoriaRam);
		tarjetaMadre.setConexionesDiscosDuros(conexionDiscoSeleccionada);

		JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Guardar Cambios", JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
}