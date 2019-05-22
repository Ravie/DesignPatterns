package composite;

import matrix.IMatrix;

public interface MatrixIterator {
    boolean hasNextMatrix();
    IMatrix getNextMatrix();
    void reset();
}
