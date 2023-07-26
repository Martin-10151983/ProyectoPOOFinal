package logico;

import java.util.ArrayList;

public class Combo {
	private ArrayList<Componente> componentesDelCombo;
	private double precioCombo;

	public Combo() {
		super();
		this.componentesDelCombo = new ArrayList<>();
		this.precioCombo = 0.0;
	}

	public ArrayList<Componente> getComponentesDelCombo() {
		return componentesDelCombo;
	}

	public void setComponentesDelCombo(ArrayList<Componente> componentesDelCombo) {
		this.componentesDelCombo = componentesDelCombo;
	}

	public double getPrecioCombo() {
		return precioCombo;
	}

	public void setPrecioCombo(double precioCombo) {
		this.precioCombo = precioCombo;
	}

	public void agregarComponente(Componente componente) {
		componentesDelCombo.add(componente);
		precioCombo += componente.getPrecio();
	}

	public void mostarComponentesDelCombo() {
		System.out.println("Componentes incluidos en el combo:");
		for (Componente componente : componentesDelCombo) {
			System.out.println(componente.getClass().getSimpleName() + ": " + componente.getModelo());
		}
		System.out.println("Precio total del combo: $" + precioCombo);
	}

}
