package chapter7;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{10, 22, 3, 20, 33, 1, 5, 4, -5, 302, 152, 205};
        System.out.print("Before sort:");
        for (Integer anInt : ints) {
            System.out.print(anInt + ",");
        }
        System.out.println("\n");

        sort(ints);

    }

    public static <T extends Comparable<T>> void sort(T[] elements) {

        int h = 1;

        while (h < elements.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int outer = h; outer < elements.length; outer++) {
                T temp = elements[outer];

                int inner = outer;

                while (inner >= h && elements[inner - h].compareTo(temp) > 0) {
                    elements[inner] = elements[inner - h];
                    inner = inner - h;
                }
                elements[inner] = temp;
            }
            System.out.print("\nElements:");
            for (T el : elements) {
                System.out.print(el + ",");
            }
            System.out.println("\n");
            h = (h - 1) / 3;
        }

    }

}
