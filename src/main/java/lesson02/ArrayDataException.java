package lesson02;

public class ArrayDataException extends Exception {
    public ArrayDataException() {
        System.out.println("---------------------------");
        System.out.printf("Error: %s in cell[%d,%d]\n");
    }

    public ArrayDataException(String nformat, int x, int y) {
        System.out.println("---------------------------");
        System.out.printf("Error: %s in cell[%d,%d]\n", nformat, ++x, ++y);
    }
}
