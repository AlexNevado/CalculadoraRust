import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Dark_Trainer on 08/07/2017.
 */
public class VentanaCalculadora extends JFrame {


    private static final long serialVersionUID = 1583724102189855698L;

    /** numero tecleado */
    JTextField result;
    private JTextField maderaUsar;

    /** guarda el resultado de la operacion anterior o el número tecleado */
    double wresultado;

    /** para guardar la operacion a realizar */
    String operacion;

    /** Los paneles donde colocaremos los botones */
    JPanel panelNumeros, panelOperaciones;

    /** Indica si estamos iniciando o no una operación */
    boolean nuevaOperacion = true;

    /**
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public VentanaCalculadora() {
        super();
        setSize(250, 300);
        setTitle("Calculadora Rusto");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        result = new JTextField("0", 20);
        result.setBorder(new EmptyBorder(4, 4, 4, 4));
        result.setFont(new Font("Arial", Font.BOLD, 25));
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);
        result.setBackground(Color.WHITE);
        panel.add("North", result);

        maderaUsar = new JTextField("0", 20);
        maderaUsar.setBorder(new EmptyBorder(4, 4, 4, 4));
        maderaUsar.setFont(new Font("Arial", Font.BOLD, 25));
        maderaUsar.setHorizontalAlignment(JTextField.RIGHT);
        maderaUsar.setEditable(true);
        maderaUsar.setBackground(Color.WHITE);
        panel.add("Center", maderaUsar);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("Metal");
        nuevoBotonOperacion("Sulfuro");
        nuevoBotonOperacion("Metal Bueno");

        panel.add("East", panelOperaciones);

        validate();
    }


    /**
     * Crea un botón de operacion y lo enlaza con sus eventos.
     *
     * @param operacion
     */
    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.RED);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                calcularResultado(btn.getText());
            }
        });

        panelOperaciones.add(btn);
    }

    /**
     * Calcula el resultado y lo muestra por pantalla
     */
    private void calcularResultado(String operacion) {
        if (operacion.equals("Metal")) {
            resultado = metal(Double.parseDouble(maderaUsar.getText()));
        } else if (operacion.equals("Sulfuro")) {
            resultado = sulfuro(Double.parseDouble(maderaUsar.getText()));
        } else if (operacion.equals("Metal Bueno")) {
            resultado = metalBueno(Double.parseDouble(maderaUsar.getText()));
        }
        result.setText("" + resultado);
        resultado = 0;
    }

    private Double metal(Double madera){
        return madera/5;
    }

    private Double sulfuro(Double madera){
        return madera/2.5;
    }

    private Double metalBueno(Double madera){
        return madera/10;
    }
}