package matrix;

import drawer.IDrawer;

public abstract class Matrix implements IMatrix {
    private IVector[] matrix;
    private IDrawer drawer;
    private int row, column;

    protected Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new IVector[row];
        for (int i = 0; i < row; i++)
            matrix[i] = createVector(column);
    }

    public void setDrawer(IDrawer drawer) {
        this.drawer = drawer;
    }

    public void drawSparseMatrix() {
        drawer.drawSparseMatrix(this);
    }
    public void drawDenseMatrix() {
        drawer.drawDenseMatrix(this);
    }
    public abstract IVector createVector(int column);
    public int getElem(int row, int column) { return matrix[row].getElem(column); }
    public void setElem(int row, int column, int elem) { matrix[row].setElem(column, elem); }
    public int getRowNumber() { return row; }
    public int getColumnNumber() { return column; }
}
