import java.io.FileInputStream;
import java.util.Scanner;

public class ReversedNumbers {
    public static void main(String[] args)  throws  Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_reverse.txt"));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            // Read the reversed numbers
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            //Reverse both numbers
            int reversedSum1 = reverseNumber(num1);
            int reversedSum2 = reverseNumber(num2);
            int result = reverseNumber(reversedSum1 + reversedSum2);

            System.out.println(result);
        }
    }

    private static int reverseNumber(int n) {
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n = n /10;
        }

        return reversed;
    }
}
