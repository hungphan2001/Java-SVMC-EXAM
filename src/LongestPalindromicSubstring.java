import java.io.FileInputStream;
import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static int longestPalindromicSubstringLength(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;

        // Mọi chuỗi đơn ký tự đều là chuỗi đối xứng
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Kiểm tra chuỗi con 2 ký tự
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // Kiểm tra cho chuỗi con từ 3 ký tự trở lên
        for (int len = 3; len <= n; len++) {
            for (int start = 0; start < n - len + 1; start++) {
                int end = start + len - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    maxLength = len;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_longestPalindromicSubstringLength.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine().trim();
            int result = longestPalindromicSubstringLength(s);
            System.out.println("#" + i + " " + result);
        }
        scanner.close();
    }
}
