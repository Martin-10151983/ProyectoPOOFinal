package Visual;

import javax.swing.*;
import logico.Disco;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar_Disco extends JDialog {
    private Disco discoDuro;

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField precioField;
    private JTextField cantidadDisponibleField;
    private JTextField numeroSerieField;
    private JTextField tipoConexionField;
    private JTextField capacidadAlmacenamientoField;

    public Editar_Disco(Ver_Componente parent, Disco discoDuro) {
        super(parent, "Editar Disco Duro", true);
        setResizable(false);
        setSize(416, 400);
        this.discoDuro = discoDuro;
        initComponents();
    }

    private void initComponents() {
        // Crear los componentes visuales y diseñar la interfaz del diálogo
        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        marcaLabel.setBounds(60, 10, 123, 32);
        marcaField = new JTextField(20);
        marcaField.setBounds(193, 10, 123, 32);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        modeloLabel.setBounds(60, 50, 123, 32);
        modeloField = new JTextField(20);
        modeloField.setBounds(193, 50, 123, 32);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        precioLabel.setBounds(60, 93, 123, 32);
        precioField = new JTextField(20);
        precioField.setBounds(193, 93, 123, 32);

        JLabel cantidadDisponibleLabel = new JLabel("Cantidad Disponible:");
        cantidadDisponibleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        cantidadDisponibleLabel.setBounds(60, 136, 123, 32);
        cantidadDisponibleField = new JTextField(20);
        cantidadDisponibleField.setBounds(193, 136, 123, 32);

        JLabel numeroSerieLabel = new JLabel("Número de Serie:");
        numeroSerieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        numeroSerieLabel.setBounds(10, 179, 173, 32);
        numeroSerieField = new JTextField(20);
        numeroSerieField.setBounds(193, 179, 123, 32);

        JLabel tipoConexionLabel = new JLabel("Tipo de Conexión:");
        tipoConexionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        tipoConexionLabel.setBounds(10, 222, 173, 32);
        tipoConexionField = new JTextField(20);
        tipoConexionField.setBounds(193, 222, 123, 32);

        JLabel capacidadAlmacenamientoLabel = new JLabel("Capacidad de Almacenamiento:");
        capacidadAlmacenamientoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        capacidadAlmacenamientoLabel.setBounds(10, 265, 173, 32);
        capacidadAlmacenamientoField = new JTextField(20);
        capacidadAlmacenamientoField.setBounds(193, 265, 123, 32);

        // Cargar la información del Disco Duro en los campos de texto
        cargarInformacionDiscoDuro();
        getContentPane().setLayout(null);

        // Crear el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 400, 361);
        mainPanel.setLayout(null);
        mainPanel.add(marcaLabel);
        mainPanel.add(marcaField);
        mainPanel.add(modeloLabel);
        mainPanel.add(modeloField);
        mainPanel.add(precioLabel);
        mainPanel.add(precioField);
        mainPanel.add(cantidadDisponibleLabel);
        mainPanel.add(cantidadDisponibleField);
        mainPanel.add(numeroSerieLabel);
        mainPanel.add(numeroSerieField);
        mainPanel.add(tipoConexionLabel);
        mainPanel.add(tipoConexionField);
        mainPanel.add(capacidadAlmacenamientoLabel);
        mainPanel.add(capacidadAlmacenamientoField);

        // Mostrar el panel en el diálogo
        getContentPane().add(mainPanel);
        
                // Botón para guardar los cambios
                JButton guardarButton = new JButton("Guardar");
                guardarButton.setBounds(182, 327, 99, 23);
                mainPanel.add(guardarButton);
                
                JButton btnCancelar = new JButton("Cancelar");
                btnCancelar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		dispose();
                	}
                });
                btnCancelar.setBounds(291, 327, 99, 23);
                mainPanel.add(btnCancelar);
                guardarButton.addActionListener(e -> guardarCambios());

        // Establecer el tamaño y la posición del diálogo
        setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
    }

    private void cargarInformacionDiscoDuro() {
        marcaField.setText(discoDuro.getMarca());
        modeloField.setText(discoDuro.getModelo());
        precioField.setText(String.valueOf(discoDuro.getPrecio()));
        cantidadDisponibleField.setText(String.valueOf(discoDuro.getCantidadDisponible()));
        numeroSerieField.setText(discoDuro.getNumeroSerie());
        tipoConexionField.setText(discoDuro.getTipoConexion());
        capacidadAlmacenamientoField.setText(String.valueOf(discoDuro.getCapacidadAlmacenamiento()));
    }

    private void guardarCambios() {
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        double precio = Double.parseDouble(precioField.getText());
        int cantidadDisponible = Integer.parseInt(cantidadDisponibleField.getText());
        String numeroSerie = numeroSerieField.getText();
        String tipoConexion = tipoConexionField.getText();
        int capacidadAlmacenamiento = Integer.parseInt(capacidadAlmacenamientoField.getText());

        // Aplicar los cambios al Disco Duro
        discoDuro.setMarca(marca);
        discoDuro.setModelo(modelo);
        discoDuro.setPrecio(precio);
        discoDuro.setCantidadDisponible(cantidadDisponible);
        discoDuro.setNumeroSerie(numeroSerie);
        discoDuro.setTipoConexion(tipoConexion);
        discoDuro.setCapacidadAlmacenamiento(capacidadAlmacenamiento);

        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Guardar Cambios",
                JOptionPane.INFORMATION_MESSAGE);

        dispose(); // Cerrar el diálogo
    }
}
