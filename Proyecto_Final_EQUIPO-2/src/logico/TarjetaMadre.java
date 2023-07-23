package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	private Microprocesador tipoConectorM;
	private Ram tipoRam;
	private ArrayList<Disco> conexionDiscos;
	
	public TarjetaMadre(String marca, String modelo, double precio, int canditadDisponible, String numeroSerie,
			Microprocesador tipoConectorM, Ram tipoRam) {
		super(marca, modelo, precio, canditadDisponible, numeroSerie);
		this.tipoConectorM = tipoConectorM;
		this.tipoRam = tipoRam;
		this.conexionDiscos = new ArrayList<>();
	}

	public Microprocesador getTipoConectorM() {
		return tipoConectorM;
	}

	public void setTipoConectorM(Microprocesador tipoConectorM) {
		this.tipoConectorM = tipoConectorM;
	}

	public Ram getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(Ram tipoRam) {
		this.tipoRam = tipoRam;
	}

	public ArrayList<Disco> getConexionDiscos() {
		return conexionDiscos;
	}

	public void setConexionDiscos(ArrayList<Disco> conexionDiscos) {
		this.conexionDiscos = conexionDiscos;
	}
	
	
	
	

}
