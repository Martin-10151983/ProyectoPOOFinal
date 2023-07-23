package logico;

public class Cliente {
	private String id;
	private String nombre;
	private String cedula;
	private String correoElectronico;
	private String numeroTelefono;
	private String direccion;
	private String metodoPago;
	
	public Cliente(String id, String nombre, String cedula, String correoElectronico, String numeroTelefono,
			String direccion, String metodoPago) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correoElectronico = correoElectronico;
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	

}
