package factory;

import drawer.*;
import matrix.*;

public class DrawingDenseMatrix implements DrawingMatrix {
    private IMatrix m;
    private IPrintable printer;

    public DrawingDenseMatrix(int row, int column) {
        m = new DenseMatrix(row, column);
        printer = new DensePrintable(m);
    }

    @Override
    public IMatrix getMatrix() {
        return m;
    }

    @Override
    public IPrintable getPrinter() {
        return printer;
    }

    @Override
    public void printMatrixOnHtml() {
        printer.draw(new HTMLDrawer());
    }

    @Override
    public void printMatrixOnConsole() {
        printer.draw(new ConsoleDrawer());
    }

    public void randomFilling(int nonZeroValues, int maxValue) {
        InitMatrix.fillMatrix(m, nonZeroValues, maxValue);
    }
}
