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
    private static int contadorCombos = 1;

    public Crear_Combo(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "Crear Combo", true);
        setResizable(false);
        this.tienda = tienda;
        this.componentesSeleccionados = new ArrayList<>();

        
        setSize(509, 402);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      
        JPanel panel = new JPanel();
        panel.setLayout(null);

       
        DefaultListModel<Componente> listaModel = new DefaultListModel<>();
        for (Componente componente : tienda.getInventarioComponentes()) {
            listaModel.addElement(componente);
        }
        JList<Componente> listaComponentes = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(listaComponentes);
        scrollPane.setBounds(10, 14, 350, 290);
        panel.add(scrollPane);

        
        JButton botonAgregarComponente = new JButton("Agregar ");
        botonAgregarComponente.setBounds(368, 14, 115, 290);
        panel.add(botonAgregarComponente);
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

        
        JButton botonEnsamblarCombo = new JButton("Ensamblar Combo");
        botonEnsamblarCombo.setBounds(10, 315, 473, 36);
        panel.add(botonEnsamblarCombo);
        botonEnsamblarCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ensamblarYAgregarCombo();
            }
        });
        getContentPane().setLayout(new BorderLayout(0, 0));

        
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
        String numeroSerie = String.format("COMBO-%03d", contadorCombos);
        contadorCombos++;
        return numeroSerie;
    }

}