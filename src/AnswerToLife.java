import java.io.FileInputStream;
import java.util.Scanner;

public class AnswerToLife {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_anstolife.txt"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 42) {
                break;
            }
            System.out.println(n);
        }
    }
}
