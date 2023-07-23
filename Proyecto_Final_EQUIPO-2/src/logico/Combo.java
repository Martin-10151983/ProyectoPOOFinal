package logico;

import java.util.ArrayList;

class Combo {
    private ArrayList<Componente> componentesIncluidos;
    private double totalPrecioCombo;

    public Combo() {
        this.componentesIncluidos = new ArrayList<>();
        this.totalPrecioCombo = 0;
    }

    public Combo(ArrayList<Componente> componentesIncluidos) {
        this.componentesIncluidos = componentesIncluidos;
        calcularTotalPrecioCombo();
    }

    private void calcularTotalPrecioCombo() {
        totalPrecioCombo = 0;
        for (Componente componente : componentesIncluidos) {
            totalPrecioCombo += componente.getPrecio();
        }
    }

    public ArrayList<Componente> getComponentesIncluidos() {
        return componentesIncluidos;
    }

    public void setComponentesIncluidos(ArrayList<Componente> componentesIncluidos) {
        this.componentesIncluidos = componentesIncluidos;
        calcularTotalPrecioCombo();
    }

    public double getTotalPrecioCombo() {
        return totalPrecioCombo;
    }

    public void mostrarDetallesCombo() {
        System.out.println("Componentes incluidos en el combo:");
        for (Componente componente : componentesIncluidos) {
            System.out.println(componente.getMarca() + " " + componente.getModelo() +
                    " - Precio: $" + componente.getPrecio());
        }
        System.out.println("Total del combo: $" + totalPrecioCombo);
    }
}
