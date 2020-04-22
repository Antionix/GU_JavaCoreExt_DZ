package lesson02;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== Home Work 02 =====");
        ArrayUtils utils = new ArrayUtils();

        System.out.println("============ v1 ============");
        Object[][] myArray = utils.initArray(4);
        utils.printArray(myArray);
        System.out.println(utils.arraySum(myArray));

        System.out.println("============ v2 ============");
        myArray = utils.initArray(5);
        utils.printArray(myArray);
        System.out.println(utils.arraySum(myArray));

        System.out.println("============ v3 ============");
         myArray = utils.initArray(4);
        myArray[2][3] = "String";
        myArray[1][2] = "Str";
        myArray[3][0] = 10;
        utils.printArray(myArray);
        System.out.println(utils.arraySum(myArray));
    }
}
