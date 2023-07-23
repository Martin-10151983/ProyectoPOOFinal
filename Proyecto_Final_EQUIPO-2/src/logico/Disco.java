package logico;

public class Disco extends Componente {
	private String capacidadAlmacenamiento;
	private String tipoConexion;
	
	public Disco(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie,
			String capacidadAlmacenamiento, String tipoConexion) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}

	public String getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	
		
}
