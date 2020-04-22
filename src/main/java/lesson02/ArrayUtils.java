package lesson02;

import java.util.Random;

public class ArrayUtils {

    public long arraySum(Object[][] array)  {
        long sum = 0;
        if (array.length != 4 || array[0].length != 4) {
            try {
                throw new ArraySizeException();
            } catch (ArraySizeException as) {
                as.ArraySizeException();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                long x = 0;
                try {
                    x = Long.parseLong(String.valueOf(array[i][j]));
                } catch (Exception nf) {
                    new ArrayDataException(nf.getMessage(), i, j);
//                    new ArrayDataException();
                }
                sum += x;
            }
        }
        return sum;
    }

    public Object[][] initArray(int n) {
        Random rnd = new Random();
        Object[][] myArray = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                myArray[i][j] = String.valueOf(rnd.nextInt(10));
            }
        }
        return myArray;
    }

    public void printArray(Object[][] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray.length; j++) {
                System.out.printf("[%2s]", strArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

