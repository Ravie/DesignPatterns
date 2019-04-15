package client;

import matrix.*;

public class ClientCode {
    public static void main(String[] args) {
        int row = 30, column = 30;
        Matrix dMatrix = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix, 900, 100);
        dMatrix.draw();
        System.out.println("sumElems: " + StatMatrix.sumValues(dMatrix));
        System.out.println("avgValue: " + StatMatrix.avgValue(dMatrix));
        System.out.println("maxValue: " + StatMatrix.maxValue(dMatrix));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(dMatrix));

        System.out.println("-----------------------------------------------------------------");
        Matrix sMatrix = new SparseMatrix(row, column);
        InitMatrix.fillMatrix(sMatrix, 400, 900);
        sMatrix.draw();
        System.out.println("sumElems: " + StatMatrix.sumValues(sMatrix));
        System.out.println("avgValue: " + StatMatrix.avgValue(sMatrix));
        System.out.println("maxValue: " + StatMatrix.maxValue(sMatrix));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(sMatrix));
    }
}
