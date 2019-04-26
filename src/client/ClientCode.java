package client;

import drawer.*;
import matrix.*;
import wrapper.*;

public class ClientCode {
    public static void main(String[] args) {
        int row = 100, column = 100;
        Matrix dMatrix = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix, 25, 100);
        matrixInfo(dMatrix);
        System.out.println("-----------------------------------------------------------------");
        Matrix sMatrix = new SparseMatrix(row, column);
        InitMatrix.fillMatrix(sMatrix, 4, 100);
        matrixInfo(sMatrix);
    }

    private static void matrixInfo(IMatrix m) {
        IDrawer drawer = new HTMLDrawer();
        m.setDrawer(drawer);
        m.draw();
        /*
        drawer = new ConsoleDrawer();
        m.setDrawer(drawer);
        m.draw();
        MatrixWrapper wrap = new MatrixWrapper(m);
        wrap.setDrawer(drawer);
        wrap.randomMatrix();
        wrap.draw();
        wrap.restoreMatrix();
        wrap.draw();
        System.out.println("sumElems: " + StatMatrix.sumValues(m));
        System.out.println("avgValue: " + StatMatrix.avgValue(m));
        System.out.println("maxValue: " + StatMatrix.maxValue(m));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(m));
        */
    }
}
