import java.io.FileInputStream;
import java.util.Scanner;

public class FindStrings {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_findStrings.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = 10; // Cố định số lượng test case là 10

        for (int tc = 1; tc <= T; tc++) {
            scanner.nextInt(); // Đọc số thứ tự của test case, không sử dụng
            scanner.nextLine(); // Loại bỏ newline sau số thứ tự test case
            String S1 = scanner.nextLine(); // Đọc chuỗi S1
            String S2 = scanner.nextLine(); // Đọc chuỗi S2

            int count = countOccurrences(S1, S2);

            System.out.println("#" + tc + " " + count);
        }

        scanner.close();
    }

    // Hàm đếm số lần xuất hiện của S1 trong S2
    private static int countOccurrences(String S1, String S2) {
        int count = 0;
        int index = 0;

        while ((index = S2.indexOf(S1, index)) != -1) {
            count++;
            index++; // Tăng index để tiếp tục tìm kiếm từ vị trí kế tiếp
        }

        return count;
    }
}
