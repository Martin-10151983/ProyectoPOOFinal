package Visual;

import javax.swing.*;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Crear_Combo extends JDialog {
    private Tienda tienda;
    private ArrayList<Componente> componentesSeleccionados;

    public Crear_Combo(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Crear Combo", true);
        this.tienda = tienda;
        this.componentesSeleccionados = new ArrayList<>();

        
        setSize(509, 370);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      
        JPanel panel = new JPanel(new BorderLayout());

       
        JLabel labelTitulo = new JLabel("Ensamblar Nuevo Combo");
        panel.add(labelTitulo, BorderLayout.NORTH);

       
        DefaultListModel<Componente> listaModel = new DefaultListModel<>();
        for (Componente componente : tienda.getInventarioComponentes()) {
            listaModel.addElement(componente);
        }
        JList<Componente> listaComponentes = new JList<>(listaModel);
        panel.add(new JScrollPane(listaComponentes), BorderLayout.CENTER);

        
        JButton botonAgregarComponente = new JButton("Agregar Componente");
        panel.add(botonAgregarComponente, BorderLayout.EAST);
        botonAgregarComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente componenteSeleccionado = listaComponentes.getSelectedValue();
                if (componenteSeleccionado != null) {
                    componentesSeleccionados.add(componenteSeleccionado);
                    JOptionPane.showMessageDialog(Crear_Combo.this, "Componente agregado al combo en ensamblaje.");
                } else {
                    JOptionPane.showMessageDialog(Crear_Combo.this, "Por favor, seleccione un componente.");
                }
            }
        });

        
        JButton botonEnsamblarCombo = new JButton("Ensamblar y Agregar Combo");
        panel.add(botonEnsamblarCombo, BorderLayout.SOUTH);
        botonEnsamblarCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ensamblarYAgregarCombo();
            }
        });

        
        getContentPane().add(panel);

       
        setLocationRelativeTo(null);
    }

    private void ensamblarYAgregarCombo() {
        if (!componentesSeleccionados.isEmpty()) {
            String numeroSerieCombo = generarNumeroSerieCombo();
            Combo nuevoCombo = new Combo(numeroSerieCombo, new ArrayList<>(componentesSeleccionados));
            tienda.agregarCombo(nuevoCombo);

            JOptionPane.showMessageDialog(this, "Combo ensamblado y agregado a la lista de combos disponibles.");

           
            componentesSeleccionados.clear();

          
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado componentes para ensamblar el combo.");
        }
    }

    private String generarNumeroSerieCombo() {
       
        return "COMBO-" + (int) (Math.random() * 1000);
    }
}