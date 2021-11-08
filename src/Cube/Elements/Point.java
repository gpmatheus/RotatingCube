package Cube.Elements;

public class Point {
    
    private double[][] coordinates;

    public Point (double x, double y, double z) {

        coordinates = new double[][] {{x}, {y}, {z}, {1f}};
    }

    public void setMatrix(double[][] matrix) {
        coordinates = matrix;
    }

    public double[][] getMatrix() {
        return coordinates;
    }
}
