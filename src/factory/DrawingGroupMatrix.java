package factory;

import composite.IGroupMatrix;
import matrix.IPrintable;

public interface DrawingGroupMatrix {
    IGroupMatrix getMatrix();
    IPrintable getPrinter();
    void printMatrixOnHtml();
    void printMatrixOnConsole();
}
