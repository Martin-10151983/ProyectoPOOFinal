package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Mostrar_Factura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mostrar_Factura dialog = new Mostrar_Factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mostrar_Factura() {
		setTitle("Ver Factura");
		setResizable(false);
		setBounds(100, 100, 612, 316);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 606, 230);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 603, 243);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00B0 Factura", "Cliente", "Tel\u00E9fono", "Direcci\u00F3n", "Email", "Total $"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			Panel botonPanel = new Panel();
			botonPanel.setBounds(0, 282, 606, -52);
			getContentPane().add(botonPanel);
		}
		{
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(0, 230, 606, 46);
			getContentPane().add(btnNewButton);
		}
	}
}