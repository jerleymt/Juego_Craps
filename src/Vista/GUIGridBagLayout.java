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
    private JPanel panel_dados, panel_resultado, margen;
    private ImageIcon imagen_dado;
    private JTextArea mostrar_resultado, mostrar_punto, mensaje_salida;
    private Escucha get_escucha;
    private Tirar_dados lanzar_dado;
    private Model_craps model_craps;
    private Controlador control;
    private JScrollPane scrolear;
    private   Insets insets;

    public GUIGridBagLayout() {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Juego Craps | erley");
        this.setUndecorated(true);
//        this.setLocationRelativeTo(null);
//        this.setBackground(new Color(255,255,255,100));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
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

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(get_escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints. fill=GridBagConstraints .NONE;
        constraints. anchor=GridBagConstraints.LINE_START;

        this.add(ayuda,constraints);

        salir = new JButton("SALIR");
        salir.addActionListener(get_escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints. fill=GridBagConstraints .NONE;
        constraints. anchor=GridBagConstraints.LINE_END;

        this.add(salir,constraints);

        imagen_dado = new ImageIcon(getClass().getResource("/Recursos/dado.png"));
        dado1 = new JLabel(imagen_dado);
        dado2 = new JLabel(imagen_dado);

        panel_dados = new JPanel();
        panel_dados.setPreferredSize(new Dimension(350,200));
        panel_dados.setBorder(BorderFactory.createTitledBorder("Tus dados"));
        panel_dados.add(dado1);
        panel_dados.add(dado2);

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints. fill=GridBagConstraints .BOTH;
        constraints. anchor=GridBagConstraints.CENTER;
        this.add(panel_dados,constraints);

        mostrar_resultado = new JTextArea(6,31);
        mostrar_resultado.setBackground(null);
        mostrar_resultado.setText("Debes lanzar los dados");
        mostrar_resultado.setBorder(BorderFactory.createTitledBorder("Resultados"));
        mostrar_resultado.setEditable(false);

        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints. fill=GridBagConstraints.BOTH;
        constraints. anchor=GridBagConstraints.CENTER;
        this.add(mostrar_resultado,constraints);

        lanzar = new JButton("LANZAR");
        lanzar.addActionListener(get_escucha);

        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints. fill=GridBagConstraints.NONE;
        constraints. anchor=GridBagConstraints.CENTER;
        this.add(lanzar,constraints);

        //Creo un objeto deltipo insent para hacer el margen que luego pongoen un borde vacio
        insets = new Insets(25, 10, 25, 10);

        mensaje_salida = new JTextArea(4,31);
        mensaje_salida.setBackground(null);
        mensaje_salida.setText("Usa el boton ayuda para ver las reglas del juego");
        mensaje_salida.setEditable(false);
        mensaje_salida.setBorder(BorderFactory.createTitledBorder("Mensajes"));

        margen = new JPanel();
        margen.setBorder(BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));
        margen.add(mensaje_salida);

//        scrolear = new JScrollPane(mensaje_salida);

        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints. fill=GridBagConstraints.NONE;
        constraints. anchor=GridBagConstraints.CENTER;
        this.add(margen,constraints);


    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand()=="LANZAR") {
                control.inicio(2);
                Vector<Integer> face = control.getCara();
                imagen_dado = new ImageIcon(getClass().getResource("/Recursos/" + face.get(0) + ".png"));
                dado1.setIcon(imagen_dado);
                imagen_dado = new ImageIcon(getClass().getResource("/Recursos/" + face.get(1) + ".png"));
                dado2.setIcon(imagen_dado);

                mostrar_resultado.setText(control.getEstado_string().get(0));
                mensaje_salida.setText(control.getEstado_string().get(1));
            }
            else if (e.getActionCommand()==" ? "){
                JOptionPane.showMessageDialog(null,MENSAJE_FINAL);
            }
            else if (e.getActionCommand()=="SALIR"){

                System.exit(0);
            }



        }
    }

}

