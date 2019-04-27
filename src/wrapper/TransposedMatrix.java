package wrapper;

import drawer.IDrawer;
import matrix.IMatrix;
import matrix.IPrintable;

public class TransposedMatrix implements IMatrix, IPrintable {
    private IMatrix m;

    public TransposedMatrix(IMatrix m) {
        this.m = m;
    }

    @Override
    public int getElem(int row, int column) {
        return m.getElem(column, row);
    }

    @Override
    public void setElem(int row, int column, int elem) {
        m.setElem(column, row, elem);
    }

    @Override
    public int getRowNumber() {
        return m.getColumnNumber();
    }

    @Override
    public int getColumnNumber() {
        return m.getRowNumber();
    }

    @Override
    public void draw(IDrawer drawer) {
        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for (int i = 0; i < getRowNumber(); i++) {
            table.append(drawer.newLine());
            for (int j = 0; j < getColumnNumber(); j++) {
                table.append(drawer.newCell());
                table.append(getElem(i, j));
                table.append(drawer.endCell());
            }
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }
}
