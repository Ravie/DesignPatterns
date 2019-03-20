package matrix;

import java.util.ArrayList;

public class DenseVector implements IVector {
    private ArrayList<Integer> tv;
    private int size;

    DenseVector(int size) {
        this.size = size;
        tv = new ArrayList<>(size);
        for(int i=0;i<size;i++)
            tv.add(i,0);
    }

    public int getElem(int index) {
        return tv.get(index);
    }

    public void setElem(int index, int elem) {
        tv.set(index, elem);
    }

    public int getVectorSize() {
        return size;
    }
}
