package matrix;

public class SparseMatrix extends Matrix {
    public SparseMatrix(int row, int column) {
        super(row, column);
    }

    @Override
    public IVector createVector(int column) {
        return new SparseVector();
    }
}
