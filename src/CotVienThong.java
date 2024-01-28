import java.io.FileInputStream;
import java.util.Scanner;

public class CotVienThong {
    static int []dx ={0,-1,0,1};
    static int[] dy ={-1,0,1,0};
    static char[][]matrix = new char[101][101];
    static int M,N;

    public static int spread(int row,int col,int len){
        int c =0;
        for(int w =1 ;w<= len;w++){
            for(int h =0;h<4;h++){
                int tempX = row+ dx[h] * w;
                int tempY = col+ dy[h] * w;
                if(tempX>=0 && tempX<M && tempY >=0 &&tempY<N){
                    if(matrix[tempX][tempY] =='H'){
                        matrix[tempX][tempY] ='o';
                        c++;
                    }

                }
            }
        }
        return c;
    }
    public static void main(String[] args) throws  Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\cotvienthong.txt"));
        Scanner scanner = new Scanner(System.in);
        int T,numberHome;
        T = scanner.nextInt();
        for(int r =0;r<M;r++){
            for(int c =0;c<N;c++){
                matrix[r][c] =scanner.next().charAt(0);
            }
        }
    }
}
