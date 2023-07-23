package logico;

public class Microprocesador extends Componente {
	private String tipoConexion;
	private String velocidadProcesamiento;
	
	public Microprocesador(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie,
			String tipoConexion, String velocidadProcesamiento) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(String velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
	
}
