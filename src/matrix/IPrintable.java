package matrix;

import drawer.IDrawer;
import visitor.Visitor;

public interface IPrintable {
    void draw(IDrawer drawer);
    void draw(IDrawer drawer, int offset);
    void accept(Visitor v);
    void setMatrix(IMatrix m);
}
