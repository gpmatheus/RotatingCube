package Cube;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Cube.Auxiliar.MatMath;
import Cube.Elements.Point;

public class Display extends JPanel implements Runnable {

    private static final int size = 900;
    private static final int parameter = 50;

    private CubeBody cube = new CubeBody();
    
    public static void main(String[] args) {

        Display d = new Display();
        d.rotate();
    }

    public Display() {

        setBackground(Color.BLACK);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);
    }

    public void rotate() {

        Thread rotation = new Thread(this);
        rotation.start();
    }

    @Override
    public void run() {
        
        while (true) {

            try {
                Thread.sleep(5);
            } catch (Exception e) {}

            cube.rotate(.4f, .3f, .2f);

            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Point[] points = cube.getVertices();

        double x;
        double y;

        for (int i = 0; i < points.length; i++) {

            double[][] projected = projectMatrix(points[i].getMatrix());

            x = projected[0][0] * parameter + size / 2;
            y = (projected[1][0] * parameter) * -1 + size / 2;

            g.setColor(Color.GREEN);
            g.drawLine((int) x,(int) y,(int) x,(int) y);
        }
    }

    private double[][] projectionMatrix = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    };

    private double[][] projectMatrix(double[][] coordinates) {

        return MatMath.matmul(projectionMatrix, coordinates);  
    }
}
