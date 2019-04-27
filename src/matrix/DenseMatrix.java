package matrix;

import drawer.IDrawer;

public class DenseMatrix extends Matrix {
    public DenseMatrix(int row, int column) {
        super(row, column);
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

    @Override
    public IVector createVector(int column) {
        return new DenseVector(column);
    }
}
