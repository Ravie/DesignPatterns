package drawer;

public abstract class Drawer implements IDrawer {

    abstract public void draw(String matrixLayout);

    abstract public String newTable();

    abstract public String newLine();

    abstract public String newCell();

    abstract public String newInvisibleCell(long maxValue);

    abstract public String endCell();

    abstract public String endLine();

    abstract public String endTable();
}
