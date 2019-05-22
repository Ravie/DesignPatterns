package factory;

import composite.IGroupMatrix;
import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import matrix.IPrintable;
import visitor.ConcreteVisitor;
import wrapper.TransposedMatrix;

public class DrawingTransposedMatrix implements DrawingGroupMatrix {
    private IGroupMatrix m;
    private IPrintable printer;

    public DrawingTransposedMatrix(DrawingGroupMatrix cm) {
        this.m = new TransposedMatrix(cm.getMatrix());
        this.printer = cm.getPrinter();
        printer.setMatrix(m);
    }

    public DrawingTransposedMatrix(DrawingMatrix cm) {
        this.m = new TransposedMatrix(cm.getMatrix());
        this.printer = cm.getPrinter();
        printer.setMatrix(m);
    }

    @Override
    public IGroupMatrix getMatrix() {
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
}
