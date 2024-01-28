import java.io.FileInputStream;
import java.util.Scanner;

public class SoNen1 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_sonen.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int result = soNen(N);
            System.out.println("#" + i + " " + result);
        }
    }

    public static int soNen(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum = sum+ num % 10;
                num =num / 10;
            }
            num = sum;
        }
        return num;
    }
}
