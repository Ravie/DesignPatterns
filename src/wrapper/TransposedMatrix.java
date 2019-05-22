package wrapper;

import composite.IGroupMatrix;
import composite.MatrixIterator;
import matrix.IMatrix;

import java.util.LinkedList;
import java.util.List;

public class TransposedMatrix implements IGroupMatrix {
    private List<IMatrix> listOfMatrix = new LinkedList<>();
    private IMatrix m;

    public TransposedMatrix(IGroupMatrix m) {
        this.m = m;
        int index = 0;
        MatrixIterator iterator = m.iterator(index);
        while (iterator.hasNextMatrix()) {
            listOfMatrix.add(iterator.getNextMatrix());
            index++;
        }
    }

    public TransposedMatrix(IMatrix m) {
        this.m = m;
        listOfMatrix.add(m);
    }

    @Override
    public int getElem(int row, int column) {
        return m.getElem(column, row);
    }

    @Override
    public void setElem(int row, int column, int elem) {
        m.setElem(column, row, elem);
    }

    @Override
    public int getRowNumber() {
        return m.getColumnNumber();
    }

    @Override
    public int getColumnNumber() {
        return m.getRowNumber();
    }

    @Override
    public MatrixIterator iterator(int index) {
        return new ListItr(index);
    }

    @Override
    public void addMatrix(IMatrix matrix) {
        listOfMatrix.add(matrix);
    }

    @Override
    public void addMatrix(IGroupMatrix matrix) {
        listOfMatrix.add(matrix);
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
