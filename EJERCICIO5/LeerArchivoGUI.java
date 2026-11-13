package EJERCICIO5;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LeerArchivoGUI extends JFrame {

    private JTextArea areaContenido;
    private JLabel etiquetaArchivo;

    private JButton btnAbrir;
    private JButton btnMayusculas;
    private JButton btnLimpiar;

    private String contenidoOriginal = "";

    public LeerArchivoGUI() {

        setTitle("Lector de archivos de texto");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));

        etiquetaArchivo = new JLabel("Ningún archivo seleccionado");

        btnAbrir = new JButton("Abrir archivo");

        panelSuperior.add(etiquetaArchivo, BorderLayout.CENTER);
        panelSuperior.add(btnAbrir, BorderLayout.EAST);

        areaContenido = new JTextArea();
        areaContenido.setEditable(false);
        areaContenido.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaContenido.setLineWrap(true);
        areaContenido.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaContenido);

        JPanel panelBotones = new JPanel();

        btnMayusculas = new JButton("Convertir a mayúsculas");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnMayusculas);
        panelBotones.add(btnLimpiar);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnAbrir.addActionListener(e -> abrirArchivo());

        btnMayusculas.addActionListener(e -> convertirMayusculas());

        btnLimpiar.addActionListener(e -> limpiar());
    }

    private void abrirArchivo() {

        JFileChooser selector = new JFileChooser();

        int seleccion = selector.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            try {

                contenidoOriginal = LeerArchivo.leerContenido(archivo);

                areaContenido.setText(contenidoOriginal);

                etiquetaArchivo.setText(
                    "Archivo: " + archivo.getName()
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                    this,
                    "No fue posible leer el archivo: " + e.getMessage(),
                    "Error de lectura",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void convertirMayusculas() {

        if (contenidoOriginal.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Primero debes abrir un archivo.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String textoMayusculas =
            LeerArchivo.convertirMayusculas(contenidoOriginal);

        areaContenido.setText(textoMayusculas);
    }

    private void limpiar() {

        areaContenido.setText("");

        etiquetaArchivo.setText(
            "Ningún archivo seleccionado"
        );

        contenidoOriginal = "";
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LeerArchivoGUI ventana = new LeerArchivoGUI();

            ventana.setVisible(true);
        });
    }
}
