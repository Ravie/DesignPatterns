package wrapper;

import matrix.IMatrix;

public class TransposedMatrix implements IMatrix {
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

}
