import java.util.Scanner;

public class FirstDuplicate {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int tc =1;tc<=T;tc++){
            int N = scanner.nextInt();
            int [] a = new int[N];
            int [] A = new int[100001];
            for(int i =0;i<N;i++){
                a[i] = scanner.nextInt();
            }

            int result = firstDup (a,A);
            System.out.println("#" + tc + " " + result);
        }
        scanner.close();
    }

    private static int firstDup(int[] a, int[] A) {
        for (int i = 0; i < a.length; i++) {
            if (A[a[i]] == 1) {
                return a[i];
            }
            A[a[i]] += 1;
        }
        return -1;
    }
}
