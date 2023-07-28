package Visual;

import logico.Componente;
import logico.Tienda;
import logico.TarjetaMadre;
import logico.Disco;
import logico.Ram;
import logico.Microprocesador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Ver_Componente extends JDialog {
    private Tienda tienda;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public Ver_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Componentes Disponibles", true);
        setResizable(false);
        this.tienda = tienda;
        initComponents();
        setTienda(tienda);
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
        llenarTabla();
    }

<<<<<<< HEAD
    private String[] getColumnas() {
        return new String[]{"Tipo", "Marca", "Modelo", "Precio", "Cantidad Disponible", "Número de Serie"};
    }
=======
    private void initComponents() {
        String[] columnas = {"Tipo", "Marca", "Modelo", "Precio", "Cantidad Disponible", "Número de Serie"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        tabla.setBackground(SystemColor.inactiveCaptionBorder);
>>>>>>> branch 'main' of https://github.com/Martin-10151983/ProyectoPOOFinal.git

    private void llenarTabla() {
        modeloTabla.setRowCount(0);
        for (Componente componente : tienda.getInventarioComponentes()) {
            Object[] fila = {componente.getClass().getSimpleName(), componente.getMarca(), componente.getModelo(),
                    componente.getPrecio(), componente.getCantidadDisponible(), componente.getNumeroSerie()};
            modeloTabla.addRow(fila);
        }
    }

    private void initComponents() {
        // Crear la tabla para mostrar los componentes disponibles
        modeloTabla = new DefaultTableModel(null, getColumnas());
        tabla = new JTable(modeloTabla);

        // Permitir la edición de las celdas al hacer doble clic
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tabla.rowAtPoint(evt.getPoint());
                int columna = tabla.columnAtPoint(evt.getPoint());
                if (fila >= 0 && columna >= 0 && evt.getClickCount() == 2) {
                    tabla.editCellAt(fila, columna);
                }
            }
        });

        // Crear un JScrollPane para agregar la tabla con scroll si es necesario
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Crear botones de eliminar y editar componentes
        JButton eliminarButton = new JButton("Eliminar Componente");
        eliminarButton.addActionListener(this::eliminarComponente);

        JButton editarButton = new JButton("Editar Componente");
        editarButton.addActionListener(this::editarComponente);

        // Panel para contener los botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(eliminarButton);
        botonesPanel.add(editarButton);

        // Crear el panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Mostrar el panel en la ventana
        getContentPane().add(panel);

        // Establecer el tamaño y la posición de la ventana
        setSize(800, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void eliminarComponente(ActionEvent e) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este componente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                tienda.eliminarComponente(filaSeleccionada);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Componente eliminado exitosamente.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un componente para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void editarComponente(ActionEvent e) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            Componente componenteSeleccionado = tienda.getInventarioComponentes().get(filaSeleccionada);

            if (componenteSeleccionado instanceof Microprocesador) {
                Editar_Microprocesador dialog = new Editar_Microprocesador(null, (Microprocesador) componenteSeleccionado);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } else if (componenteSeleccionado instanceof Disco) {
                Editar_Disco dialog = new Editar_Disco(null, (Disco) componenteSeleccionado);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } else if (componenteSeleccionado instanceof Ram) {
                Editar_Ram dialog = new Editar_Ram(null, (Ram) componenteSeleccionado);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } else if (componenteSeleccionado instanceof TarjetaMadre) {
                Editar_TarjetaMadre dialog = new Editar_TarjetaMadre(null, (TarjetaMadre) componenteSeleccionado);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        }
    }
}