package composite;

import drawer.IDrawer;
import matrix.IMatrix;
import matrix.IPrintable;

import java.util.ArrayList;
import java.util.List;

public class HorizontalGroup implements IMatrix, IPrintable {

    private List<IMatrix> listOfMatrix = new ArrayList<>();

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

    public void addMatrix(IMatrix matrix) {
        listOfMatrix.add(matrix);
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
    public void draw(IDrawer drawer) {
        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for (int i = 0; i < getRowNumber(); i++) {
            table.append(drawer.newLine());
            for (int j = 0; j < getColumnNumber(); j++) {
                table.append(drawer.newCell());
                table.append(getElem(i, j));
                table.append(drawer.endCell());
            }
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }
}
