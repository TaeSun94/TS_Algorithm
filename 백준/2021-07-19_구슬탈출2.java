package 삼성기출;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 구술탈출2 {
	static class Ball{
		int r_r, r_c, b_r,b_c,cnt;

		public Ball(int r_r, int r_c, int b_r, int b_c, int cnt) {
			super();
			this.r_r = r_r;
			this.r_c = r_c;
			this.b_r = b_r;
			this.b_c = b_c;
			this.cnt = cnt;
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static Queue<Ball> que;
	static char[][] map;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		count = Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		que = new LinkedList<>();
		Ball ball = new Ball(0,0,0,0,0);
		//map 생성
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					ball.r_r = i;
					ball.r_c = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'B') {
					ball.b_r = i;
					ball.b_c = j;
					map[i][j] = '.';
				}
			}
		}
		bfs(ball);
	}
	private static void bfs(Ball ball) {
		// TODO Auto-generated method stub
		boolean[][][][] check = new boolean[map.length][map[0].length][map.length][map[0].length];
		check[ball.r_r][ball.r_c][ball.b_r][ball.b_c] = true;
		que.add(ball);
		while(!que.isEmpty()) {
			Ball b = que.poll();
			if(b.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			for(int d = 0; d < 4; d++) {
				int br = b.b_r;
				int bc = b.b_c;
				while(true) {
					br += dr[d];
					bc += dc[d];
					if(map[br][bc] == '#') {
						br -= dr[d];
						bc -= dc[d];
						break;
					}
					if(map[br][bc] =='O') {
						break;
					}
				}
				int rr = b.r_r;
				int rc = b.r_c;
				while(true) {
					rr += dr[d];
					rc += dc[d];
					if(map[rr][rc] == 'O')
						break;
					if(map[rr][rc] == '#') {
						rr -= dr[d];
						rc -= dc[d];
						break;
					}
				}
				if(map[br][bc] == 'O') {
					continue;
				}
				if(map[rr][rc] == 'O') {
					System.out.println(b.cnt+1);
					return;
				}
				if(check[rr][rc][br][bc])
					continue;
				if(rr == br && rc == bc) {
					if(d == 0) {
						if(b.r_c > b.b_c) {
							rc += 1;
						}
						else {
							bc += 1;
						}
					}
					else if(d == 1) {
						if(b.r_c > b.b_c) {
							bc -= 1;
						}
						else {
							rc -= 1;
						}
					}
					else if(d == 2) {
						if(b.r_r > b.b_r) {
							rr += 1;
						}
						else {
							br += 1;
						}
					}
					else {
						if(b.r_r > b.b_r) {
							br -= 1;
						}
						else {
							rr -= 1;
						}
					}
				}
				if(!check[rr][rc][br][bc]) {
					check[rr][rc][br][bc] = true;
					que.add(new Ball(rr,rc,br,bc,b.cnt+1));
				}
			}
		}
		return;
	}
}
