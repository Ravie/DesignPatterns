package factory;

import composite.HorizontalGroup;
import drawer.ConsoleDrawer;
import drawer.HTMLDrawer;
import matrix.IMatrix;
import matrix.IPrintable;

import java.util.LinkedList;
import java.util.List;

public class DrawingHorizontalGroup implements DrawingMatrix {
    private HorizontalGroup m;
    private List<IPrintable> printerList;
    private IPrintable currentPrinter;

    public DrawingHorizontalGroup() {
        m = new HorizontalGroup();
        printerList = new LinkedList<>();
    }

    @Override
    public IMatrix getMatrix() {
        return m;
    }

    @Override
    public IPrintable getPrinter() {
        return currentPrinter;
    }

    @Override
    public void printMatrixOnHtml() {
        int index = 0;
        while(m.hasNextMatrix()) {
            IMatrix current = m.getNextMatrix();
            currentPrinter = printerList.get(index);
            index++;
            currentPrinter.setMatrix(current);
            currentPrinter.draw(new HTMLDrawer(), m.getOffsetForMatrix(current));
        }
    }

    @Override
    public void printMatrixOnConsole() {
        int index = 0;
        while(m.hasNextMatrix()) {
            IMatrix current = m.getNextMatrix();
            currentPrinter = printerList.get(index);
            index++;
            currentPrinter.setMatrix(current);
            currentPrinter.draw(new ConsoleDrawer(), m.getOffsetForMatrix(current));
        }
    }

    public void addMatrix(DrawingMatrix matrix) {
        m.addMatrix(matrix.getMatrix());
        printerList.add(matrix.getPrinter());
    }
}
