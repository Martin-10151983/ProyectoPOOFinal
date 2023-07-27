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

        // Configurar la ventana
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear un panel para el contenido de la ventana
        JPanel panel = new JPanel(new BorderLayout());

        // Etiqueta para el título
        JLabel labelTitulo = new JLabel("Combos Disponibles");
        panel.add(labelTitulo, BorderLayout.NORTH);

        // Datos para la tabla
        String[] columnas = {"Nombre Combo", "Componentes"};
        Object[][] datos = obtenerDatosCombos();

        // Crear el modelo de la tabla con los datos
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

        // Crear la tabla con el modelo
        JTable tablaCombos = new JTable(modeloTabla);
        panel.add(new JScrollPane(tablaCombos), BorderLayout.CENTER);

        // Mostrar el panel en la ventana
        add(panel);

        // Centrar la ventana en la pantalla
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
        // Eliminar la última coma y espacio
        if (marcaModeloComponentes.length() > 2) {
            marcaModeloComponentes.setLength(marcaModeloComponentes.length() - 2);
        }
        return marcaModeloComponentes.toString();
    }
}