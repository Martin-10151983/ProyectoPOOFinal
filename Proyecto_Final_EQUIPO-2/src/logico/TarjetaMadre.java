package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	private String tipoConexionMicro;
	private String tipoMemoriaRam;
	private ArrayList<String> conexionesDiscosDuros;

	public TarjetaMadre(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie, String tipoConexionMicro, String tipoMemoriaRam, ArrayList<String> conexionesDiscosDuros) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConexionMicro = tipoConexionMicro;
		this.tipoMemoriaRam = tipoMemoriaRam;
		this.conexionesDiscosDuros = conexionesDiscosDuros;
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

	public ArrayList<String> getConexionesDiscosDuros() {
		return conexionesDiscosDuros;
	}

	public void setConexionesDiscosDuros(ArrayList<String> conexionesDiscosDuros) {
		this.conexionesDiscosDuros = conexionesDiscosDuros;
	}

}
