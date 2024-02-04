import java.io.FileInputStream;
import java.util.Scanner;

public class GHN {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_ghn.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Đọc số lượng test case

        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt(); // Đọc số lượng điểm
            int[][] distances = new int[N][N]; // Ma trận khoảng cách

            // Đọc ma trận khoảng cách
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distances[i][j] = scanner.nextInt();
                }
            }

            boolean[] visited = new boolean[N]; // Đánh dấu các điểm đã thăm
            int currentPos = 0; // Bắt đầu từ điểm 0
            int totalDistance = 0; // Tổng quãng đường ban đầu là 0

            // Thực hiện N-1 lần vì đã bắt đầu từ điểm 0
            for (int i = 0; i < N - 1; i++) {
                visited[currentPos] = true; // Đánh dấu điểm hiện tại là đã thăm
                int shortestDistance = Integer.MAX_VALUE;
                int nextPos = -1;

                for (int j = 0; j < N; j++) {
                    if (!visited[j] && distances[currentPos][j] < shortestDistance) {
                        shortestDistance = distances[currentPos][j];
                        nextPos = j;
                    }
                }

                totalDistance += shortestDistance; // Cộng dồn khoảng cách
                currentPos = nextPos; // Chuyển đến điểm tiếp theo
            }

            totalDistance += distances[currentPos][0]; // Quay trở lại điểm xuất phát

            System.out.println("#" + tc + " " + totalDistance); // In kết quả cho mỗi test case
        }

        scanner.close();
    }
}
