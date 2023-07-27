package logico;

public class Ram extends Componente {
	private int capacidadMemoria;
	private String tipoMemoria;

	public Ram(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie, int capacidadMemoria, String tipoMemoria) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.capacidadMemoria = capacidadMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public int getCapacidadMemoria() {
		return capacidadMemoria;
	}

	public void setCapacidadMemoria(int capacidadMemoria) {
		this.capacidadMemoria = capacidadMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
