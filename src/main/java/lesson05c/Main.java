package lesson05c;

public class Main {
    static final int SIZE = 10000000;
    static final int MAX_THREAD = 2;
    static final int HALF = SIZE / MAX_THREAD;
    static long[] timeStart = new long[MAX_THREAD + 1];
    static long[] timeFinish = new long[MAX_THREAD + 1];

    public static void calc(float[] curArray, int d) {
        timeStart[d] = System.currentTimeMillis();
        System.out.printf("-- Calculate start --- %d (%d)\n", d, timeStart[d]);

        for (int i = 0; i < curArray.length; i++) {
            curArray[i] = (float) (curArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0 / 2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        timeFinish[d] = System.currentTimeMillis();
        System.out.printf("-- Calculate finish --- %d (%d) (delta = %d)\n", d, timeFinish[d], timeFinish[d] - timeStart[d]);
    }

    public static void main(String[] args) {
        System.out.println("==== My Home Work 05c ====");
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < MAX_THREAD + 1; i++) {
            timeFinish[i] = 0;
            timeStart[i] = 0;
        }

        timeStart[0] = System.currentTimeMillis();

        System.out.printf("Start metod 3 - with Thread (%d) \n", timeStart[0]);

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr1, 0, HALF);

        new Thread(() -> calc(arr1, 1)).start();
        new Thread(() -> calc(arr2, 2)).start();

        boolean finish = false;

        while (!finish) {
            int z = 0;
            for (int i = 1; i <= MAX_THREAD; i++) {
                if (timeFinish[i] != 0) {
                    z++;
                }
            }
            finish = z == MAX_THREAD;
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        timeFinish[0] = System.currentTimeMillis();

        for (int i = 0; i < MAX_THREAD + 1; i++) {
            System.out.printf("{%d} : %d : %d : %d \n", i, timeStart[i], timeFinish[i], timeFinish[i] - timeStart[i]);
        }

        System.out.printf("Finish metod 3 - with Thread (%d) (delta = %d) \n", timeFinish[0], timeFinish[0] - timeStart[0]);
    }
}
