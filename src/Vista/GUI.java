package Vista;

import Control.Controlador;

import javax.swing.*;
import java.awt.*;

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
    private JTextArea resultado;

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
        //Set up JComponents
        headerProject = new Header("Mesa Juego Craps", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        //"getClass" es un puntero; acedo a un metodo de cualquier clase
        imagen_dado = new ImageIcon(getClass().getResource("/Recursos/dado.png"));
        dado1 = new JLabel(imagen_dado);
        dado2 = new JLabel(imagen_dado);

        lanzar = new JButton("LANZAR");

        panel_dados = new JPanel();
        panel_dados.setPreferredSize(new Dimension(400,250));
        panel_dados.setBorder(BorderFactory.createTitledBorder("Tus dados"));
        panel_dados.add(dado1);
        panel_dados.add(dado2);
        panel_dados.add(lanzar);

        this.add(panel_dados,BorderLayout.CENTER);

        resultado = new JTextArea(7,31);
        resultado.setText(MENSAJE_FINAL);
        resultado.setBorder((BorderFactory.createTitledBorder("Que deves hacer")));
        JScrollPane scrolear = new JScrollPane(resultado);
        this.add(scrolear,BorderLayout.EAST);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
            Controlador iniciar_juego = new Controlador(2);
            int flag = iniciar_juego.getFlag();
            iniciar_juego.setFlag(flag);
            iniciar_juego.inicio();
            System.out.println("GUI flag = "+iniciar_juego.getFlag());
        });
    }
    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
