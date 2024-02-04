import java.io.FileInputStream;
import java.util.Scanner;

public class ManageArray {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_array.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Đọc số lượng test case

        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt(); // Đọc số phần tử ban đầu của mảng
            int[] A = new int[1000]; // Khởi tạo mảng A với kích thước tối đa là 1000

            // Đọc dữ liệu của mảng A
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            int M = scanner.nextInt(); // Đọc số thao tác
            scanner.nextLine(); // Đọc qua dòng mới sau khi đọc số

            for (int i = 0; i < M; i++) {
                String operation = scanner.next();
                int position = scanner.nextInt();

                switch (operation) {
                    case "insert":
                        int valueToInsert = scanner.nextInt();
                        // Dịch chuyển các phần tử để chèn giá trị mới
                        for (int j = N; j > position; j--) {
                            A[j] = A[j - 1];
                        }
                        A[position] = valueToInsert;
                        N++; // Tăng số lượng phần tử trong mảng
                        break;
                    case "update":
                        int valueToUpdate = scanner.nextInt();
                        A[position] = valueToUpdate;
                        break;
                    case "delete":
                        // Dịch chuyển các phần tử sau khi xóa
                        for (int j = position; j < N - 1; j++) {
                            A[j] = A[j + 1];
                        }
                        N--; // Giảm số lượng phần tử trong mảng
                        break;
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
