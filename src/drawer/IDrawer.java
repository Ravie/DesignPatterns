package drawer;

public interface IDrawer {
    void draw(String matrixLayout);
    String newTable();
    String newLine();
    String newCell();
    String newInvisibleCell(long maxValue);
    String endCell();
    String endLine();
    String endTable();
}
