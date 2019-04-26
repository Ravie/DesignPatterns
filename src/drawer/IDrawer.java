package drawer;

import matrix.IMatrix;

public interface IDrawer {
    void drawDenseMatrix(IMatrix m);
    void drawSparseMatrix(IMatrix m);
}
