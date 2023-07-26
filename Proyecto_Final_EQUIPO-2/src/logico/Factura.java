package logico;

import java.util.ArrayList;

class Factura {
	private int clave_factura;
	private Cliente cliente;
	private ArrayList<Componente> componentesEscogidos;
	private double precioFactura;

	public Factura(int clave_factura, Cliente cliente) {
		super();
		this.clave_factura = clave_factura;
		this.cliente = cliente;
		this.componentesEscogidos = new ArrayList<>();
		this.precioFactura = 0.0;
	}

	public int getClave_factura() {
		return clave_factura;
	}

	public void setClave_factura(int clave_factura) {
		this.clave_factura = clave_factura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Componente> getComponentesEscogidos() {
		return componentesEscogidos;
	}

	public void setComponentesEscogidos(ArrayList<Componente> componentesEscogidos) {
		this.componentesEscogidos = componentesEscogidos;
	}

	public double getPrecioFactura() {
		return precioFactura;
	}

	public void setPrecioFactura(double precioFactura) {
		this.precioFactura = precioFactura;
	}

	public void agregarComponente(Componente componente) {
		componentesEscogidos.add(componente);
		precioFactura += componente.getPrecio();
	}

	public void ImprimirFactura() {
		System.out.println("Factura N°: " + clave_factura);
		System.out.println("Cliente: " + cliente.getNombre());
		System.out.println("Direccion: " + cliente.getDireccion());
		System.out.println("Telefono: " + cliente.getTelefono());
		System.out.println("Correo Electronico: " + cliente.getEmail());

		System.out.println("\nComponentes seleccionados ");

		for (Componente componente : componentesEscogidos) {
			System.out.println(componente.getClass().getSimpleName() + ": " + componente.getModelo());
			System.out.println("Precio: $" + componente.getPrecio());
			System.out.println("------------------------------");
		}

		System.out.println("TOTAL A PAGAR: $" + precioFactura);

	}




}
