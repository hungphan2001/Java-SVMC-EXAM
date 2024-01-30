import java.io.FileInputStream;
import java.util.*;
public class QueensKnightsPawns {
        static int[][] board; // Lưu bàn cờ
        static int row, col; // Số hàng, cột
        static final int Q = 0, K = 1, P = 2, Safe = 3, Unsafe = 4;

        // Đường đi con mã
        static int[] K_row = {-1, -2, 1, 2, -2, -1, 2, 1};
        static int[] K_col = {2, 1, 2, 1, -1, -2, -1, -2};

        /*
         * Tính số ô con mã có thể ăn
         *
         * @PARAM: row, hàng của con mã đang xét
         *
         * @PARAM: col, cột của con mã đang xét
         *
         * RETURN: số vị trí con mã có thể ăn
         */
        static int checkK(int row, int col) {
            int count = 0;
            // Kiểm tra 8 hướng của con mã
            for (int i = 0; i < 8; i++) {
                int r = row + K_row[i];
                int c = col + K_col[i];
                if (r <= QueensKnightsPawns.row && r >= 0 && c <= QueensKnightsPawns.col && c >= 0) {
                    // Nếu ô nào đang ở vị trí an toàn
                    // thì tức là con mã có thể ăn
                    // cho ô đó thành Unsafe để tránh lặp và tăng biến đếm
                    if (board[r][c] == Safe) {
                        board[r][c] = Unsafe;
                        count++;
                    }
                }
            }
            return count;
        }

        // Đường đi con hậu
        static int[] Q_row = {0, 0, 1, 1, 1, -1, -1, -1};
        static int[] Q_col = {1, -1, -1, 0, 1, -1, 0, 1};
        static int sum = 0;

        /*
         * Duyệt mỗi con hậu tại vị trí row, col theo từng hướng Sử dụng đệ quy
         */
        static void checkQ(int row, int col, int direct) {
            int r = row + Q_row[direct];
            int c = col + Q_col[direct];

            if (r <= QueensKnightsPawns.row && r >= 0 && c <= QueensKnightsPawns.col && c >= 0) {
                // Ô nào đang an toàn thì sẽ bị ăn
                // Cho thành Unsafe
                if (board[r][c] == Safe) {
                    board[r][c] = Unsafe;
                    sum--;
                    checkQ(r, c, direct);
                } else if (board[r][c] == Unsafe) {
                    // Trường hợp này là đã tính trước đó.
                    checkQ(r, c, direct);
                }
            }
        }

        public static void main(String[] args) throws Exception{
            System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_queensKnightsPawns.txt"));
            Scanner scanner = new Scanner(System.in);
            int tc = 0;
            while (true) {
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row == 0 && col == 0)
                    break;
                tc++;
                sum = row * col;
                row--;
                col--;

                // Ban đầu gán các ô là ô an toàn
                board = new int[row + 1][col + 1];
                for (int r = 0; r <= row; r++)
                    for (int c = 0; c <= col; c++)
                        board[r][c] = Safe;

                int[][] rc = new int[2][100]; // Lưu thông tin con hậu, con mã
                int[] num = new int[3]; // Số lượng con hậu, con mã, con tốt

                // Tiếp tục nhập đầu vào
                for (int i = 0; i < 3; i++) {
                    num[i] = scanner.nextInt();
                    for (int j = 0; j < num[i]; j++) {
                        int r = scanner.nextInt();
                        int c = scanner.nextInt();
                        board[r - 1][c - 1] = i;
                        if (i != 2) {
                            rc[i][j] = r - 1;
                            rc[i][j] = c - 1;
                        }
                    }
                }

                // Tính tổng các ô rảnh mà chưa có con nào đang đứng
                sum -= num[Q] + num[K] + num[P];

                // Duyệt các con mã
                for (int j = 0; j < num[K]; j++)
                    sum -= checkK(rc[K][j], rc[K][j]);

                // Duyệt các con hậu
                for (int j = 0; j < num[Q]; j++)
                    for (int i = 0; i < 8; i++)
                        checkQ(rc[Q][j], rc[Q][j], i);

                System.out.println("Board " + tc + " has " + sum + " safe squares.");
            }
            scanner.close();
        }
}
