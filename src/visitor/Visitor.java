package visitor;

import matrix.*;

public interface Visitor {
    void draw(IPrintable pr);
    void visitDensePrintable(DensePrintable dm);
    void visitSparsePrintable(SparsePrintable sm);
}
