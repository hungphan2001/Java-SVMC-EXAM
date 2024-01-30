import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueRookie {

    public static void main(String[] args) throws  Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_queuerookie.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt();
            int[][] A = new int[N][2];

            for (int i = 0; i < N; i++) {
                A[i][0] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                A[i][1] = scanner.nextInt();
            }

            // Sắp xếp mảng A theo chiều cao tăng dần
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (A[i][0] > A[j][0]) {
                        swap(A, i, j);
                    }
                }
            }

            // Thực hiện điều chỉnh vị trí các người trong hàng đợi
            for (int i = N - 1; i >= 0; i--) {
                int lui = A[i][1];
                for (int j = i; j < i + lui; j++) {
                    swap(A, j, j + 1);
                    if (A[j][0] == A[j + 1][0]) {
                        lui++; // Nếu người cùng chiều cao phải lui thêm
                    }
                }
            }

            // In ra kết quả
            for (int i = 0; i < N; i++) {
                System.out.print(A[i][0] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void swap(int[][] A, int i, int j) {
        // Swap chiều cao
        int temp1 = A[i][0];
        A[i][0] = A[j][0];
        A[j][0] = temp1;
        // Swap thứ hạng
        int temp2 = A[i][1];
        A[i][1] = A[j][1];
        A[j][1] = temp2;
    }
}
