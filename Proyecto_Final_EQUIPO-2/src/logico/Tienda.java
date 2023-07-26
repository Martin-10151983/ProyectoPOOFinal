package logico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente> inventarioComponentes;
	private ArrayList<Combo> combosDisponibles;

	public Tienda() {
		this.inventarioComponentes = new ArrayList<>();
		this.combosDisponibles = new ArrayList<>();
	}

	// Métodos para gestionar el inventario de componentes

	public void agregarComponente(Componente componente) {
		inventarioComponentes.add(componente);
	}

	public void mostrarInventarioComponentes() {
		System.out.println("Inventario de Componentes:");
		for (Componente componente : inventarioComponentes) {
			System.out.println(componente.getClass().getSimpleName() + " - " +
					"Modelo: " + componente.getModelo() +
					", Marca: " + componente.getMarca() +
					", Precio: $" + componente.getPrecio() +
					", Cantidad Disponible: " + componente.getCantidadDisponible());
		}
	}

	// Métodos para gestionar los combos de componentes

	public void agregarCombo(Combo combo) {
		combosDisponibles.add(combo);
	}

	public void mostrarCombosDisponibles() {
		System.out.println("Combos Disponibles:");
		for (Combo combo : combosDisponibles) {
			combo.mostrarComponentesDelCombo();;
		}
	}

	// Métodos para buscar componentes y combos por número de serie

	public Componente buscarComponentePorNumeroSerie(String numeroSerie) {
		for (Componente componente : inventarioComponentes) {
			if (componente.getNumeroSerie().equals(numeroSerie)) {
				return componente;
			}
		}
		return null; // Retorna null si el componente no se encuentra en el inventario
	}

	public Combo buscarComboPorNumeroSerie(String numeroSerie) {
		for (Combo combo : combosDisponibles) {
				if (combo.getNumeroSerie().equals(numeroSerie)) {
					return combo;
				}
		}
		return null; // Retorna null si el combo no se encuentra en los combos disponibles
	}

	// Método para ensamblar un combo de componentes

	public void ensamblarCombo(Combo combo) {
		for (Componente componente : combo.getComponentesIncluidos()) {
			if (!inventarioComponentes.contains(componente)) {
				System.out.println("Error: Uno o más componentes del combo no están disponibles en el inventario.");
				return;
			}
		}

		// Si todos los componentes están disponibles, se ensambla el combo
		System.out.println("Ensamblado del combo exitoso. Factura:");
		for (Componente componente : combo.getComponentesIncluidos()) {
			System.out.println(componente.getClass().getSimpleName() + " - " +
					"Modelo: " + componente.getModelo() +
					", Marca: " + componente.getMarca() +
					", Precio: $" + componente.getPrecio());
		}
		System.out.println("Precio total del combo: $" + combo.getPrecioTotalCombo());
	}
}