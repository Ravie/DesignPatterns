package matrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class SparseVector implements IVector {
    private LinkedList<Integer> sv;
    private ArrayList<Integer> columnNum;

    SparseVector() {
        sv = new LinkedList<>();
        columnNum = new ArrayList<>();
    }

    public int getElem(int index) {
        if (columnNum.contains(index))
            return sv.get(columnNum.indexOf(index));
        else
            return 0;
    }

    public void setElem(int index, int elem) {
        if (!columnNum.contains(index)) {
            sv.add(elem);
            columnNum.add(index);
        } else {
            sv.set(index, elem);
        }
    }

    public int getVectorSize() {
        return columnNum.size();
    }
}
