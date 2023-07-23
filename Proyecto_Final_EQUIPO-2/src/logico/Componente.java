package logico;

public class Componente {
	protected String marca;
	protected String modelo;
	protected double precio;
	protected int canditadDisponible;
	protected String numeroSerie;

	public Componente(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.canditadDisponible = canditadDisponible;
		this.numeroSerie = numeroSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCanditadDisponible() {
		return canditadDisponible;
	}

	public void setCanditadDisponible(int canditadDisponible) {
		this.canditadDisponible = canditadDisponible;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

}
