package factory;

import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import matrix.IMatrix;
import matrix.IPrintable;
import visitor.ConcreteVisitor;
import wrapper.RandomSwapper;

public class DrawingRandomSwapper implements DrawingMatrix {
    private RandomSwapper m;
    private IPrintable printer;

    public DrawingRandomSwapper(DrawingMatrix cm) {
        this.m = new RandomSwapper(cm.getMatrix());
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
        printer.accept(new ConcreteVisitor(new HTMLDrawer()));
    }

    @Override
    public void printMatrixOnConsole() {
        printer.accept(new ConcreteVisitor(new ConsoleDrawer()));
    }

    public void random() {
        m.randomMatrix();
    }

    public void restore() {
        m.restoreMatrix();
    }
}
