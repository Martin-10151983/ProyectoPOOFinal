package logico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente> inventarioComponentes;
	private ArrayList<Combo> combosDisponibles;
	private ArrayList<Cliente> misClientes;

	public Tienda() {
		this.inventarioComponentes = new ArrayList<>();
		this.combosDisponibles = new ArrayList<>();
		this.setMisClientes(new ArrayList<>());
	}



	

	public ArrayList<Componente> getInventarioComponentes() {
		return inventarioComponentes;
	}



	public void setInventarioComponentes(ArrayList<Componente> inventarioComponentes) {
		this.inventarioComponentes = inventarioComponentes;
	}



	public ArrayList<Combo> getCombosDisponibles() {
		return combosDisponibles;
	}



	public void setCombosDisponibles(ArrayList<Combo> combosDisponibles) {
		this.combosDisponibles = combosDisponibles;
	}



	public void agregarComponente(Componente componente) {
		inventarioComponentes.add(componente);
	}
	
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
	public void eliminarComponente(int filaSeleccionada) {
		for(Combo combo : combosDisponibles) {
			if(combo.getComponentesIncluidos().contains(filaSeleccionada)) {
				combo.eliminarComponente(filaSeleccionada);
			}
		}
		inventarioComponentes.remove(filaSeleccionada);
		
		for (int i = combosDisponibles.size() - 1; i >= 0; i--) {
            Combo combo = combosDisponibles.get(i);
            if (combo.getComponentesIncluidos().isEmpty()) {
                combosDisponibles.remove(i);
            }
        }
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


	public Componente buscarComponentePorNumeroSerie(String numeroSerie) {
		for (Componente componente : inventarioComponentes) {
			if (componente.getNumeroSerie().equals(numeroSerie)) {
				return componente;
			}
		}
		return null; 
	}

	public Combo buscarComboPorNumeroSerie(String numeroSerie) {
		for (Combo combo : combosDisponibles) {
			if (combo.getNumeroSerie().equals(numeroSerie)) {
				return combo;
			}
		}
		return null; 
	}

	

	public void ensamblarCombo(Combo combo) {
		for (Componente componente : combo.getComponentesIncluidos()) {
			if (!inventarioComponentes.contains(componente)) {
				System.out.println("Error: Uno o más componentes del combo no están disponibles en el inventario.");
				return;
			}
		}

		
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