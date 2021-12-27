import java.util.*;
public class 투명 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[100][100];
		for(int i = 0; i < n; i++) {
			int x1 = sc.nextInt()-1;
			int y1 = sc.nextInt()-1;
			int x2 = sc.nextInt()-1;
			int y2 = sc.nextInt()-1;
			for(int j = y1; j <= y2; j++) {
				for(int k = x1; k <= x2; k++) {
					map[j][k]++;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] > m) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
