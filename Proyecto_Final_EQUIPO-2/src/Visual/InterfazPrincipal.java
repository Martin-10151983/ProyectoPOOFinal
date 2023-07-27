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

		// Crear el menú principal
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menú "Componentes"
		JMenu menuComponentes = new JMenu("Componentes");
		menuBar.add(menuComponentes);

		// Submenú "Mostrar Componentes Disponibles"
		JMenuItem menuItemMostrarComponentes = new JMenuItem("Mostrar Componentes Disponibles");
		menuComponentes.add(menuItemMostrarComponentes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A\u00F1adir Componente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Añadir_Componente AñadirComponente = new Añadir_Componente(null, tienda);
				AñadirComponente.setModal(true);
				AñadirComponente.setVisible(true);
			}
		});
		menuComponentes.add(mntmNewMenuItem);
		menuItemMostrarComponentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarComponentesDisponibles();
			}
		});

		// Menú "Facturas"
		JMenu menuFacturas = new JMenu("Facturas");
		menuBar.add(menuFacturas);

		// Submenú "Crear Factura"
		JMenuItem menuItemCrearFactura = new JMenuItem("Crear Factura");
		menuFacturas.add(menuItemCrearFactura);
		menuItemCrearFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearFactura();
			}
		});

		// Menú "Combos"
		JMenu menuCombos = new JMenu("Combos");
		menuBar.add(menuCombos);

		// Submenú "Mostrar Combos Disponibles"
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

		// Submenú "Crear Combo"
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

	// Método para mostrar los componentes disponibles
	private void mostrarComponentesDisponibles() {
		// Aquí implementar la lógica para mostrar los componentes disponibles en una nueva ventana o pestaña
	}

	// Método para crear una factura
	private void crearFactura() {
		// Aquí implementar la lógica para crear una factura y agregarla a las facturas existentes
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Tienda miTienda = new Tienda();
			InterfazPrincipal interfaz = new InterfazPrincipal(miTienda);
		});
	}
}