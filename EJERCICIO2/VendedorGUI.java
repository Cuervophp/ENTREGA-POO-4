package EJERCICIO2;


import javax.swing.*;
import java.awt.*;

public class VendedorGUI extends JFrame {

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoEdad;
    private JTextArea resultado;

    private JButton btnRegistrar;
    private JButton btnLimpiar;

    public VendedorGUI() {
        setTitle("Registro de vendedores");
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JPanel panelFormulario = new JPanel(
            new GridLayout(3, 2, 10, 10)
        );

        campoNombre = new JTextField();
        campoApellido = new JTextField();
        campoEdad = new JTextField();

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);

        panelFormulario.add(new JLabel("Apellido:"));
        panelFormulario.add(campoApellido);

        panelFormulario.add(new JLabel("Edad:"));
        panelFormulario.add(campoEdad);

        btnRegistrar = new JButton("Registrar vendedor");
        btnLimpiar = new JButton("Limpiar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);

        resultado = new JTextArea(8, 30);
        resultado.setEditable(false);
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(resultado);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnRegistrar.addActionListener(e -> registrarVendedor());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void registrarVendedor() {

        try {
            String nombre = campoNombre.getText().trim();
            String apellido = campoApellido.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                throw new IllegalArgumentException(
                    "Debes ingresar el nombre y el apellido."
                );
            }

            int edad = Integer.parseInt(campoEdad.getText().trim());

            Vendedor vendedor = new Vendedor(
                nombre, apellido, edad
            );

            resultado.setText(
                "VENDEDOR REGISTRADO CORRECTAMENTE\n\n"
                + vendedor.toString()
            );

        } catch (NumberFormatException e) {

            resultado.setText(
                "ERROR: La edad debe ser un número entero."
            );

        } catch (IllegalArgumentException e) {

            resultado.setText(
                "ERROR: " + e.getMessage()
            );
        }
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoEdad.setText("");
        resultado.setText("");
        campoNombre.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VendedorGUI ventana = new VendedorGUI();
            ventana.setVisible(true);
        });
    }
}
