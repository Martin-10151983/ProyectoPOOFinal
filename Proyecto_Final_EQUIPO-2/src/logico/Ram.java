package logico;

public class Ram extends Componente {
	private String capacidadMemoria;
	private String tipoMemoria;

	public Ram(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie,
			String capacidadMemoria, String tipoMemoria) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.capacidadMemoria = capacidadMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public String getCapacidadMemoria() {
		return capacidadMemoria;
	}

	public void setCapacidadMemoria(String capacidadMemoria) {
		this.capacidadMemoria = capacidadMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
