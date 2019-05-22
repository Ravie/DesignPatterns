package visitor;

import drawer.IDrawer;
import matrix.*;

public class ConcreteVisitor implements Visitor {
    private IDrawer drawer;

    public ConcreteVisitor(IDrawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public void draw(IPrintable pr) {
        pr.accept(this);
    }

    @Override
    public void visitDensePrintable(DensePrintable dm) {
        dm.draw(drawer);
    }

    @Override
    public void visitSparsePrintable(SparsePrintable sm) {
        sm.draw(drawer);
    }

    @Override
    public void visitGroupPrintable(GroupPrintable gm) {
        gm.draw(drawer);
    }
}
