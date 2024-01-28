import java.util.Scanner;
public class CanBacHai {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();

            // Tính giá trị của căn bậc hai
            int result = (int) Math.sqrt(n);

            // In kết quả
            System.out.println("#" + t + " " + result);
        }
    }
}
