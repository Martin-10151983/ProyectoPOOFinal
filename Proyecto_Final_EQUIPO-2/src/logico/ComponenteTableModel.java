package logico;

import logico.Componente;
import logico.Tienda;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ComponenteTableModel extends AbstractTableModel {
    private Tienda tienda;
    private ArrayList<Componente> componentes;

    private final String[] columnNames = {"Tipo", "Marca", "Modelo", "Precio", "Cantidad Disponible", "Número de Serie", "Tipo de Conexión"};

    public ComponenteTableModel(Tienda tienda) {
        this.tienda = tienda;
        this.componentes = tienda.getInventarioComponentes();
    }

    @Override
    public int getRowCount() {
        return componentes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Componente componente = componentes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return componente.getClass().getSimpleName();
            case 1:
                return componente.getMarca();
            case 2:
                return componente.getModelo();
            case 3:
                return componente.getPrecio();
            case 4:
                return componente.getCantidadDisponible();
            case 5:
                return componente.getNumeroSerie();
            case 6:
                if (componente instanceof TarjetaMadre) {
                    return ((TarjetaMadre) componente).getTipoConexionMicro();
                } else if (componente instanceof Disco) {
                    return ((Disco) componente).getTipoConexion();
                } else {
                    return ""; // Dejar en blanco para otros componentes que no tengan este atributo
                }
            default:
                return null;
        }
    }
}
