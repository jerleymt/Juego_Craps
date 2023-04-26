package Vista;


import javax.swing.*;
import java.awt.*;

public class JFrameRedondeado extends JFrame {

    public JFrameRedondeado() {
        // Configurar el título y el tamaño del JFrame
        setTitle("JFrame Redondeado");
        setSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUndecorated(true);
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255,0));
//        pack();
        setResizable(true);
        setVisible(true);



        // Crear un JPanel personalizado con bordes redondeados
        JPanel panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(40, 40); // Tamaño de los bordes redondeados
                int width = getWidth();
                int height = getHeight();
                Graphics graphics = g.create();
                // Dibujar un rectángulo redondeado
                graphics.setColor(Color.BLUE); // Cambiar el color de fondo del panel
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
//                graphics.setColor(Color.BLACK); // Cambiar el color del borde del panel
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
                graphics.dispose();
            }
        };

        // Establecer el JPanel como el contenido del JFrame
        setContentPane(panel);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrameRedondeado frame = new JFrameRedondeado();
            frame.setVisible(true);
        });
    }
}
