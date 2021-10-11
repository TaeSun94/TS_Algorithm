package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 치즈 {
	static int[][] map;
	static boolean[][] out;
	static int[][] dist;
	static class Node{
		int r,c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static boolean flag;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					count++;
			}
		}
		int answer = 0;
		while(true) {
			if(count == 0) {
				break;
			}
			//외부 공기 dfs
			out = new boolean[N][M];
			checkOutAir();
//			for(boolean[] b: out)
//				System.out.println(Arrays.toString(b));
//			System.out.println();
			//치즈 외벽 2개 이상인거 구하기
			dist = new int[N][M];
			countOutSide();
//			for(int[] d: dist)
//				System.out.println(Arrays.toString(d));
//			System.out.println();
			removeCheese();
			answer++;
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static void removeCheese() {
		// TODO Auto-generated method stub
		for(int i = 0; i < dist.length; i++) {
			for(int j = 0; j < dist[i].length; j++) {
				if(dist[i][j]>= 2) {
					map[i][j] = 0;
					count--;
				}
			}
		}
	}
	private static void countOutSide() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					int cnt = 0;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || map[nr][nc] == 1 || !out[nr][nc]) {
							continue;
						}
						cnt++;
					}
					dist[i][j] = cnt;
				}
			}
		}
	}
	private static void checkOutAir() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map[0].length; i++) {
			if(map[0][i] == 0 && !out[0][i]) {
				checkAir(0,i);
			}
		}
		for(int i = 0; i < map[0].length; i++) {
			if(map[map.length-1][i] == 0 && !out[map.length-1][i]) {
				checkAir(map.length-1,i);
			}
		}
		for(int i = 0; i < map.length; i++) {
			if(map[i][0] == 0 && !out[i][0]) {
				checkAir(i,0);
			}
		}
		for(int i = 0; i < map.length; i++) {
			if(map[i][map[0].length-1] == 0 && !out[i][map[0].length-1]) {
				checkAir(i,map[0].length-1);
			}
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void checkAir(int r, int c) {
		// TODO Auto-generated method stub
		out[r][c] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || out[nr][nc] || map[nr][nc] == 1)
				continue;
			checkAir(nr,nc);
		}
	}
}
