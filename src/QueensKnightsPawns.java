import java.io.FileInputStream;
import java.util.*;
public class QueensKnightsPawns {
    public static final int NOT_SAFE = 0;
    public static final int SAFE = 1;
    public static final int QUEEN = 2;
    public static final int KNIGHT = 3;
    public static final int PAWN = 4;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_queensKnightsPawns.txt"));
        Scanner scanner = new Scanner(System.in);
        int m = 1, n = 1, round = 1, count_safe, count_chess, count_pos, x, y;
        int i, j, k;
        int[][] array;
        int[] knight_moveX = {+2, +1, -1, -2, -2, -1, +1, +2};
        int[] knight_moveY = {+1, +2, +2, +1, -1, -2, -2, -1};
        int[] Q_cross_moveX = {+1, +1, -1, -1};
        int[] Q_cross_moveY = {+1, -1, +1, -1};
        int[] Q_straight_move = {+1, -1};

        while(true) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            if(m == 0 && n == 0)
                break;
            count_chess = QUEEN;
            count_safe = 0;
            array = new int[m][n];

            for(i=0; i<m; i++) {
                for(j=0; j<n; j++) {
                    array[i][j] = SAFE;
                }
            }

            while(count_chess <= PAWN) {
                count_pos = scanner.nextInt();
                while(count_pos > 0) {
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    array[x-1][y-1] = count_chess;
                    count_pos--;
                }
                count_chess++;
            }

            for(i=0; i<m; i++) {
                for(j=0; j<n; j++) {
                    if(array[i][j] == KNIGHT) {
                        for(k=0; k<8; k++) {
                            int tempX = i + knight_moveX[k];
                            int tempY = j + knight_moveY[k];
                            if(tempX<0 || tempX>=m || tempY<0 || tempY>=n || array[tempX][tempY] != SAFE)
                                continue;
                            array[tempX][tempY] = NOT_SAFE;
                        }
                    } else if(array[i][j] == QUEEN) {
                        for(k=0; k<2; k++) {
                            int tempX = i + Q_straight_move[k];
                            int tempY = j + Q_straight_move[k];
                            while(true) {
                                if(tempX<0 || tempX>=m || (array[tempX][j]!=SAFE && array[tempX][j]!=NOT_SAFE))
                                    break;
                                array[tempX][j] = NOT_SAFE;
                                tempX += Q_straight_move[k];
                            }
                            while(true) {
                                if(tempY<0 || tempY>=n || (array[i][tempY]!=SAFE && array[i][tempY]!=NOT_SAFE))
                                    break;
                                array[i][tempY] = NOT_SAFE;
                                tempY += Q_straight_move[k];
                            }
                        }
                        for(k=0; k<4; k++) {
                            int tempX = i+Q_cross_moveX[k];
                            int tempY = j+Q_cross_moveY[k];
                            do {
                                if(tempX<0 || tempX>=m || tempY<0 || tempY>=n || (array[tempX][tempY]!=SAFE && array[tempX][tempY]!=NOT_SAFE))
                                    break;
                                array[tempX][tempY] = NOT_SAFE;
                                tempX += Q_cross_moveX[k];
                                tempY += Q_cross_moveY[k];
                            } while (true);
                        }
                    }
                }
            }

            for(i=0; i<m; i++) {
                for(j=0; j<n; j++) {
                    if(array[i][j] == SAFE) {
                        count_safe++;
                    }
                }
            }

            System.out.println("Board " + round++ + " has " + count_safe + " safe squares.");
        }
    }
}
