package EJERCICIO4;


import javax.swing.*;
import java.awt.*;

public class EquipoMaratonGUI extends JFrame {

    private JTextField campoEquipo;
    private JTextField campoUniversidad;
    private JTextField campoLenguaje;

    private JTextField campoNombre;
    private JTextField campoApellido;

    private JTextArea resultado;
    private JLabel etiquetaCantidad;

    private JButton btnCrearEquipo;
    private JButton btnAgregar;
    private JButton btnFinalizar;
    private JButton btnLimpiar;

    private EquipoMaratonProgramacion equipo;

    public EquipoMaratonGUI() {

        setTitle("Registro de equipo de maratón");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JPanel panelEquipo = new JPanel(new GridLayout(4, 2, 8, 8));

        panelEquipo.setBorder(
            BorderFactory.createTitledBorder("Datos del equipo")
        );

        campoEquipo = new JTextField();
        campoUniversidad = new JTextField();
        campoLenguaje = new JTextField();

        btnCrearEquipo = new JButton("Crear equipo");

        panelEquipo.add(new JLabel("Nombre del equipo:"));
        panelEquipo.add(campoEquipo);

        panelEquipo.add(new JLabel("Universidad:"));
        panelEquipo.add(campoUniversidad);

        panelEquipo.add(new JLabel("Lenguaje:"));
        panelEquipo.add(campoLenguaje);

        panelEquipo.add(new JLabel(""));
        panelEquipo.add(btnCrearEquipo);

        JPanel panelProgramadores = new JPanel(
            new GridLayout(3, 2, 8, 8)
        );

        panelProgramadores.setBorder(
            BorderFactory.createTitledBorder("Agregar programadores")
        );

        campoNombre = new JTextField();
        campoApellido = new JTextField();

        btnAgregar = new JButton("Agregar programador");

        etiquetaCantidad = new JLabel("Programadores registrados: 0 / 3");

        panelProgramadores.add(new JLabel("Nombre:"));
        panelProgramadores.add(campoNombre);

        panelProgramadores.add(new JLabel("Apellido:"));
        panelProgramadores.add(campoApellido);

        panelProgramadores.add(btnAgregar);
        panelProgramadores.add(etiquetaCantidad);

        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(resultado);

        JPanel panelBotones = new JPanel();

        btnFinalizar = new JButton("Finalizar equipo");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnFinalizar);
        panelBotones.add(btnLimpiar);

        JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 10, 10));

        panelSuperior.add(panelEquipo);
        panelSuperior.add(panelProgramadores);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnCrearEquipo.addActionListener(e -> crearEquipo());

        btnAgregar.addActionListener(e -> agregarProgramador());

        btnFinalizar.addActionListener(e -> finalizarEquipo());

        btnLimpiar.addActionListener(e -> limpiar());
    }

    private void crearEquipo() {

        try {

            equipo = new EquipoMaratonProgramacion(
                campoEquipo.getText(),
                campoUniversidad.getText(),
                campoLenguaje.getText()
            );

            resultado.setText(
                "Equipo creado correctamente.\n"
                + "Ahora puedes agregar los programadores."
            );

            actualizarCantidad();

        } catch (IllegalArgumentException e) {

            resultado.setText("ERROR: " + e.getMessage());
        }
    }

    private void agregarProgramador() {

        try {

            if (equipo == null) {
                throw new IllegalArgumentException(
                    "Primero debes crear el equipo."
                );
            }

            Programador programador = new Programador(
                campoNombre.getText(),
                campoApellido.getText()
            );

            equipo.agregarProgramador(programador);

            resultado.setText(
                "Programador agregado correctamente:\n\n"
                + programador.toString()
            );

            campoNombre.setText("");
            campoApellido.setText("");

            actualizarCantidad();

        } catch (IllegalArgumentException e) {

            resultado.setText("ERROR: " + e.getMessage());
        }
    }

    private void finalizarEquipo() {

        try {

            if (equipo == null) {
                throw new IllegalArgumentException(
                    "Primero debes crear el equipo."
                );
            }

            equipo.verificarEquipo();

            resultado.setText(
                "EQUIPO REGISTRADO CORRECTAMENTE\n\n"
                + equipo.mostrarInformacion()
            );

        } catch (IllegalArgumentException e) {

            resultado.setText("ERROR: " + e.getMessage());
        }
    }

    private void actualizarCantidad() {

        int cantidad = equipo == null
            ? 0
            : equipo.getCantidadProgramadores();

        etiquetaCantidad.setText(
            "Programadores registrados: " + cantidad + " / 3"
        );
    }

    private void limpiar() {

        campoEquipo.setText("");
        campoUniversidad.setText("");
        campoLenguaje.setText("");

        campoNombre.setText("");
        campoApellido.setText("");

        resultado.setText("");

        equipo = null;

        actualizarCantidad();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            EquipoMaratonGUI ventana = new EquipoMaratonGUI();

            ventana.setVisible(true);
        });
    }
}
