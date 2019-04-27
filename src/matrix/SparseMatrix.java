package matrix;

public class SparseMatrix extends Matrix{
    public SparseMatrix(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw() {
        drawer.drawSparseMatrix(this);
    }

    @Override
    public IVector createVector(int column) { return new SparseVector(); }
}
