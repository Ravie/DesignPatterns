package matrix;

import drawer.IDrawer;

public class DenseMatrix extends Matrix {
    public DenseMatrix(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw(IDrawer drawer) {
        drawer.draw(this, "Dense");
    }

    @Override
    public IVector createVector(int column) { return new DenseVector(column); }
}
