package composite;

import matrix.IMatrix;

public interface IGroupMatrix extends IMatrix {
    MatrixIterator iterator(int index);
    void addMatrix(IMatrix matrix);
    void addMatrix(IGroupMatrix matrix);
}
