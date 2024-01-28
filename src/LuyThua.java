import java.io.FileInputStream;
import java.util.Scanner;

public class LuyThua {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\luythua.txt"));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // Tính giá trị của ab
            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }

            // In kết quả
            System.out.println("#" + t + " " + result);
        }
    }
}