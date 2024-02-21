import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SoDep {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_sodep.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nums.add(scanner.nextInt());
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ans = 0;
            for (int j = x; j <= y; j++) {
                int cnt = 0;
                int num = j;
                while (num > 0) {
                    if (nums.contains(num % 10)) {
                        cnt++;
                    }
                    num /= 10;
                }
                if (cnt >= m) {
                    ans++;
                }
            }
            System.out.println("#" + i + " " + ans);
        }
    }
}
