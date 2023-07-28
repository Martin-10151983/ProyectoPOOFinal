package logico;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Tienda miTienda = new Tienda();

        
        Componente componente1 = new Microprocesador( "Intel", "i7", 150.0, 5, "SER123", "Socket AM4", 3.5);
        Componente componente2 = new Ram("Corsair", "STATIC RAM", 80.0, 10, "RAM456", 8, "DDR4");
        Componente componente3 = new Disco("Seagate", "ModeloXYZ", 120.0, 8, "DISK789", "SATA-3", 1000);
        miTienda.agregarComponente(componente1);
        miTienda.agregarComponente(componente2);
        miTienda.agregarComponente(componente3);

        
        miTienda.mostrarInventarioComponentes();

        
        ArrayList<Componente> componentesCombo1 = new ArrayList<>();
        componentesCombo1.add(componente1);
        componentesCombo1.add(componente2);

        ArrayList<Componente> componentesCombo2 = new ArrayList<>();
        componentesCombo2.add(componente2);
        componentesCombo2.add(componente3);

        Combo combo1 = new Combo("COMBO001", componentesCombo1);
        Combo combo2 = new Combo("COMBO002", componentesCombo2);

        miTienda.agregarCombo(combo1);
        miTienda.agregarCombo(combo2);

        
        miTienda.mostrarCombosDisponibles();

        
        String numeroSerieBusqueda = "RAM456";
        Componente componenteBuscado = miTienda.buscarComponentePorNumeroSerie(numeroSerieBusqueda);
        if (componenteBuscado != null) {
            System.out.println("Componente encontrado: " + componenteBuscado.getClass().getSimpleName() +
                    " - Modelo: " + componenteBuscado.getModelo() +
                    ", Marca: " + componenteBuscado.getMarca());
        } else {
            System.out.println("Componente no encontrado.");
        }

        
        String numeroSerieComboBusqueda = "COMBO001";
        Combo comboBuscado = miTienda.buscarComboPorNumeroSerie(numeroSerieComboBusqueda);
        if (comboBuscado != null) {
            System.out.println("Combo encontrado: " + comboBuscado.getNumeroSerie());
        } else {
            System.out.println("Combo no encontrado.");
        }

        
        miTienda.ensamblarCombo(combo1);
    }
}