package matrix;

public abstract class Drawer {
    public String printMatrix(IMatrix m) {
        long maxVal = StatMatrix.maxValue(m);

        StringBuilder table = new StringBuilder();
        table.append(newTable());
        for (int i = 0; i < m.getRowNumber(); i++) {
            table.append(newLine());
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if (m.getElem(i, j) != 0) {
                    table.append(newCell());
                    table.append(printValue(m, i, j));
                    table.append(endCell());
                } else {
                    table.append(newInvisibleCell(maxVal));
                    table.append(endCell());
                }
            }
            table.append(endLine());
        }
        table.append(endTable());
        return table.toString();
    }

    abstract protected String newTable();

    abstract protected String newLine();

    abstract protected String newCell();

    abstract protected String newInvisibleCell(long maxValue);

    protected String printValue(IMatrix m, int row, int column) {
        return Integer.toString(m.getElem(row, column));
    }

    abstract protected String endCell();

    abstract protected String endLine();

    abstract protected String endTable();
}
