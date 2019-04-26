package drawer;

import matrix.IMatrix;

public class ConsoleDrawer extends Drawer implements IDrawer {

    @Override
    public void drawDenseMatrix(IMatrix m) {
        System.out.println(super.printDenseMatrix(m));
    }

    @Override
    public void drawSparseMatrix(IMatrix m) {
        System.out.println(super.printSparseMatrix(m));
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
