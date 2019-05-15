package matrix;

import drawer.IDrawer;
import visitor.Visitor;

public class DensePrintable implements IPrintable {
    private IMatrix m;

    public DensePrintable(IMatrix m) {
        this.m = m;
    }

    @Override
    public void draw(IDrawer drawer) {
        draw(drawer, 0);
    }

    @Override
    public void draw(IDrawer drawer, int offset) {
        StringBuilder table = new StringBuilder();
        table.append(drawer.newTable());
        for (int i = 0; i < m.getRowNumber(); i++) {
            table.append(drawer.newLine());
            for (int j = offset; j < m.getColumnNumber() + offset; j++) {
                table.append(drawer.newCell());
                table.append(m.getElem(i, j));
                table.append(drawer.endCell());
            }
            table.append(drawer.endLine());
        }
        table.append(drawer.endTable());
        drawer.draw(table.toString());
    }

    @Override
    public void accept(Visitor v) {
        v.visitDensePrintable(this);
    }

    @Override
    public void setMatrix(IMatrix m) {
        this.m = m;
    }
}
