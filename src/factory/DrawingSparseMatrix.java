package factory;

import drawer.*;
import matrix.*;
import visitor.ConcreteVisitor;

public class DrawingSparseMatrix implements DrawingMatrix {
    private IMatrix m;
    private IPrintable printer;

    public DrawingSparseMatrix(int row, int column) {
        m = new SparseMatrix(row, column);
        printer = new SparsePrintable(m);
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
}
