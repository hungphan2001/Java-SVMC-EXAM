import java.io.FileInputStream;
import java.util.Scanner;

public class SoNguyenTo {
    public static boolean isPrime(int n){
        if(n <2){
            return false;
        }
        for(int i =2;i<=Math.sqrt(n);i++){
            if(n %i ==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_prime.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i =0;i<t;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for(int n = x;n<=y;n++){
                if(isPrime(n)){
                    System.out.println(n);
                }
            }

            System.out.println();
        }
        scanner.close();
    }
}
