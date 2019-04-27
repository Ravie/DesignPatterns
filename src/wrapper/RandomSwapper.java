package wrapper;

import drawer.IDrawer;
import matrix.IMatrix;
import matrix.IPrintable;

import java.util.*;

public class RandomSwapper implements IMatrix, IPrintable {
    private IMatrix m;
    private Map<Integer, Integer> rowsChangeLog = new HashMap<>();
    private Map<Integer, Integer> columnsChangeLog = new HashMap<>();

    public RandomSwapper(IMatrix m) {
        this.m = m;
        for (int i = 0; i < this.m.getRowNumber(); i++)
            rowsChangeLog.put(i, i);
        for (int i = 0; i < this.m.getColumnNumber(); i++)
            columnsChangeLog.put(i, i);
    }

    public void randomMatrix() {
        Random rnd = new Random();
        int row1 = rnd.nextInt(m.getRowNumber());
        int row2 = rnd.nextInt(m.getRowNumber());
        while (row2 == row1) {
            row2 = rnd.nextInt(m.getRowNumber());
        }
        int temp = rowsChangeLog.get(row1);
        rowsChangeLog.put(row1, rowsChangeLog.get(row2));
        rowsChangeLog.put(row2, temp);
        int col1 = rnd.nextInt(m.getColumnNumber());
        int col2 = rnd.nextInt(m.getColumnNumber());
        while (col2 == col1) {
            col2 = rnd.nextInt(m.getColumnNumber());
        }
        temp = columnsChangeLog.get(col1);
        columnsChangeLog.put(col1, columnsChangeLog.get(col2));
        columnsChangeLog.put(col2, temp);
    }

    public void restoreMatrix() {
        for (int i = 0; i < m.getRowNumber(); i++)
            rowsChangeLog.put(i, i);
        for (int i = 0; i < m.getColumnNumber(); i++)
            columnsChangeLog.put(i, i);
    }

    @Override
    public int getElem(int row, int column) {
        return m.getElem(rowsChangeLog.get(row), columnsChangeLog.get(column));
    }

    @Override
    public void setElem(int row, int column, int elem) {
        m.setElem(row, column, elem);
    }

    @Override
    public int getRowNumber() {
        return m.getRowNumber();
    }

    @Override
    public int getColumnNumber() {
        return m.getColumnNumber();
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