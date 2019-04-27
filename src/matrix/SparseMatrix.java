package matrix;

import drawer.IDrawer;

public class SparseMatrix extends Matrix{
    public SparseMatrix(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw(IDrawer drawer) {
        drawer.draw(this, "Sparse");
    }

    @Override
    public IVector createVector(int column) { return new SparseVector(); }
}
