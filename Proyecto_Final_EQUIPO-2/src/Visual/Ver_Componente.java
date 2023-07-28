package Visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ver_Componente extends JDialog {
    private Tienda tienda;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private ArrayList<Componente> componentesTemporales;
    private ArrayList<Componente> cambiosPendientes;

    public Ver_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Componentes Disponibles", true);
        setResizable(false);
        this.tienda = tienda;
        componentesTemporales = clonarLista(tienda.getInventarioComponentes());
        cambiosPendientes = new ArrayList<>();
        initComponents();
    }

    private ArrayList<Componente> clonarLista(ArrayList<Componente> listaOriginal) {
        ArrayList<Componente> listaClonada = new ArrayList<>();
        for (Componente componente : listaOriginal) {
            listaClonada.add(componente);
        }
        return listaClonada;
    }

    private void initComponents() {
        String[] columnas = {"Tipo", "Marca", "Modelo", "Precio", "Cantidad Disponible", "Número de Serie"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        for (Componente componente : componentesTemporales) {
            Object[] fila = {componente.getClass().getSimpleName(), componente.getMarca(), componente.getModelo(),
                    componente.getPrecio(), componente.getCantidadDisponible(), componente.getNumeroSerie()};
            modeloTabla.addRow(fila);
        }

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tabla.getSelectedRow();
                    int columna = tabla.getSelectedColumn();
                    tabla.editCellAt(fila, columna);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton guardarButton = new JButton("Guardar Cambios");
        guardarButton.addActionListener(this::guardarCambios);

        JButton cancelarButton = new JButton("Cancelar Cambios");
        cancelarButton.addActionListener(this::cancelarCambios);

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(guardarButton);
        botonesPanel.add(cancelarButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setSize(800, 400);
        setLocationRelativeTo(null);
    }

    private void guardarCambios(ActionEvent e) {
        int numRows = modeloTabla.getRowCount();
        for (int i = 0; i < numRows; i++) {
            String marca = (String) modeloTabla.getValueAt(i, 1);
            String modelo = (String) modeloTabla.getValueAt(i, 2);
            double precio = (double) modeloTabla.getValueAt(i, 3);
            int cantidad = (int) modeloTabla.getValueAt(i, 4);
            String numeroSerie = (String) modeloTabla.getValueAt(i, 5);

            Componente componenteTemporal = componentesTemporales.get(i);
            componenteTemporal.setMarca(marca);
            componenteTemporal.setModelo(modelo);
            componenteTemporal.setPrecio(precio);
            componenteTemporal.setCantidadDisponible(cantidad);
            componenteTemporal.setNumeroSerie(numeroSerie);

           
            cambiosPendientes.add(componenteTemporal);
        }

       
        for (Componente componenteModificado : cambiosPendientes) {
            int index = componentesTemporales.indexOf(componenteModificado);
            if (index != -1) {
                Componente componenteOriginal = componentesTemporales.get(index);
                componenteOriginal.setMarca(componenteModificado.getMarca());
                componenteOriginal.setModelo(componenteModificado.getModelo());
                componenteOriginal.setPrecio(componenteModificado.getPrecio());
                componenteOriginal.setCantidadDisponible(componenteModificado.getCantidadDisponible());
                componenteOriginal.setNumeroSerie(componenteModificado.getNumeroSerie());
            }
        }

        
        cambiosPendientes.clear();

        
        modeloTabla.fireTableDataChanged();

        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Guardar Cambios", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelarCambios(ActionEvent e) {
        
        componentesTemporales = clonarLista(tienda.getInventarioComponentes());

      
        cambiosPendientes.clear();

        
        modeloTabla.fireTableDataChanged();

        JOptionPane.showMessageDialog(this, "Cambios descartados.", "Cancelar Cambios", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tienda tienda = new Tienda();
            Ver_Componente ventana = new Ver_Componente(null, tienda);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}