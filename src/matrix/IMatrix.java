package matrix;

import drawer.IDrawer;

public interface IMatrix {
    int getElem(int row, int column);
    void setElem(int row, int column, int elem);
    int getRowNumber();
    int getColumnNumber();
    void drawSparseMatrix();
    void drawDenseMatrix();
    void setDrawer(IDrawer drawer);
}
