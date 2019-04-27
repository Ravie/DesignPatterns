package drawer;

import matrix.IMatrix;

import java.io.*;
import java.awt.Desktop;

public class HTMLDrawer extends Drawer implements IDrawer {

    public void draw(IMatrix m, String MatrixType) {
        long timestamp = System.nanoTime();
        String drawBorder = "<style>table.matrix {border-color: green;visibility:hidden;}" +
                "th.visible {border-color:red;visibility:visible;}" +
                "th.invisible {visibility:hidden;}" +
                "#borders:checked ~ table.matrix {visibility: visible;}</style>" +
                "<input type=checkbox id=borders checked>Отрисовывать границы таблицы?";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(MatrixType+"_"+timestamp+".html"))) {
            br.write(drawBorder);
            if(MatrixType.equals("matrix.DenseMatrix"))
                br.write(super.drawDenseMatrix(m));
            else if(MatrixType.equals("matrix.SparseMatrix"))
                br.write(super.drawSparseMatrix(m));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Desktop.getDesktop().open(new File(MatrixType+"_"+timestamp+".html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String newTable() {
        return "<html><body><table class=matrix border=1>";
    }

    @Override
    protected String endLine() {
        return "</tr>";
    }

    @Override
    protected String newCell() {
        return "<th class=visible>";
    }

    @Override
    protected String endCell() {
        return "</th>";
    }

    @Override
    protected String newInvisibleCell(long val) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < Long.toString(val).length(); i++) {
            space.append("0");
        }
        return "<th class=invisible>" + space;
    }

    @Override
    protected String newLine() {
        return "<tr>";
    }

    @Override
    protected String endTable() {
        return "</table></body></html>";
    }
}
