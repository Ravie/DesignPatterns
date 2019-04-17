package matrix;

import java.util.Scanner;

public abstract class Matrix implements IMatrix {
    private IVector[] matrix;
    private IDrawer drawer;
    private int row, column;

    protected Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new IVector[row];
        for (int i = 0; i < row; i++)
            matrix[i] = createVector(column);
    }

    public void draw() {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите способ отрисовки: (Console - 1; HTML - 2)");
        int index = in.nextInt();
        switch(index) {
            case 1:
                this.drawer = new ConsoleDrawer(this);
                break;
            case 2:
                this.drawer = new HTMLDrawer(this);
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }
    public abstract IVector createVector(int column);
    public int getElem(int row, int column) { return matrix[row].getElem(column); }
    public void setElem(int row, int column, int elem) { matrix[row].setElem(column, elem); }
    public int getRowNumber() { return row; }
    public int getColumnNumber() { return column; }
}
