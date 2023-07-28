package Visual;

import javax.swing.*;

import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A�adir_Componente extends JDialog {
    private Tienda tienda;

    public A�adir_Componente(InterfazPrincipal parent, Tienda tienda) {
        super(parent, "A�adir Componente", true);
        setResizable(false);
        this.tienda = tienda;

       
        setSize(400, 212);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       
        JPanel panel = new JPanel();
        panel.setLayout(null);

       
        String[] tiposComponentes = {"Microprocesador", "Disco Duro", "Memoria RAM", "Tarjeta Madre"};
        DefaultComboBoxModel<String> modelTiposComponentes = new DefaultComboBoxModel<>(tiposComponentes);
        JComboBox<String> comboBoxTiposComponentes = new JComboBox<>(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Microprocesador", "Disco Duro", "Memoria RAM", "Tarjeta Madre"}));        
        comboBoxTiposComponentes.setBounds(196, 35, 144, 47);
        panel.add(comboBoxTiposComponentes);

       
        JButton botonAgregarComponente = new JButton("Agregar Componente");
        botonAgregarComponente.setBounds(10, 115, 178, 47);
        panel.add(botonAgregarComponente);

       
        comboBoxTiposComponentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoComponenteSeleccionado = (String) comboBoxTiposComponentes.getSelectedItem();
                abrirDialogoAgregarComponente(tipoComponenteSeleccionado);
            }
        });

       
        botonAgregarComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(A�adir_Componente.this, "Por favor, seleccione un tipo de componente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Tipo de Componente");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(64, 35, 122, 47);
        panel.add(lblNewLabel);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCancelar.setBounds(196, 115, 178, 47);
        panel.add(btnCancelar);

       
        setLocationRelativeTo(null);
    }
    
    public void setTienda(Tienda tienda) {
    	this.tienda = tienda;
    }

    private void abrirDialogoAgregarComponente(String tipoComponente) {
        switch (tipoComponente) {
            case "Microprocesador":
                A�adir_Microprocesador A�adirMicroprocesador = new A�adir_Microprocesador(null, tienda);
                A�adirMicroprocesador.setTienda(tienda);
                A�adirMicroprocesador.setVisible(true);
                break;
            case "Disco Duro":
                A�adir_Disco A�adirDisco = new A�adir_Disco(null, tienda);
                A�adirDisco.setTienda(tienda);
                A�adirDisco.setVisible(true);
                break;
            case "Memoria RAM":
                A�adir_Ram A�adirRam = new A�adir_Ram(null, tienda);
                A�adirRam.setTienda(tienda);
                A�adirRam.setVisible(true);
                break;
            case "Tarjeta Madre":
                A�adir_TarjetaMadre A�adirTarjetaMadre = new A�adir_TarjetaMadre(null, tienda);
                A�adirTarjetaMadre.setTienda(tienda);
                A�adirTarjetaMadre.setVisible(true);
                break;
        }
    }
}