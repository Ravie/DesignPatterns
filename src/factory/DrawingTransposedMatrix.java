package factory;

import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import matrix.IMatrix;
import matrix.IPrintable;
import wrapper.TransposedMatrix;

public class DrawingTransposedMatrix implements DrawingMatrix {
    private TransposedMatrix m;
    private IPrintable printer;

    public DrawingTransposedMatrix(DrawingMatrix cm) {
        this.m = new TransposedMatrix(cm.getMatrix());
        this.printer = cm.getPrinter();
        printer.setMatrix(m);
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
}
