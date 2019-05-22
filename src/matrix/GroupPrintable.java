package matrix;

import composite.IGroupMatrix;
import composite.MatrixIterator;
import drawer.IDrawer;
import visitor.Visitor;

import java.util.List;

public class GroupPrintable implements IPrintable {
    private IMatrix m;
    private IPrintable currentPrinter;
    private List<IPrintable> printerList;

    public GroupPrintable(IMatrix m, List<IPrintable> printerList) {
        this.m = m;
        this.printerList = printerList;
    }

    @Override
    public void draw(IDrawer drawer) {
        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for(int row = 0; row < m.getRowNumber(); row++) {
            table.append(drawer.newLine());
            table.append(drawRow(drawer, row));
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }

    @Override
    public String drawRow(IDrawer drawer, int row) {
        StringBuilder rowStr = new StringBuilder();
        int index = 0;
        MatrixIterator iterator = ((IGroupMatrix)m).iterator(0);
        while (iterator.hasNextMatrix()) {
            IMatrix current = iterator.getNextMatrix();
            currentPrinter = printerList.get(index);
            index++;
            currentPrinter.setMatrix(current);
            if(row < current.getRowNumber())
                rowStr.append(currentPrinter.drawRow(drawer, row));
            else
                rowStr.append(currentPrinter.drawEmptyRow(drawer, row));
        }
        return rowStr.toString();
    }

    @Override
    public String drawEmptyRow(IDrawer drawer, int row) {
        return currentPrinter.drawEmptyRow(drawer, row);
    }

    @Override
    public void accept(Visitor v) {
        v.visitGroupPrintable(this);
    }

    @Override
    public void setMatrix(IMatrix m) {
        this.m = m;
    }
}
