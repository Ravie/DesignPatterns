package composite;

import matrix.IMatrix;
import java.util.LinkedList;
import java.util.List;

public class HorizontalGroup implements IGroupMatrix {

    private List<IMatrix> listOfMatrix = new LinkedList<>();

    @Override
    public int getElem(int row, int column) {
        int startOfMatrix = 0;
        for (IMatrix matrix : listOfMatrix) {
            if (column >= startOfMatrix && column < startOfMatrix + matrix.getColumnNumber() && row < matrix.getRowNumber()) {
                return matrix.getElem(row, column - startOfMatrix);
            } else {
                startOfMatrix += matrix.getColumnNumber();
            }
        }
        return 0;
    }

    @Override
    public void setElem(int row, int column, int elem) {
        int startOfMatrix = 0;
        boolean isAdded = false;
        for (IMatrix matrix : listOfMatrix) {
            if (column >= startOfMatrix && column < startOfMatrix + matrix.getColumnNumber() && row < matrix.getRowNumber()) {
                matrix.setElem(row, column - startOfMatrix, elem);
                isAdded = true;
            } else {
                startOfMatrix += matrix.getColumnNumber();
            }
        }
        if (!isAdded)
            throw new ArrayIndexOutOfBoundsException("Element has not been added");
    }

    @Override
    public int getRowNumber() {
        int maxRowNumber = Integer.MIN_VALUE;
        for (IMatrix matrix : listOfMatrix) {
            if (matrix.getRowNumber() > maxRowNumber)
                maxRowNumber = matrix.getRowNumber();
        }
        return maxRowNumber;
    }

    @Override
    public int getColumnNumber() {
        int sumColumnNumber = 0;
        for (IMatrix matrix : listOfMatrix) {
            sumColumnNumber += matrix.getColumnNumber();
        }
        return sumColumnNumber;
    }

    @Override
    public void addMatrix(IMatrix matrix) {
        listOfMatrix.add(matrix);
    }

    @Override
    public void addMatrix(IGroupMatrix matrix) {
        listOfMatrix.add(matrix);
    }

    @Override
    public MatrixIterator iterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements MatrixIterator {
        private int iterator = 0;

        ListItr(int index) {
            if(index < listOfMatrix.size())
                iterator = index;
        }

        @Override
        public IMatrix getNextMatrix() {
            IMatrix m = listOfMatrix.get(iterator);
            iterator++;
            return m;
        }

        @Override
        public void reset() {
            iterator = 0;
        }

        @Override
        public boolean hasNextMatrix() {
            return iterator < listOfMatrix.size();
        }
    }
}
