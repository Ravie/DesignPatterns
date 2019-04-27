package matrix;

import drawer.IDrawer;

public class SparseMatrix extends Matrix{
    public SparseMatrix(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw(IDrawer drawer) {
        long maxVal = StatMatrix.maxValue(this);

        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for (int i = 0; i < getRowNumber(); i++) {
            table.append(drawer.newLine());
            for (int j = 0; j < getColumnNumber(); j++) {
                if (getElem(i, j) != 0) {
                    table.append(drawer.newCell());
                    table.append(getElem(i, j));
                    table.append(drawer.endCell());
                } else {
                    table.append(drawer.newInvisibleCell(maxVal));
                    table.append(drawer.endCell());
                }
            }
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }

    @Override
    public IVector createVector(int column) { return new SparseVector(); }
}
