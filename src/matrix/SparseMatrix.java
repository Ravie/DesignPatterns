package matrix;

public class SparseMatrix extends Matrix{
    public SparseMatrix(int row, int column) {
        super(row, column);
        for (int i = 0; i < row; i++)
            matrix[i] = new SparseVector();
    }
}
