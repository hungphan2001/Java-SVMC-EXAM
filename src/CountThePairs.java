import java.io.FileInputStream;
import java.util.Scanner;

public class CountThePairs {
    public static void main(String[] args) throws Exception {
        //Read file from input
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_countthepairs.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Nhập số lượng test case từ bàn phím
        if (T > 50) { // Kiểm tra xem số lượng test case có vượt quá 50 hay không
            throw new IllegalArgumentException("Number of test cases cannot exceed 50"); // Nếu vượt quá, ném ra ngoại lệ IllegalArgumentException
        }
        for (int t = 0; t < T; t++) { // Vòng lặp qua từng test case
            int N = sc.nextInt(); // Nhập số lượng phần tử trong mảng từ bàn phím
            int K = sc.nextInt(); // Nhập giá trị K từ bàn phím
            int[] arr = new int[N]; // Khai báo một mảng để lưu trữ các phần tử
            for (int i = 0; i < N; i++) { // Vòng lặp nhập các phần tử của mảng từ bàn phím
                arr[i] = sc.nextInt();
            }
            int count = 0; // Khởi tạo biến đếm số lượng cặp phần tử thỏa mãn yêu cầu
            for (int i = 0; i < N - 1; i++) { // Vòng lặp duyệt qua từng cặp phần tử trong mảng
                for (int j = i + 1; j < N; j++) {
                    if (Math.abs(arr[i] - arr[j]) == K) { // Kiểm tra xem hiệu giữa hai phần tử có bằng K hay không
                        count++; // Nếu bằng, tăng biến đếm lên 1
                    }
                }
            }
            System.out.println(count); // In ra số lượng cặp phần tử thỏa mãn yêu cầu của bài toán
        }
    }
}
