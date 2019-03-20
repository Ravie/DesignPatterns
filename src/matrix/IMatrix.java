package matrix;

public interface IMatrix {
    int getElem(int row, int column);
    void setElem(int row, int column, int elem);
    int getRowNumber();
    int getColumnNumber();
}
