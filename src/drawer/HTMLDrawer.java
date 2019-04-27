package drawer;

import java.io.*;
import java.awt.Desktop;

public class HTMLDrawer extends Drawer implements IDrawer {

    public void draw(String matrixLayout) {
        long timestamp = System.nanoTime();
        String drawBorder = "<style>table.matrix {border-color: green;visibility:hidden;}" +
                "th.visible {border-color:red;visibility:visible;}" +
                "th.invisible {visibility:hidden;}" +
                "#borders:checked ~ table.matrix {visibility: visible;}</style>" +
                "<input type=checkbox id=borders checked>Отрисовывать границы таблицы?";
        try (BufferedWriter br = new BufferedWriter(new FileWriter("Matrix_"+timestamp+".html"))) {
            br.write(drawBorder);
            br.write(matrixLayout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Desktop.getDesktop().open(new File("Matrix_"+timestamp+".html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String newTable() {
        return "<html><body><table class=matrix border=1>";
    }

    @Override
    public String endLine() {
        return "</tr>";
    }

    @Override
    public String newCell() {
        return "<th class=visible>";
    }

    @Override
    public String endCell() {
        return "</th>";
    }

    @Override
    public String newInvisibleCell(long val) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < Long.toString(val).length(); i++) {
            space.append("0");
        }
        return "<th class=invisible>" + space;
    }

    @Override
    public String newLine() {
        return "<tr>";
    }

    @Override
    public String endTable() {
        return "</table></body></html>";
    }
}
