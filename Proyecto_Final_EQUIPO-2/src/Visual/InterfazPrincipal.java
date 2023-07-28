package Visual;

import javax.swing.*;

import logico.Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {
	private Tienda tienda;

	public InterfazPrincipal(Tienda tienda) {
		this.tienda = tienda;

		// Configurar la ventana
		setTitle("Tienda de Computadoras");
		setSize(519, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear el men� principal
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Men� "Componentes"
		JMenu menuComponentes = new JMenu("Componentes");
		menuBar.add(menuComponentes);

		// Submen� "Mostrar Componentes Disponibles"
		JMenuItem menuItemMostrarComponentes = new JMenuItem("Mostrar Componentes Disponibles");
		menuComponentes.add(menuItemMostrarComponentes);
		
		JMenuItem mntmA�adirComponentes = new JMenuItem("A\u00F1adir Componentes");
		mntmA�adirComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adir_Componente A�adirComponente = new A�adir_Componente(null, tienda);
				A�adirComponente.setModal(true);
				A�adirComponente.setVisible(true);
			}
		});
		menuComponentes.add(mntmA�adirComponentes);
		menuItemMostrarComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Componente VerComponentes = new Ver_Componente(null, tienda);
				VerComponentes.setModal(true);
				VerComponentes.setVisible(true);
			}
		});


		

			// Men� "Facturas"
			JMenu menuFacturas = new JMenu("Facturas");
			menuBar.add(menuFacturas);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Crear Factura");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Crear_Factura crearFactura = new Crear_Factura();
					crearFactura.setModal(true);
					crearFactura.setVisible(true);
				}
			});
			menuFacturas.add(mntmNewMenuItem);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mostrar Facturas");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mostrar_Factura mostrarFactura = new Mostrar_Factura();
					mostrarFactura.setModal(true);
					mostrarFactura.setVisible(true);
				}
			});
			menuFacturas.add(mntmNewMenuItem_1);
			

			// Men� "Combos"
			JMenu menuCombos = new JMenu("Combos");
			menuBar.add(menuCombos);

			// Submen� "Mostrar Combos Disponibles"
			JMenuItem menuItemMostrarCombos = new JMenuItem("Mostrar Combos Disponibles");
			menuCombos.add(menuItemMostrarCombos);
			menuItemMostrarCombos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Mostrar_Combo MostrarCombo = new Mostrar_Combo(null, tienda);
					MostrarCombo.setModal(true);
					MostrarCombo.setVisible(true);
				}
			});

			// Submen� "Crear Combo"
			JMenuItem menuItemCrearCombo = new JMenuItem("Crear Combo");
			menuCombos.add(menuItemCrearCombo);
			menuItemCrearCombo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Crear_Combo CrearCombo = new Crear_Combo(null, tienda);
					CrearCombo.setModal(true);
					CrearCombo.setVisible(true);
				}
			});

			// Mostrar la ventana principal
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HAYDEE PARRA TORIBIO\\Downloads\\Captura de pantalla 2023-07-28 161649.png"));
			lblNewLabel.setBounds(0, 0, 503, 275);
			getContentPane().add(lblNewLabel);
			setVisible(true);
		}

		public static void main(String[] args) {
			SwingUtilities.invokeLater(() -> {
				Tienda miTienda = new Tienda();
				InterfazPrincipal interfaz = new InterfazPrincipal(miTienda);
			});
		}
	}