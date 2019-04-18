package client;

import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import drawer.IDrawer;
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
        IDrawer drawer = new HTMLDrawer();
        m.setDrawer(drawer);
        m.draw();
        drawer = new ConsoleDrawer();
        m.setDrawer(drawer);
        m.draw();
        System.out.println("sumElems: " + StatMatrix.sumValues(m));
        System.out.println("avgValue: " + StatMatrix.avgValue(m));
        System.out.println("maxValue: " + StatMatrix.maxValue(m));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(m));
    }
}
