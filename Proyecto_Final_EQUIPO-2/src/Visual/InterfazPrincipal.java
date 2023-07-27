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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A\u00F1adir Componente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adir_Componente A�adirComponente = new A�adir_Componente(null, tienda);
				A�adirComponente.setModal(true);
				A�adirComponente.setVisible(true);
			}
		});
		menuComponentes.add(mntmNewMenuItem);
		menuItemMostrarComponentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarComponentesDisponibles();
			}
		});

		// Men� "Facturas"
		JMenu menuFacturas = new JMenu("Facturas");
		menuBar.add(menuFacturas);

		// Submen� "Crear Factura"
		JMenuItem menuItemCrearFactura = new JMenuItem("Crear Factura");
		menuFacturas.add(menuItemCrearFactura);
		menuItemCrearFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearFactura();
			}
		});

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
		setVisible(true);
	}

	// M�todo para mostrar los componentes disponibles
	private void mostrarComponentesDisponibles() {
		// Aqu� implementar la l�gica para mostrar los componentes disponibles en una nueva ventana o pesta�a
	}

	// M�todo para crear una factura
	private void crearFactura() {
		// Aqu� implementar la l�gica para crear una factura y agregarla a las facturas existentes
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Tienda miTienda = new Tienda();
			InterfazPrincipal interfaz = new InterfazPrincipal(miTienda);
		});
	}
}