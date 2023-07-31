package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	private String tipoConexionMicro;
	private String tipoMemoriaRam;
	private String tipoConexionDiscoDuro;

	public TarjetaMadre(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie, String tipoConexionMicro, String tipoMemoriaRam, String tipoConexionDiscoDuro) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConexionMicro = tipoConexionMicro;
		this.tipoMemoriaRam = tipoMemoriaRam;
		this.tipoConexionDiscoDuro = tipoConexionDiscoDuro;
	}

	public String getTipoConexionMicro() {
		return tipoConexionMicro;
	}

	public void setTipoConexionMicro(String tipoConexionMicro) {
		this.tipoConexionMicro = tipoConexionMicro;
	}

	public String getTipoMemoriaRam() {
		return tipoMemoriaRam;
	}

	public void setTipoMemoriaRam(String tipoMemoriaRam) {
		this.tipoMemoriaRam = tipoMemoriaRam;
	}

	public String getConexionesDiscosDuros() {
		return tipoConexionDiscoDuro;
	}

	public void setConexionesDiscosDuros(String conexionesDiscosDuros) {
		this.tipoConexionDiscoDuro = conexionesDiscosDuros;
	}

}
