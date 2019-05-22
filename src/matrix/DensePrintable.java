package matrix;

import drawer.IDrawer;
import visitor.Visitor;

public class DensePrintable implements IPrintable {
    private IMatrix m;
    private long maxVal;

    public DensePrintable(IMatrix m) {
        this.m = m;
        maxVal = StatMatrix.maxValue(m);
    }

    @Override
    public void draw(IDrawer drawer) {
        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for (int i = 0; i < m.getRowNumber(); i++) {
            table.append(drawer.newLine());
            table.append(drawRow(drawer, i));
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }

    @Override
    public String drawRow(IDrawer drawer, int row) {
        StringBuilder rowStr = new StringBuilder();
        for (int j = 0; j < m.getColumnNumber(); j++) {
            rowStr.append(drawer.newCell());
            rowStr.append(m.getElem(row, j));
            rowStr.append(drawer.endCell());
        }
        return rowStr.toString();
    }

    @Override
    public String drawEmptyRow(IDrawer drawer, int row) {
        StringBuilder rowStr = new StringBuilder();
        for (int j = 0; j < m.getColumnNumber(); j++) {
            rowStr.append(drawer.newInvisibleCell(maxVal));
            rowStr.append(drawer.endCell());
        }
        return rowStr.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visitDensePrintable(this);
    }

    @Override
    public void setMatrix(IMatrix m) {
        this.m = m;
    }
}
