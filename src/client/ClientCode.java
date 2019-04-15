package client;

import matrix.*;

public class ClientCode {
    public static void main(String[] args) {
        int row = 30, column = 30;
        Matrix dMatrix = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix, 900, 100);
        matrixInfo(dMatrix);
        System.out.println("-----------------------------------------------------------------");
        Matrix sMatrix = new SparseMatrix(row, column);
        InitMatrix.fillMatrix(sMatrix, 400, 900);
        matrixInfo(sMatrix);
    }

    private static void matrixInfo(IMatrix m) {
        m.draw();
        System.out.println("sumElems: " + StatMatrix.sumValues(m));
        System.out.println("avgValue: " + StatMatrix.avgValue(m));
        System.out.println("maxValue: " + StatMatrix.maxValue(m));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(m));
    }
}
