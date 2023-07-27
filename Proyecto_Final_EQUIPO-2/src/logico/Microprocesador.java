package logico;

public class Microprocesador extends Componente {
	private String tipoConectorMicro;
	private double velocidadProcesamiento;

	public Microprocesador(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie, String tipoConexion, double velocidadProcesamiento) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConectorMicro = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public String getTipoConexion() {
		return tipoConectorMicro;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConectorMicro = tipoConexion;
	}

	public double getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(double velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}


}
