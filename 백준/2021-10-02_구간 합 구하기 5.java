package 쩜문제추천;
import java.util.*;
public class 구간합구하기5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int x = sc.nextInt();
				map[i][j] = x + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}
		for(int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(map[x2][y2]-map[x1-1][y2]-map[x2][y1-1]+map[x1-1][y1-1]);
		}
	}
}
