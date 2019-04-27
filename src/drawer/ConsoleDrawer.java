package drawer;

public class ConsoleDrawer implements IDrawer {

    @Override
    public void draw(String matrixLayout) {
        System.out.println(matrixLayout);
    }

    @Override
    public String newTable() {
        return "";
    }

    @Override
    public String endTable() {
        return "\r\n";
    }

    @Override
    public String newCell() {
        return "";
    }

    @Override
    public String newInvisibleCell(long val) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < Long.toString(val).length(); i++) {
            space.append("-");
        }
        return space.toString();
    }

    @Override
    public String endCell() {
        return "\t";
    }

    @Override
    public String newLine() {
        return "\r\n";
    }
    
    @Override
    public String endLine() {
        return "";
    }
}
