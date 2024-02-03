import java.io.FileInputStream;
import java.util.Scanner;

public class LogoSVM {
    private static final int MAX_SIZE = 33;
    private static int N;
    private static int[][] A = new int[MAX_SIZE][MAX_SIZE];

    public static void readData(Scanner scanner){
        N = scanner.nextInt();
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = scanner.nextInt();
            }
        }
    }

    public static String isSymmetry(){
        for (int i = 0; i < N/2; i++){
            for(int j = 0; j < N; j++){
                if (A[i][j] != A[N-i-1][j] || A[j][i] != A[j][N-i-1]) return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_logosvm.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int tc = 1; tc <= T; tc++){

            readData(scanner);

            System.out.println("#" + tc + " " + isSymmetry());
        }
        scanner.close();
    }
}
