import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\sum.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long a = 0;
            for (int i = 1; i <= n; i++) {
                int q = n / i;
                a = (a + ((long) q * i) % 1000007) % 1000007;
            }
            System.out.println(a);
        }
    }
}
