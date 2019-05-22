package factory;

import composite.HorizontalGroup;
import composite.IGroupMatrix;
import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import matrix.GroupPrintable;
import matrix.IPrintable;
import visitor.ConcreteVisitor;

import java.util.LinkedList;
import java.util.List;

public class DrawingHorizontalGroup implements DrawingGroupMatrix {
    private HorizontalGroup m;
    private List<IPrintable> printerList;
    private GroupPrintable printer;

    public DrawingHorizontalGroup() {
        m = new HorizontalGroup();
        printerList = new LinkedList<>();
    }

    @Override
    public IGroupMatrix getMatrix() {
        return m;
    }

    @Override
    public GroupPrintable getPrinter() {
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

    public void addMatrix(DrawingGroupMatrix matrix) {
        m.addMatrix(matrix.getMatrix());
        printerList.add(matrix.getPrinter());
        printer = new GroupPrintable(m, printerList);
    }

    public void addMatrix(DrawingMatrix matrix) {
        m.addMatrix(matrix.getMatrix());
        printerList.add(matrix.getPrinter());
        printer = new GroupPrintable(m, printerList);
    }
}
