import java.io.FileInputStream;
import java.util.Scanner;

public class ABSYSE {

    public static boolean allDigit(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_absyse.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String op1 = scanner.next();
            String plus = scanner.next();
            String op2 = scanner.next();
            String eq = scanner.next();
            String op3 = scanner.next();
            int result;
            if (allDigit(op1) && allDigit(op2)) {
                result = Integer.parseInt(op2) + Integer.parseInt(op1);
                System.out.println(op1 + " + " + op2 + " = " + result);
            }
            if (allDigit(op1) && allDigit(op3)) {
                result = Integer.parseInt(op3) - Integer.parseInt(op1);
                System.out.println(op1 + " + " + result + " = " + op3);
            }
            if (allDigit(op2) && allDigit(op3)) {
                result = Integer.parseInt(op3) - Integer.parseInt(op2);
                System.out.println(result + " + " + op2 + " = " + op3);
            }
        }
        scanner.close();
    }
}
