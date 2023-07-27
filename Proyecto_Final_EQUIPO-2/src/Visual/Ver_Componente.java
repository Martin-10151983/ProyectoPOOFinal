package Visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Tienda;

import java.awt.*;

public class Ver_Componente extends JDialog {
    private Tienda tienda;

    public Ver_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Componentes Disponibles", true);
        setResizable(false);
        this.tienda = tienda;
        initComponents();
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void initComponents() {
        // Crear la tabla para mostrar los componentes disponibles
        String[] columnas = {"Tipo", "Marca", "Modelo", "Precio", "Cantidad Disponible", "N�mero de Serie"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);

        // Agregar los datos de los componentes disponibles a la tabla
        for (Componente componente : tienda.getInventarioComponentes()) {
            Object[] fila = {componente.getClass().getSimpleName(), componente.getMarca(), componente.getModelo(),
                    componente.getPrecio(), componente.getCantidadDisponible(), componente.getNumeroSerie()};
            modeloTabla.addRow(fila);
        }

        // Crear un JScrollPane para agregar la tabla con scroll si es necesario
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        // Mostrar la tabla en la ventana
        getContentPane().add(scrollPane);

        // Establecer el tama�o y la posici�n de la ventana
        setSize(800, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tienda tienda = new Tienda(); // Crea una instancia de la tienda (puedes cargar los datos de componentes aqu�)
            Ver_Componente ventana = new Ver_Componente (null, tienda);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}
