package matrix;

import java.util.InputMismatchException;
import java.util.Random;

public class InitMatrix {
    public static void fillMatrix(IMatrix m, int nonzeroValues, int maxValue) {
        if (nonzeroValues > m.getColumnNumber() * m.getRowNumber())
            throw new InputMismatchException("nonzero values > values in array");
        final Random random = new Random();
        int curNonZero = 0;
        while (curNonZero < nonzeroValues) {
            int rndRow = random.nextInt(m.getRowNumber());
            int rndColumn = random.nextInt(m.getColumnNumber());
            if (m.getElem(rndRow, rndColumn) == 0) {
                m.setElem(rndRow, rndColumn, random.nextInt(maxValue) + 1);
                curNonZero++;
            }
        }
    }

    public static void fillMatrixByConstant(IMatrix m, int constant) {
        for (int i = 0; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                m.setElem(i, j, constant);
            }
        }
    }
}

