import java.io.FileInputStream;
import java.util.Scanner;

public class PROB03 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\vungbaolonnhat.txt"));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] array = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    array[j][k] = sc.nextInt();
                }
            }
            int maxsum = 0;
            for (int j = 0; j <= m - h; j++) {
                for (int k = 0; k <= n - w; k++) {
                    int sum = 0;
                    for (int tempj = j; tempj < j + h; tempj++) {
                        if (tempj == j || tempj == j + h - 1) {
                            for (int tempk = k; tempk < k + w; tempk++) {
                                if (array[tempj][tempk] % 2 == 0) {
                                    sum += array[tempj][tempk];
                                }
                            }
                        } else {
                            if (array[tempj][k] % 2 == 0) {
                                sum += array[tempj][k];
                            }
                            if (array[tempj][k + w - 1] % 2 == 0) {
                                sum += array[tempj][k + w - 1];
                            }
                        }
                    }
                    maxsum = Math.max(sum, maxsum);
                }
            }
            System.out.println("#" + (i + 1) + " " + maxsum);
        }
    }
}
