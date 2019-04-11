package matrix;

public class StatMatrix {

    public static long sumValues(Matrix m) {
        long sum = 0;
        for (int i = 0 ; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                sum += m.getElem(i, j);
            }
        }
        return sum;
    }

    public static double avgValue(Matrix m) {
        return (double)sumValues(m) / (m.getRowNumber() * m.getColumnNumber());
    }

    public static long maxValue(Matrix m) {
        long maxValue = Long.MIN_VALUE;
        for (int i = 0 ; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if(m.getElem(i, j) > maxValue)
                    maxValue = m.getElem(i, j);
            }
        }
        return maxValue;
    }

    public static long nonZeroValues(Matrix m) {
        int numNonZeroValues = 0;
        for (int i = 0 ; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if(m.getElem(i, j) != 0)
                    numNonZeroValues++;
            }
        }
        return numNonZeroValues;
    }
}
