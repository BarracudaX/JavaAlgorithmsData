package chapter5;

public class Matrix<E> {

    private final MatrixLink<E> first;

    private final int row;

    private final int column;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.first = new MatrixLink<>(null, null, null);

        MatrixLink<E> current = first;

        for (int i = 0; i < row; i++) {
            current.setDown(new MatrixLink<>(null, null, null));
            for (int j = 0; j < column; j++) {
                current.setNext(new MatrixLink<>(null, null, null));
            }
            current = current.getDown();
        }

    }

    public void insert(E element, int row, int column) {
        if (row < 0 || row > this.row || column < 0 || column > this.column) {
            throw new IllegalArgumentException("Invalid indexes.Row =  " + row + ",column = " + column);
        }

        MatrixLink<E> target = first;

        for (int i = 0; i < row; i++) {
            target = target.getDown();
        }

        for (int j = 0; j < column; j++) {
            target = target.getNext();
        }

        target.setElement(element);
    }

    public void display(){
        MatrixLink<E> currentDown = first;

        for (int i = 0; i < row; i++) {

            MatrixLink<E> currentCross = currentDown;

            for (int j = 0; j < column; j++) {
                System.out.print(currentCross+",");
                currentCross = currentCross.getNext();
            }
            System.out.println("");
            currentDown = currentDown.getDown();
        }
    }

}
