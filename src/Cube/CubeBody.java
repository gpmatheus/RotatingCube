package Cube;

import Cube.Auxiliar.MatMath;
import Cube.Elements.Point;

public class CubeBody {
    
    public Point[] vertices = {
        new Point(-1f, -1f, -1f),
        new Point(-1f, 1f, -1f),
        new Point(1f, 1f, -1f),
        new Point(1f, -1f, -1f),
        new Point(-1f, -1f, 1f),
        new Point(-1f, 1f, 1f),
        new Point(1f, 1f, 1f),
        new Point(1f, -1f, 1f)
    };

    public Point[] getVertices() {
        return vertices;
    }

    public void rotate(double x, double y, double z) {

        double[][] rotateX = {
            {1, 0, 0},
            {0, Math.cos(Math.toRadians(x)), Math.sin(Math.toRadians(x))},
            {0, -Math.sin(Math.toRadians(x)), Math.cos(Math.toRadians(x))}
        };

        double[][] rotateY = {
            {Math.cos(Math.toRadians(y)), 0, -Math.sin(Math.toRadians(y))},
            {0, 1, 0},
            {Math.sin(Math.toRadians(y)), 0, Math.cos(Math.toRadians(y))}
        };

        double[][] rotateZ = {
            {Math.cos(Math.toRadians(z)), Math.sin(Math.toRadians(z)), 0},
            {-Math.sin(Math.toRadians(z)), Math.cos(Math.toRadians(z)), 0},
            {0, 0, 1}
        };

        double[][] rotateMatrix = MatMath.matmul(rotateX, rotateY);
        rotateMatrix = MatMath.matmul(rotateZ, rotateMatrix);

        for (int i = 0; i < vertices.length; i++) {

            vertices[i].setMatrix(MatMath.matmul(rotateMatrix, vertices[i].getMatrix()));
        }
    }
}
