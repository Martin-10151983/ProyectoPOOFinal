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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crear_Factura extends JDialog {
	private JTextField txtF;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA factura");
		lblNewLabel_1.setBounds(20, 36, 63, 14);
		panel.add(lblNewLabel_1);
		
		txtF = new JTextField();
		txtF.setEditable(false);
		txtF.setText("F-0001");
		txtF.setBounds(80, 33, 177, 20);
		panel.add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(20, 70, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(20, 104, 46, 14);
		panel.add(lblTelefono);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 101, 177, 20);
		panel.add(textField);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(20, 139, 46, 14);
		panel.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 238, 46, 14);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 235, 177, 20);
		panel.add(textField_1);
		
		JLabel lblSelecionarComponentes = new JLabel("Combos \r\ndisponibles");
		lblSelecionarComponentes.setBounds(20, 278, 98, 26);
		panel.add(lblSelecionarComponentes);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 136, 327, 88);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(80, 67, 177, 20);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 281, 129, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(20, 334, 46, 14);
		panel.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(80, 331, 177, 20);
		panel.add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 410, 434, 37);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(335, 7, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFacturar.setBounds(236, 7, 89, 23);
		panel_1.add(btnFacturar);
		
		JLabel label_1 = new JLabel("Crear nueva factura:");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		getContentPane().add(label_1, BorderLayout.NORTH);
	}
}