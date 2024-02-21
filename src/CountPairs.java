import java.io.FileInputStream;
import java.util.Scanner;

public class CountPairs {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_countpairs.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int result = countPairsWithDiffK(arr, N, K);
            System.out.println(result);
        }

        scanner.close();
    }

    public static int countPairsWithDiffK(int[] arr, int N, int K) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Math.abs(arr[i] - arr[j]) == K) {
                    count++;
                }
            }
        }
        return count;
    }
}
