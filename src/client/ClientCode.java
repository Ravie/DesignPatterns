package client;

import factory.*;

public class ClientCode {
    public static void main(String[] args) {
        Task_4();
    }

    private static void Task_4() {
        DrawingHorizontalGroup container1 = new DrawingHorizontalGroup();
        DrawingDenseMatrix dMatrix1 = new DrawingDenseMatrix(2,2);
        dMatrix1.constantFilling(0);
        container1.addMatrix(dMatrix1);
        DrawingSparseMatrix dMatrix2 = new DrawingSparseMatrix(4,3);
        dMatrix2.randomFilling(8, 100);
        container1.addMatrix(dMatrix2);
        DrawingDenseMatrix dMatrix3 = new DrawingDenseMatrix(1,3);
        dMatrix3.constantFilling(3);
        container1.addMatrix(dMatrix3);
        container1.printMatrixOnHtml();

        DrawingHorizontalGroup container2 = new DrawingHorizontalGroup();
        DrawingSparseMatrix dMatrix4 = new DrawingSparseMatrix(2,4);
        dMatrix4.randomFilling(5,100);
        container2.addMatrix(dMatrix4);
        DrawingDenseMatrix dMatrix5 = new DrawingDenseMatrix(2,3);
        dMatrix5.constantFilling(5);
        container2.addMatrix(dMatrix5);
        container2.printMatrixOnHtml();

        DrawingDenseMatrix dMatrix6 = new DrawingDenseMatrix(1,1);
        dMatrix6.constantFilling(6);
        dMatrix6.printMatrixOnHtml();

        DrawingHorizontalGroup containerAll = new DrawingHorizontalGroup();
        containerAll.addMatrix(container1);
        containerAll.addMatrix(container2);
        containerAll.addMatrix(dMatrix6);

        containerAll.printMatrixOnHtml();
    }

}
