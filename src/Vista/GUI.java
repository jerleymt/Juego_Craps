package Vista;

import Control.Controlador;
import Modelo.Model_craps;
import Modelo.Tirar_dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    // "final" significa que esta variable es constante, siempre se nombran con MAYUSCULAS y snake_case
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
    private JButton lanzar;
    private JPanel panel_dados, panel_resultado;
    private ImageIcon imagen_dado;
    private JTextArea mostrar_resultado, mostrar_punto;
    private Escucha get_escucha;
    private Tirar_dados lanzar_dado;
    private Model_craps model_craps;
    private Controlador control;
    private JScrollPane scrolear;
    private JSeparator separator;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Juego Craps | erley");
//        this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        get_escucha = new Escucha();
        lanzar_dado = new Tirar_dados();
        model_craps = new Model_craps();
        control = new Controlador();
        //Set up JComponents
        headerProject = new Header("Mesa Juego Craps", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        //"getClass" es un puntero; acedo a un metodo de cualquier clase
        imagen_dado = new ImageIcon(getClass().getResource("/Recursos/dado.png"));
        dado1 = new JLabel(imagen_dado);
        dado2 = new JLabel(imagen_dado);

        lanzar = new JButton("LANZAR");
        lanzar.addActionListener(get_escucha);

        panel_dados = new JPanel();
        panel_dados.setPreferredSize(new Dimension(400,250));
        panel_dados.setBorder(BorderFactory.createTitledBorder("Tus dados"));
        panel_dados.add(dado1);
        panel_dados.add(dado2);
        panel_dados.add(lanzar);

        mostrar_punto = new JTextArea(6,31);

        mostrar_resultado = new JTextArea(6,31);
        mostrar_resultado.setText(MENSAJE_FINAL);
        scrolear = new JScrollPane(mostrar_resultado);

        separator = new JSeparator();
        separator.setPreferredSize(new Dimension(350,7));
        separator.setBackground(Color.BLACK);

        panel_resultado = new JPanel();
        panel_resultado.setPreferredSize(new Dimension(400,250));
        String texto_panel = new String();
        panel_resultado.setBorder(BorderFactory.createTitledBorder("Que debes hacer"));
        panel_resultado.add(scrolear);

        this.add(panel_dados,BorderLayout.CENTER);
        this.add(panel_resultado,BorderLayout.EAST);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }
    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
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
            panel_resultado.add(separator);
            panel_resultado.add(mostrar_punto);

            mostrar_resultado.setText(control.getEstado_string().get(1));
            mostrar_punto.setText(control.getEstado_string().get(0));

            revalidate();
            repaint();
        }
    }
}
