package logico;

public class Disco extends Componente {
	private String tipoConexion;
	private int capacidadAlmacenamiento;

	public Disco(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie, String tipoConexion, int capacidadAlmacenamiento) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConexion = tipoConexion;
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public int getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

}
