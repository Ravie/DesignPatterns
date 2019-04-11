package matrix;

public class ConsoleDrawer implements IDrawer {

    @Override
    public void printMatrix(IMatrix m) {
        newTable();
        for (int i = 0; i < m.getRowNumber(); i++) {
            newLine();
            for (int j = 0; j < m.getColumnNumber(); j++) {
                newCell();
                if(m.getElem(i,j) != 0)
                    printValue(m, i, j);
                else
                    newCell();
            }
        }
    }

    private static void newTable() {
        System.out.println();
    }
    private static void newCell() {
        System.out.print("\t");
    }

    private static void newLine() {
        System.out.println();
    }

    private static void printValue(IMatrix m, int row, int column) {
        System.out.print(m.getElem(row, column));
    }
}
