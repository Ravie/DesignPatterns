package factory;

import matrix.IMatrix;
import matrix.IPrintable;

public interface DrawingMatrix {
    IMatrix getMatrix();
    IPrintable getPrinter();
    void printMatrixOnHtml();
    void printMatrixOnConsole();
}
