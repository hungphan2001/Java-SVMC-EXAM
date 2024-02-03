import java.io.FileInputStream;
import java.util.Scanner;

public class FNDMTX {
    static final int INT_MAX = 2147483647;

    public static void display(int[][] arr, int row, int column) {
        System.out.println("START");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("END");
    }

    public static int diff(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_fndmtx.txt"));
        Scanner scanner = new Scanner(System.in);
        int t, round = 0, n, m, k, bestDiff, bestSum, bestX, bestY;
        int[][] arr;
        t = scanner.nextInt();
        while (t > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            bestDiff = INT_MAX;
            bestSum = INT_MAX;
            bestX = 0;
            bestY = 0;

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i <= n - m; i++) {
                int currentSum = 0;
                for (int j = 0; j <= n - m; j++) {
                    if (j == 0) {
                        for (int o = i; o < i + m; o++) {
                            for (int p = j; p < j + m; p++) {
                                currentSum += arr[o][p];
                            }
                        }
                    } else {
                        for (int o = i; o < i + m; o++) {
                            currentSum += arr[o][j + m - 1];
                            currentSum -= arr[o][j - 1];
                        }
                    }
                    if (diff(currentSum, k) < bestDiff) {
                        bestDiff = diff(currentSum, k);
                        bestX = i;
                        bestY = j;
                        bestSum = currentSum;
                    } else if (diff(currentSum, k) == bestDiff) {
                        if (currentSum < bestSum) {
                            bestX = i;
                            bestY = j;
                            bestSum = currentSum;
                        } else if (currentSum == bestSum) {
                            if (i <= bestX && j <= bestY) {
                                bestX = i;
                                bestY = j;
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d %d\n", ++round, bestX, bestY);
            t--;
        }
        scanner.close();
    }
}
