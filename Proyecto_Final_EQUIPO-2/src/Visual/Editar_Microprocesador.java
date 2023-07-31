package Visual;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import logico.Microprocesador;

public class Editar_Microprocesador extends JDialog {
    private Microprocesador microprocesador;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadDisponibleField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionMicroprocesadorField;
    private JTextField velocidadProcesamientoField;

    public Editar_Microprocesador(Ver_Componente parent, Microprocesador microprocesador) {
        super(parent, "Editar Microprocesador", true);
        setResizable(false);
        this.microprocesador = microprocesador;
        initComponents();
    }

    private void initComponents() {
        // Crear los componentes visuales y establecer sus valores con los atributos del microprocesador
        marcaField = new JTextField(microprocesador.getMarca());
        marcaField.setBounds(230, 11, 144, 36);
        modeloField = new JTextField(microprocesador.getModelo());
        modeloField.setBounds(230, 58, 144, 36);
        precioField = new JTextField(String.valueOf(microprocesador.getPrecio()));
        precioField.setBounds(230, 105, 144, 36);
        cantidadDisponibleField = new JTextField(String.valueOf(microprocesador.getCantidadDisponible()));
        cantidadDisponibleField.setBounds(230, 152, 144, 36);
        numeroSerieField = new JTextField(microprocesador.getNumeroSerie());
        numeroSerieField.setBounds(230, 199, 144, 36);
        tipoConexionMicroprocesadorField = new JTextField(microprocesador.getTipoConexion());
        tipoConexionMicroprocesadorField.setBounds(230, 246, 144, 36);
        velocidadProcesamientoField = new JTextField(String.valueOf(microprocesador.getVelocidadProcesamiento()));
        velocidadProcesamientoField.setBounds(230, 293, 144, 36);

        // Crear un panel para los componentes visuales y agregarlos al panel
        JPanel camposPanel = new JPanel();
        camposPanel.setBounds(0, 0, 460, 390);
        camposPanel.setLayout(null);
        JLabel label = new JLabel("Marca:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(121, 11, 89, 36);
        camposPanel.add(label);
        camposPanel.add(marcaField);
        JLabel label_1 = new JLabel("Modelo:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(121, 58, 89, 36);
        camposPanel.add(label_1);
        camposPanel.add(modeloField);
        JLabel label_2 = new JLabel("Precio:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(121, 105, 89, 36);
        camposPanel.add(label_2);
        camposPanel.add(precioField);
        JLabel label_3 = new JLabel("Cantidad Disponible:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(38, 152, 172, 36);
        camposPanel.add(label_3);
        camposPanel.add(cantidadDisponibleField);
        JLabel label_4 = new JLabel("Número de Serie:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(38, 199, 172, 36);
        camposPanel.add(label_4);
        camposPanel.add(numeroSerieField);
        JLabel lblConexinParaMicroprocesador = new JLabel("Conexi\u00F3n para Microprocesador:");
        lblConexinParaMicroprocesador.setHorizontalAlignment(SwingConstants.RIGHT);
        lblConexinParaMicroprocesador.setBounds(38, 246, 172, 36);
        camposPanel.add(lblConexinParaMicroprocesador);
        camposPanel.add(tipoConexionMicroprocesadorField);
        JLabel label_6 = new JLabel("Velocidad de Procesamiento:");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(38, 293, 172, 36);
        camposPanel.add(label_6);
        camposPanel.add(velocidadProcesamientoField);

        // Crear un panel principal para contener los paneles de campos y botones
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(camposPanel);
        
                // Crear un botón "Guardar" que al ser presionado, actualizará los atributos del microprocesador con los valores de los componentes visuales
                JButton guardarButton = new JButton("Guardar");
                guardarButton.setBounds(240, 348, 100, 31);
                camposPanel.add(guardarButton);
                
                        // Crear un botón "Cancelar" que cerrará el diálogo sin guardar cambios
                        JButton cancelarButton = new JButton("Cancelar");
                        cancelarButton.setBounds(350, 348, 100, 31);
                        camposPanel.add(cancelarButton);
                        cancelarButton.addActionListener(e -> dispose());
                guardarButton.addActionListener(e -> guardarCambios());

        // Mostrar el panel en el diálogo
        getContentPane().add(panel);

        // Establecer el tamaño y la posición del diálogo
        setSize(476, 429);
        setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
    }

    private void guardarCambios() {
        // Actualizar los atributos del microprocesador con los valores de los componentes visuales
        microprocesador.setMarca(marcaField.getText());
        microprocesador.setModelo(modeloField.getText());
        microprocesador.setPrecio(Double.parseDouble(precioField.getText()));
        microprocesador.setCantidadDisponible(Integer.parseInt(cantidadDisponibleField.getText()));
        microprocesador.setNumeroSerie(numeroSerieField.getText());
        microprocesador.setTipoConexion(tipoConexionMicroprocesadorField.getText());
        microprocesador.setVelocidadProcesamiento(Double.parseDouble(velocidadProcesamientoField.getText()));

        // Aquí puedes realizar las validaciones y acciones necesarias para guardar los cambios en la tienda o en algún otro lugar

        // Cerrar el diálogo
        dispose();
    }
}
