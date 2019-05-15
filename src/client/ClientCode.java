package client;

import factory.*;
import matrix.*;

public class ClientCode {
    public static void main(String[] args) {
        int row = 2, column = 2;
        DrawingDenseMatrix cdm = new DrawingDenseMatrix(row,column);
        cdm.randomFilling(4,100);
        cdm.printMatrixOnHtml();

        row = 3; column = 3;
        DrawingSparseMatrix dsm = new DrawingSparseMatrix(row,column);
        dsm.randomFilling(5,100);
        dsm.printMatrixOnHtml();

        DrawingRandomSwapper cwm = new DrawingRandomSwapper(cdm);
        cwm.random();
        cwm.printMatrixOnHtml();
        cwm.restore();
        cwm.printMatrixOnHtml();

        DrawingTransposedMatrix dtm = new DrawingTransposedMatrix(cwm);
        dtm.printMatrixOnHtml();
        /*
        DrawingHorizontalGroup dhg = new DrawingHorizontalGroup();
        dhg.addMatrix(cdm);
        dhg.addMatrix(dsm);
        dhg.printMatrixOnHtml();

        HorizontalGroup container1 = new HorizontalGroup();
        int row = 2, column = 2;
        Matrix dMatrix1 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix1, 4, 1);
        container1.addMatrix(dMatrix1);
        row = 3;
        column = 3;
        Matrix dMatrix2 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix2, 9, 1);
        container1.addMatrix(dMatrix2);
        row = 5;
        column = 1;
        Matrix dMatrix3 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix3, 5, 1);
        container1.addMatrix(dMatrix3);
        row = 1;
        column = 1;
        Matrix dMatrix4 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix4, 1, 1);
        container1.addMatrix(dMatrix4);

        HorizontalGroup container2 = new HorizontalGroup();
        row = 2;
        column = 4;
        Matrix dMatrix5 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix5, 8, 1);
        container2.addMatrix(dMatrix5);
        row = 2;
        column = 3;
        Matrix dMatrix6 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix6, 6, 1);
        container2.addMatrix(dMatrix6);

        row = 1;
        column = 1;
        Matrix dMatrix7 = new DenseMatrix(row, column);
        InitMatrix.fillMatrix(dMatrix7, 1, 1);

        HorizontalGroup containerAll = new HorizontalGroup();
        containerAll.addMatrix(container1);
        containerAll.addMatrix(container2);
        containerAll.addMatrix(dMatrix7);

        containerAll.draw(new HTMLDrawer());

        TransposedMatrix tm = new TransposedMatrix(containerAll);
        tm.draw(new HTMLDrawer());

        matrixInfo(dMatrix);
        System.out.println("-----------------------------------------------------------------");
        Matrix sMatrix = new SparseMatrix(row, column);
        InitMatrix.fillMatrix(sMatrix, 4, 100);
        matrixInfo(sMatrix);
        */
    }

    private static void matrixInfo(IMatrix m) {
        /*
        IDrawer drawer = new HTMLDrawer();
        m.setDrawer(drawer);
        m.draw();

        drawer = new ConsoleDrawer();
        m.setDrawer(drawer);
        m.draw();

        RandomSwapper wrap = new RandomSwapper(m);
        wrap.randomMatrix();
        wrap.draw(new HTMLDrawer());
        wrap.restoreMatrix();
        wrap.draw(new HTMLDrawer());

        System.out.println("sumElems: " + StatMatrix.sumValues(m));
        System.out.println("avgValue: " + StatMatrix.avgValue(m));
        System.out.println("maxValue: " + StatMatrix.maxValue(m));
        System.out.println("nonZeroValues: " + StatMatrix.nonZeroValues(m));
        */
    }
}
