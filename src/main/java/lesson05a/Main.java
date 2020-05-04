package lesson05a;

public class Main {
    static final int SIZE = 10000000;
    static final int MAX_THREAD = 8;
    static final int HALF = SIZE / MAX_THREAD;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        System.out.println("==== My Home Work 05a ====");

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        System.out.println("Start metod 1 - without Thread");
        long a = System.currentTimeMillis();
        System.out.println("start: " + a);

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0 / 2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("end: " + System.currentTimeMillis() + ", delta = " + (System.currentTimeMillis() - a));
    }
}
