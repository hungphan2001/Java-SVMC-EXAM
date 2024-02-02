import java.io.FileInputStream;
import java.util.Scanner;

public class CountSymmetricSubstrings {
    public static int countPalindromicSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // Chuỗi con đơn ký tự
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Chuỗi con 2 ký tự
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // Chuỗi con từ 3 ký tự trở lên
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start < n - length + 1; start++) {
                int end = start + length - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_count_symmetric_substrings.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine().trim();
            int result = countPalindromicSubstrings(s);
            System.out.println("#" + i + " " + result);
        }
        scanner.close();
    }
}
