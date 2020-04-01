package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    Matrix<Integer> sut = new Matrix<>(2, 2);

    @Test
    public void shouldInsertElements() {
        sut.insert(0, 0, 0);
        sut.insert(1, 0, 1);
        sut.insert(2, 1, 0);
        sut.insert(3, 1, 1);

        sut.display();
    }

    @Test
    public void shouldThrowIAEWhenIndexsAreIncorrect(){
        assertThrows(IllegalArgumentException.class, () -> sut.insert(1,-1, 0));
        assertThrows(IllegalArgumentException.class, () -> sut.insert(1,0, -1));
        assertThrows(IllegalArgumentException.class, () -> sut.insert(1,3, 0));
        assertThrows(IllegalArgumentException.class, () -> sut.insert(1,0, 3));
    }

}