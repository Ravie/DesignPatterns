package matrix;

public abstract class Matrix implements IMatrix {
    protected IVector[] matrix;
    private int row, column;

    protected Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new IVector[row];
    }

    public int getElem(int row, int column) { return matrix[row].getElem(column); }
    public void setElem(int row, int column, int elem) { matrix[row].setElem(column, elem); }
    public int getRowNumber() { return row; }
    public int getColumnNumber() { return column; }
}
