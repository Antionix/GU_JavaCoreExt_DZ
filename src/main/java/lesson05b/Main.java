package lesson05b;

public class Main {

    static final int SIZE = 10000000;
    static final int MAX_THREAD = 2;
    static final int HALF = SIZE / MAX_THREAD;
    static float[] arr = new float[SIZE];
    static long[] timeStart = new long[MAX_THREAD + 1];
    static long[] timeFinish = new long[MAX_THREAD + 1];

    public static void calc(int d) {
        timeStart[d] = System.currentTimeMillis();
        System.out.printf("-- Calculate start --- %d (%d)\n", d, timeStart[d]);
        if (d == MAX_THREAD) {
            for (int i = HALF * (d - 1); i < SIZE; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0 / 2f + i / 5) * Math.cos(0.4f + i / 2));
                if (i % 1000000 == 0) {
                    System.out.printf("(%d) By step %d\n", d, i / 1000000);
                }
            }
        } else {
            for (int i = HALF * (d - 1); i < HALF * d; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0 / 2f + i / 5) * Math.cos(0.4f + i / 2));
                if (i % 1000000 == 0) {
                    System.out.printf("(%d) By step %d \n", d, i / 1000000);
                }
            }
        }
        timeFinish[d] = System.currentTimeMillis();
        System.out.printf("-- Calculate finish --- %d (%d) (delta = %d)\n", d, timeFinish[d], timeFinish[d] - timeStart[d]);
    }

    public static void main(String[] args) {
        System.out.println("==== My Home Work 05b ====");

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < MAX_THREAD + 1; i++) {
            timeFinish[i] = 0;
            timeStart[i] = 0;
        }

        timeStart[0] = System.currentTimeMillis();
        System.out.printf("Start metod 2 - with Thread (%d) \n", timeStart[0]);

        for (int tr = 1; tr <= MAX_THREAD; tr++) {
            int finalTr = tr;
            new Thread(() -> {
                calc(finalTr);
            }).start();
        }

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

        timeFinish[0] = System.currentTimeMillis();

        for (int i = 0; i < MAX_THREAD + 1; i++) {
            System.out.printf("{%d} : %d : %d : %d \n", i, timeStart[i], timeFinish[i], timeFinish[i] - timeStart[i]);
        }

        System.out.printf("Finish metod 2 - with Thread (%d) (delta = %d) \n", timeFinish[0], timeFinish[0] - timeStart[0]);
    }
}

