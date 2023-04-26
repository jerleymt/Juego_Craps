package Vista;

import Control.Controlador;
import Modelo.Model_craps;
import Modelo.Tirar_dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_FINAL="Bienvenido a Craps"
            +"\nOprime el botón lanzar para iniciar el juego"
            +"\nSi tu tiro de salida es 7 u 11 ganas con Natural"
            +"\nSi tu tiro de salida es 2, 3 u 12 pierdes con Craps"
            +"\nSi sacas cualquier otT_o valor establecerás el Punto"
            +"\nEstado en pyntp podrás seyggt lanzando los dados"
            +"\npero ahora ganarás si sacas nuevamente el valor del Punto"
            +"\nsin que previamente hayas sacado 7";

    private Header headerProject;
    private JLabel dado1, dado2;
    private JButton lanzar, ayuda, salir;
    private JPanel panel_dados, panel_resultado;
    private ImageIcon imagen_dado;
    private JTextArea mostrar_resultado, mostrar_punto;
    private Escucha get_escucha;
    private Tirar_dados lanzar_dado;
    private Model_craps model_craps;
    private Controlador control;
    private JScrollPane scrolear;

    public GUIGridBagLayout() {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Juego Craps | erley");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Set up JFrame Container's Layout
        //obtengo el elcontenedor dela ventana y le pongo el nuevo layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        get_escucha = new Escucha();
        lanzar_dado = new Tirar_dados();
        model_craps = new Model_craps();
        control = new Controlador();
        //Set up JComponents
        headerProject = new Header("Mesa Juego Craps", Color.BLACK);

        //Conffiguramos constrain
        constraints.gridx=0;
        constraints. gridy=0;
        constraints. gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;

        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            control.inicio(2);
            Vector<Integer> face = control.getCara();
            imagen_dado = new ImageIcon(getClass().getResource("/Recursos/"+face.get(0)+".png"));
            dado1.setIcon(imagen_dado);
            imagen_dado = new ImageIcon(getClass().getResource("/Recursos/"+face.get(1)+".png"));
            dado2.setIcon(imagen_dado);


            //quita todo lo que tenia
            panel_resultado.removeAll();
            panel_resultado.setBorder(BorderFactory.createTitledBorder("Resultado"));

            panel_resultado.add(mostrar_resultado);
            panel_resultado.add(mostrar_punto);

            mostrar_resultado.setText(control.getEstado_string().get(0));
            mostrar_punto.setText(control.getEstado_string().get(1));

        }
    }

}

