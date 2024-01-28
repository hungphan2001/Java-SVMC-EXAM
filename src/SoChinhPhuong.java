import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoChinhPhuong {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\sochinhphuong.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Integer> squareNumbers = new ArrayList<>();

            for (int num = a; num <= b; num++) {
                if (isSquareNumber(num)) {
                    squareNumbers.add(num);
                }
            }

            if (squareNumbers.isEmpty()) {
                System.out.println("#" + i + " NO NUMBER");
            } else {
                StringBuilder output = new StringBuilder();
                for (int j = 0; j < squareNumbers.size(); j++) {
                    output.append(squareNumbers.get(j));
                    if (j < squareNumbers.size() - 1) {
                        output.append(" ");
                    }
                }
                System.out.println("#" + i + " " + output.toString());
            }
        }
    }

    public static boolean isSquareNumber(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
