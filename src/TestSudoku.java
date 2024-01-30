import java.io.FileInputStream;
import java.util.Scanner;

public class TestSudoku {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_testsoduku.txt"));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Số lượng test case

        for (int t = 0; t < T; t++) {
            int[][] grid = new int[9][9];
            // Đọc ma trận 9x9 từ input
            for (int i = 0; i < 9; i++) {
                String row = scanner.next();
                for (int j = 0; j < 9; j++) {
                    if (row.charAt(j) == '.') {
                        grid[i][j] = 0; // Chỗ chưa điền số được đánh dấu là 0
                    } else {
                        grid[i][j] = Character.getNumericValue(row.charAt(j));
                    }
                }
            }

            // Kiểm tra tính hợp lệ của Sudoku và in kết quả
            System.out.printf("#%d %d\n", t + 1, isValidSudoku(grid) ? 1 : 0);
        }

        scanner.close();
    }

    // Phương thức kiểm tra tính hợp lệ của Sudoku
    private static boolean isValidSudoku(int[][] grid) {
        // Kiểm tra từng hàng và từng cột
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(grid, i) || !isValidColumn(grid, i)) {
                return false;
            }
        }

        // Kiểm tra từng ma trận con 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubGrid(grid, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Phương thức kiểm tra tính hợp lệ của một hàng
    private static boolean isValidRow(int[][] grid, int row) {
        boolean[] seen = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (grid[row][j] != 0) {
                if (seen[grid[row][j] - 1]) {
                    return false;
                }
                seen[grid[row][j] - 1] = true;
            }
        }
        return true;
    }

    // Phương thức kiểm tra tính hợp lệ của một cột
    private static boolean isValidColumn(int[][] grid, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] != 0) {
                if (seen[grid[i][col] - 1]) {
                    return false;
                }
                seen[grid[i][col] - 1] = true;
            }
        }
        return true;
    }

    // Phương thức kiểm tra tính hợp lệ của một ma trận con 3x3
    private static boolean isValidSubGrid(int[][] grid, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] != 0) {
                    if (seen[grid[i][j] - 1]) {
                        return false;
                    }
                    seen[grid[i][j] - 1] = true;
                }
            }
        }
        return true;
    }
}
