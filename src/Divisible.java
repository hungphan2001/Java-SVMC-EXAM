import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Divisible {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i = 0; i<t ;i++){
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            printDivisibleNumbers(n,x,y);
        }
    }

    public static void printDivisibleNumbers(int n,int x,int y){
        StringBuilder stringBuilder = new StringBuilder();
        for (int a=2; a<n ;a++){
            if(a % x ==0 && a %y !=0){
                stringBuilder.append(a).append(" ");
            }
        }
        System.out.println(stringBuilder.toString().trim());
    }
}