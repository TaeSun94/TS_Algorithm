import java.util.*;
public class 성지키기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		boolean[] row = new boolean[N];
		boolean[] col = new boolean[M];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'X') {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		int answer = 0;
		int r_cnt = 0;
		int c_cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!row[i])
				r_cnt++;
		}
		for(int j = 0; j < M; j++) {
			if(!col[j])
				c_cnt++;
		}
		answer = Math.max(r_cnt, c_cnt);
		System.out.println(answer);
	}
}
