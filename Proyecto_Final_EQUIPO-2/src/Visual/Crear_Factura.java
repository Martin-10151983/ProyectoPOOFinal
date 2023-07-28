package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import java.awt.List;
import javax.swing.JList;
import java.awt.LayoutManager;

public class Crear_Factura extends JDialog {
	private JTextField txtF;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Crear_Factura dialog = new Crear_Factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Crear_Factura() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 135, 297, 84);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA factura");
		lblNewLabel_1.setBounds(20, 36, 63, 14);
		panel.add(lblNewLabel_1);
		
		txtF = new JTextField();
		txtF.setEditable(false);
		txtF.setText("F-0001");
		txtF.setBounds(80, 33, 116, 20);
		panel.add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(20, 70, 46, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(80, 67, 177, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Crear Cliente");
		btnNewButton.setBounds(267, 66, 110, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("Cliente");
		label.setBounds(20, 104, 46, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setText("000-000-0000");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(80, 101, 123, 20);
		panel.add(textField);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(20, 139, 46, 14);
		panel.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 238, 46, 14);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(80, 235, 177, 20);
		panel.add(textField_1);
		
		JLabel lblSelecionarComponentes = new JLabel("Componentes");
		lblSelecionarComponentes.setBounds(20, 286, 149, 14);
		panel.add(lblSelecionarComponentes);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(97, 282, 110, 23);
		panel.add(btnSeleccionar);
		
		JLabel label_1 = new JLabel("Crear nueva factura:");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		getContentPane().add(label_1, BorderLayout.NORTH);
	}
}