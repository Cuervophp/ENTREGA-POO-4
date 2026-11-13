package EJERCICIO3;


import javax.swing.*;
import java.awt.*;

public class CalculosNumericosGUI extends JFrame {

    private JTextField campoNumero;
    private JTextArea resultado;

    private JButton btnLogaritmo;
    private JButton btnRaiz;
    private JButton btnLimpiar;

    public CalculosNumericosGUI() {

        setTitle("Cálculos Numéricos");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));

        campoNumero = new JTextField();

        panelEntrada.add(new JLabel("Ingrese un número:"));
        panelEntrada.add(campoNumero);

        btnLogaritmo = new JButton("Logaritmo natural");
        btnRaiz = new JButton("Raíz cuadrada");
        btnLimpiar = new JButton("Limpiar");

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 5, 5));

        panelBotones.add(btnLogaritmo);
        panelBotones.add(btnRaiz);
        panelBotones.add(btnLimpiar);

        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(resultado);

        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnLogaritmo.addActionListener(
            e -> calcularLogaritmo()
        );

        btnRaiz.addActionListener(
            e -> calcularRaiz()
        );

        btnLimpiar.addActionListener(
            e -> limpiar()
        );
    }

    private double obtenerNumero() {

        return Double.parseDouble(
            campoNumero.getText().trim()
        );
    }

    private void calcularLogaritmo() {

        try {

            double numero = obtenerNumero();

            double valor = CalculosNumericos.calcularLogaritmo(numero);

            resultado.setText(
                "OPERACIÓN: LOGARITMO NATURAL\n\n"
                + "Número ingresado: " + numero
                + "\nResultado: " + valor
            );

        } catch (NumberFormatException e) {

            resultado.setText(
                "ERROR: Debes ingresar un número válido."
            );

        } catch (IllegalArgumentException e) {

            resultado.setText(
                "ERROR: " + e.getMessage()
            );
        }
    }

    private void calcularRaiz() {

        try {

            double numero = obtenerNumero();

            double valor = CalculosNumericos.calcularRaizCuadrada(numero);

            resultado.setText(
                "OPERACIÓN: RAÍZ CUADRADA\n\n"
                + "Número ingresado: " + numero
                + "\nResultado: " + valor
            );

        } catch (NumberFormatException e) {

            resultado.setText(
                "ERROR: Debes ingresar un número válido."
            );

        } catch (IllegalArgumentException e) {

            resultado.setText(
                "ERROR: " + e.getMessage()
            );
        }
    }

    private void limpiar() {

        campoNumero.setText("");
        resultado.setText("");
        campoNumero.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CalculosNumericosGUI ventana =
                new CalculosNumericosGUI();

            ventana.setVisible(true);
        });
    }
}

