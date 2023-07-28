package logico;

import java.util.ArrayList;

public class Combo {
    private String numeroSerie;
    private ArrayList<Componente> componentesIncluidos;
    private double precioTotalCombo;

    public Combo(String numeroSerie, ArrayList<Componente> componentesIncluidos) {
        this.numeroSerie = numeroSerie;
        this.componentesIncluidos = componentesIncluidos;
        this.precioTotalCombo = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0.0;
        for (Componente componente : componentesIncluidos) {
            total += componente.getPrecio();
        }
        return total;
    }

    
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public ArrayList<Componente> getComponentesIncluidos() {
        return componentesIncluidos;
    }

    public double getPrecioTotalCombo() {
        return precioTotalCombo;
    }

   
    public void mostrarComponentesDelCombo() {
        System.out.println("Combo: " + numeroSerie);
        System.out.println("Componentes incluidos:");
        for (Componente componente : componentesIncluidos) {
            System.out.println(componente.getClass().getSimpleName() + " - " +
                    "Modelo: " + componente.getModelo() +
                    ", Marca: " + componente.getMarca() +
                    ", Precio: $" + componente.getPrecio());
        }
        System.out.println("Precio total del combo: $" + precioTotalCombo);
        System.out.println();
    }
    
    public void eliminarComponente(int filaSeleccionada) {
    	componentesIncluidos.remove(filaSeleccionada);
    }
}