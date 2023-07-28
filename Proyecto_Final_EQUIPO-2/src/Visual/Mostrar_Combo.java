package Visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.util.ArrayList;

public class Mostrar_Combo extends JDialog {
    private Tienda tienda;

    public Mostrar_Combo(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Mostrar Combos Disponibles", true);
        this.tienda = tienda;

        
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        JPanel panel = new JPanel(new BorderLayout());

      
        JLabel labelTitulo = new JLabel("Combos Disponibles");
        panel.add(labelTitulo, BorderLayout.NORTH);

        
        String[] columnas = {"Nombre Combo", "Componentes"};
        Object[][] datos = obtenerDatosCombos();

        
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

       
        JTable tablaCombos = new JTable(modeloTabla);
        panel.add(new JScrollPane(tablaCombos), BorderLayout.CENTER);

       
        add(panel);

        
        setLocationRelativeTo(null);
    }

    private Object[][] obtenerDatosCombos() {
        ArrayList<Combo> combosDisponibles = tienda.getCombosDisponibles();
        Object[][] datos = new Object[combosDisponibles.size()][2];
        for (int i = 0; i < combosDisponibles.size(); i++) {
            Combo combo = combosDisponibles.get(i);
            datos[i][0] = combo.getNumeroSerie();
            datos[i][1] = obtenerMarcaModeloComponentes(combo.getComponentesIncluidos());
        }
        return datos;
    }

    private String obtenerMarcaModeloComponentes(ArrayList<Componente> componentes) {
        StringBuilder marcaModeloComponentes = new StringBuilder();
        for (Componente componente : componentes) {
            marcaModeloComponentes.append(componente.getMarca()).append(" ").append(componente.getModelo()).append(", ");
        }
       
        if (marcaModeloComponentes.length() > 2) {
            marcaModeloComponentes.setLength(marcaModeloComponentes.length() - 2);
        }
        return marcaModeloComponentes.toString();
    }
}