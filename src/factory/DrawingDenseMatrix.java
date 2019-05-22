package factory;

import drawer.*;
import matrix.*;
import visitor.ConcreteVisitor;

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
        printer.accept(new ConcreteVisitor(new HTMLDrawer()));
    }

    @Override
    public void printMatrixOnConsole() {
        printer.accept(new ConcreteVisitor(new ConsoleDrawer()));
    }

    public void randomFilling(int nonZeroValues, int maxValue) {
        InitMatrix.fillMatrix(m, nonZeroValues, maxValue);
    }

    public void constantFilling(int constant) {
        InitMatrix.fillMatrixByConstant(m, constant);
    }
}
