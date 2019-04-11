package matrix;

import java.io.*;

public class HTMLDrawer implements IDrawer {
    private StringBuilder table = new StringBuilder();

    @Override
    public void printMatrix(IMatrix m) {
        table.append(newTable());
        for (int i = 0; i < m.getRowNumber(); i++) {
            table.append(newLine());
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if (m.getElem(i, j) != 0) {
                    table.append(newCell());
                    table.append(printValue(m, i, j));
                    table.append(endCell());
                }
                else {
                    table.append(newInvisibleCell());
                    table.append(endCell());
                }
            }
            table.append(endLine());
        }
        table.append(endTable());
        try (BufferedWriter br = new BufferedWriter(new FileWriter("out.html"))) {
            br.write((table.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String newTable() {
        return "<html><body><table border=3>";
    }
    private static String endLine() {
        return "</tr>";
    }
    private static String newCell() {
        return "<th bordercolor=black>";
    }
    private static String endCell() {
        return "</th>";
    }
    private static String newInvisibleCell() {
        return "<th bordercolor=white>";
    }
    private static String newLine() {
        return "<tr>";
    }
    private static String endTable() {
        return "</table></body></html>";
    }
    private static String printValue(IMatrix m, int row, int column) {
        return String.valueOf(m.getElem(row, column));
    }
}
