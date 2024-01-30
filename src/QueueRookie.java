import java.io.FileInputStream;
import java.util.Scanner;

public class QueueRookie {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_queuerookie.txt"));
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Số lượng test case

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Số lượng người trong hàng đợi
            int[] heights = new int[n]; // Mảng chứa chiều cao của mỗi người
            int[] taller = new int[n]; // Mảng chứa số người cao hơn đứng trước mỗi người

            // Đọc chiều cao của mỗi người
            for (int j = 0; j < n; j++) {
                heights[j] = scanner.nextInt();
            }

            // Đọc số người cao hơn đứng trước mỗi người
            for (int j = 0; j < n; j++) {
                taller[j] = scanner.nextInt();
            }

            // Tìm vị trí của mỗi người trong hàng đợi
            int[] order = new int[n+1]; // Thay đổi kích thước của mảng order
            for (int j = 0; j < n; j++) {
                int count = taller[j];
                for (int k = 1; k <= n; k++) { // Bắt đầu từ 1 để tương thích với yêu cầu của đề bài
                    if (count == 0 && order[k] == 0) {
                        order[k] = heights[j];
                        break;
                    } else if (order[k] == 0 || order[k] >= heights[j]) {
                        count--;
                    }
                }
            }

            // In ra kết quả
            for (int j = 1; j <= n; j++) {
                System.out.print(order[j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
