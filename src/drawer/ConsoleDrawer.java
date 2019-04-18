package drawer;

import matrix.IMatrix;

public class ConsoleDrawer extends Drawer implements IDrawer {

    public void draw(IMatrix m) {
        System.out.println(printMatrix(m));
    }

    @Override
    protected String newTable() {
        return "";
    }
    @Override
    protected String endTable() {
        return "\r\n";
    }
    @Override
    protected String newCell() {
        return "";
    }
    @Override
    protected String newInvisibleCell(long val) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < Long.toString(val).length(); i++) {
            space.append("-");
        }
        return space.toString();
    }
    @Override
    protected String endCell() {
        return "\t";
    }
    @Override
    protected String newLine() {
        return "\r\n";
    }
    @Override
    protected String endLine() {
        return "";
    }
}
