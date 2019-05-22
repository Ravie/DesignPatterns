package matrix;

import drawer.IDrawer;
import visitor.Visitor;

public interface IPrintable {
    void draw(IDrawer drawer);
    String drawRow(IDrawer drawer, int row);
    String drawEmptyRow(IDrawer drawer, int row);
    void accept(Visitor v);
    void setMatrix(IMatrix m);
}
