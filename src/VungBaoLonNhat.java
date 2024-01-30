import java.io.FileInputStream;
import java.util.Scanner;

public class VungBaoLonNhat {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_vungbaolonnhat.txt"));
        Scanner input = new Scanner(System.in);
        int t, h, w, m, n, i, j, count, sum, k, tempj, tempk, maxsum;
        int[][] array;
        t = input.nextInt();
        for (i = 0; i < t; i++) {
            h = input.nextInt();
            w = input.nextInt();
            m = input.nextInt();
            n = input.nextInt();

            // Cấp phát bộ nhớ cho ma trận
            array = new int[m][n];
            for (j = 0; j < m; j++) {
                for (k = 0; k < n; k++) {
                    array[j][k] = input.nextInt();
                }
            }

            maxsum = 0;
            for (j = 0; j <= m - h; j++) {
                for (k = 0; k <= n - w; k++) {
                    sum = 0;
                    tempj = j;
                    while (tempj < j + h) {
                        if (tempj == j || tempj == j + h - 1) {
                            tempk = k;
                            while (tempk < k + w) {
                                if (array[tempj][tempk] % 2 == 0) {
                                    sum += array[tempj][tempk];
                                }
                                tempk++;
                            }
                        } else {
                            if (array[tempj][k] % 2 == 0) {
                                sum += array[tempj][k];
                            }
                            if (array[tempj][k + w - 1] % 2 == 0) {
                                sum += array[tempj][k + w - 1];
                            }
                        }
                        tempj++;
                    }
                    maxsum = Math.max(sum, maxsum);
                }
            }

            System.out.printf("#%d %d\n", i + 1, maxsum);
        }
    }
}
