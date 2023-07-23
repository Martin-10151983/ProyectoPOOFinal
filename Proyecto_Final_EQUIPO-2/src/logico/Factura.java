package logico;

import java.util.ArrayList;
import java.util.Date;

class Factura {
    private String id;
    private Cliente dueñoFactura;
    private ArrayList<Componente> componentes;
    private Combo combo;
    private double totalPagar;
    private Date fecha;

    public Factura(String id, Cliente dueñoFactura, Date fecha) {
        this.id = id;
        this.dueñoFactura = dueñoFactura;
        this.fecha = fecha;
        this.componentes = new ArrayList<>();
        this.combo = null;
        this.totalPagar = 0;
    }

    public Factura(String id, Cliente dueñoFactura, Combo combo, Date fecha) {
        this.id = id;
        this.dueñoFactura = dueñoFactura;
        this.combo = combo;
        this.fecha = fecha;
        this.componentes = combo.getComponentesIncluidos();
        this.totalPagar = combo.getTotalPrecioCombo();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getDueñoFactura() {
        return dueñoFactura;
    }

    public void setDueñoFactura(Cliente dueñoFactura) {
        this.dueñoFactura = dueñoFactura;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void agregarComponente(Componente componente, int cantidad) {
        if (componente != null && cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                componentes.add(componente);
                totalPagar += componente.getPrecio();
            }
        }
    }

    public void mostrarDetallesFactura() {
        System.out.println("Factura #" + id + " - Fecha: " + fecha);
        System.out.println("Cliente: " + dueñoFactura.getNombre());
        System.out.println("Componentes incluidos:");
        for (Componente componente : componentes) {
            System.out.println(componente.getMarca() + " " + componente.getModelo() +
                    " - Precio: $" + componente.getPrecio());
        }
        if (combo != null) {
            System.out.println("Combo incluido:");
            for (Componente componenteCombo : combo.getComponentesIncluidos()) {
                System.out.println(componenteCombo.getMarca() + " " + componenteCombo.getModelo() +
                        " - Precio: $" + componenteCombo.getPrecio());
            }
        }
        System.out.println("Total a pagar: $" + totalPagar);
    }
}
