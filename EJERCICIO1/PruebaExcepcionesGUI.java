
package EJERCICIO1;

import javax.swing.*;
import java.awt.*;

public class PruebaExcepcionesGUI extends JFrame {

    private JTextArea consola;
    private JButton btnEjecutar;
    private JButton btnLimpiar;

    public PruebaExcepcionesGUI() {

        setTitle("Ejercicio 6.4 - Prueba de Excepciones");
        setSize(650, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titulo = new JLabel(
            "PRUEBA DE EXCEPCIONES",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel descripcion = new JLabel(
            "Demostración de los bloques try, catch y finally",
            SwingConstants.CENTER
        );

        JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        panelSuperior.add(titulo);
        panelSuperior.add(descripcion);

        consola = new JTextArea();
        consola.setEditable(false);
        consola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        consola.setText(
            "Bienvenido al ejercicio 6.4.\n" +
            "Presione 'Ejecutar prueba' para comenzar.\n"
        );

        JScrollPane scroll = new JScrollPane(consola);

        btnEjecutar = new JButton("Ejecutar prueba");
        btnLimpiar = new JButton("Limpiar consola");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEjecutar);
        panelBotones.add(btnLimpiar);

        btnEjecutar.addActionListener(e -> ejecutarPrueba());

        btnLimpiar.addActionListener(e -> {
            consola.setText("");
        });

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void ejecutarPrueba() {

        consola.setText("");

        consola.append("PRIMER BLOQUE TRY\n");
        consola.append("-----------------------------\n");

        try {

            consola.append("Ingresando al primer try.\n");

            int divisor = 0;
            double cociente = 10000 / divisor;

            consola.append("Después de la división: " + cociente + "\n");

        } catch (ArithmeticException e) {

            consola.append("División por cero.\n");

        } finally {

            consola.append("Ingresando al primer finally.\n");
        }

        consola.append("\nSEGUNDO BLOQUE TRY\n");
        consola.append("-----------------------------\n");

        try {

            consola.append("Ingresando al segundo try.\n");

            Object objeto = null;
            objeto.toString();

            consola.append("Imprimiendo objeto.\n");

        } catch (ArithmeticException e) {

            consola.append("División por cero.\n");

        } catch (Exception e) {

            consola.append("Ocurrió una excepción.\n");

        } finally {

            consola.append("Ingresando al segundo finally.\n");
        }

        consola.append("\nEJECUCIÓN FINALIZADA.\n");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PruebaExcepcionesGUI ventana =
                new PruebaExcepcionesGUI();

            ventana.setVisible(true);
        });
    }
}
