package matrix;

public class DenseMatrix extends Matrix {
    public DenseMatrix(int row, int column) {
        super(row, column);
        for (int i = 0; i < row; i++)
            matrix[i] = new DenseVector(column);
    }
}
