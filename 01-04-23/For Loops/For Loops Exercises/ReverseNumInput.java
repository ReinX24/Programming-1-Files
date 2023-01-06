import java.util.Scanner;

public class ReverseNumInput {

    public static void main(String[] args) {

        /*
         * Write a program that prompts the user to input an integer and then outputs
         * the number with the digits reversed. For example, if the input is 12345, the
         * output should be 54321.
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Reverse Number Order Program]");
        System.out.print("Input numbers: ");
        int userNum = scanOne.nextInt();

        int tempNum = userNum;
        int remainderNum = 0;
        int reverseNum = 0;

        while (tempNum > 0) {

            remainderNum = tempNum % 10;
            reverseNum = reverseNum * 10 + remainderNum;
            tempNum = tempNum / 10;

        }

        System.out.println(userNum + " reversed is " + reverseNum);
        scanOne.close();

        /*
         * Explanation:
         * User inputs 123, this is then stored in tempNum. While tempNum is > 0, store
         * the remainder of 123 % 10 in remainderNum (3). reverseNum = 3(remainderNum),
         * and new tempNum is 123 / 10 (12).
         * 
         * At this point, here are the values:
         * tempNum = 12
         * remainderNum = 3
         * reverseNum = 3
         * 
         * 12 % 10 = 2, new remainderNum. 3 * 10 + 2 = 32, new reverseNum. 12 / 10 = 1,
         * new tempNum.
         * 
         * Current values: 
         * tempNum = 1
         * remainderNum = 2
         * reverseNum = 32
         * 
         * 1 % 10 = 1, remainderNum. 32 * 10 + 1 = 321, reverseNum. 1 / 10 = 0, tempNum.
         * 
         */

    }

}
