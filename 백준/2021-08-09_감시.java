package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 감시 {
	static int[][] map;
	static class CCTV{
		int r,c,type;

		public CCTV(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", type=" + type + "]";
		}

	}
	static ArrayList<CCTV> que;
	static boolean[][] visited;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = 0;
		int counts = 0;
		visited = new boolean[N][M];
		que = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					counts++;
				if(map[i][j] > 0 & map[i][j] < 6) {
					que.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		dfs(0,new boolean[N][M]);
		bw.write((counts-max)+"");
		bw.flush();
		bw.close();
	}
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	private static void dfs(int idx, boolean[][] check) {
		// TODO Auto-generated method stub
		if(idx == que.size()) {
			max = Math.max(max, countArea(check));
			return;
		}
		CCTV cctv = que.get(idx);
		check[cctv.r][cctv.c] = true;
		switch(cctv.type) {
			case 1:
				for(int d = 0; d < 4; d++) {
					boolean[][] tmp = new boolean[check.length][check[0].length];
					for(int i = 0; i < check.length; i++) {
						for(int j = 0; j < check[i].length; j++) {
							tmp[i][j] = check[i][j];
						}
					}
					int nr = cctv.r + dr[d];
					int nc = cctv.c + dc[d];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
					dfs(idx+1,tmp);
				}
				break;
			case 2:
				for(int d = 0; d < 2; d++) {
					boolean[][] tmp = new boolean[check.length][check[0].length];
					for(int i = 0; i < check.length; i++) {
						for(int j = 0; j < check[i].length; j++) {
							tmp[i][j] = check[i][j];
						}
					}
					int nr = cctv.r + dr[d];
					int nc = cctv.c + dc[d];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
					nr = cctv.r + dr[d+2];
					nc = cctv.c + dc[d+2];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d+2];
						nc += dc[d+2];
					}
					dfs(idx+1,tmp);
				}
				break;
			case 3:
				for(int d = 0; d < 4; d++) {
					boolean[][] tmp = new boolean[check.length][check[0].length];
					for(int i = 0; i < check.length; i++) {
						for(int j = 0; j < check[i].length; j++) {
							tmp[i][j] = check[i][j];
						}
					}
					int nr = cctv.r + dr[d];
					int nc = cctv.c + dc[d];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
					int dir = d;
					if(dir == 3) {
						dir = -1;
					}
					nr = cctv.r + dr[dir+1];
					nc = cctv.c + dc[dir+1];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[dir+1];
						nc += dc[dir+1];
					}
					dfs(idx+1,tmp);
				}
				break;
			case 4:
				for(int d = 0; d < 4; d++) {
					boolean[][] tmp = new boolean[check.length][check[0].length];
					for(int i = 0; i < check.length; i++) {
						for(int j = 0; j < check[i].length; j++) {
							tmp[i][j] = check[i][j];
						}
					}
					int nr = cctv.r + dr[d];
					int nc = cctv.c + dc[d];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
					int dir = d;
					dir++;
					if(dir >= 4) {
						dir -=4;
					}
					nr = cctv.r + dr[dir];
					nc = cctv.c + dc[dir];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[dir];
						nc += dc[dir];
					}
					dir++;
					if(dir >= 4) {
						dir -=4;
					}
					nr = cctv.r + dr[dir];
					nc = cctv.c + dc[dir];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[dir];
						nc += dc[dir];
					}
					dfs(idx+1,tmp);
				}
				break;
			case 5:
				boolean[][] tmp = new boolean[check.length][check[0].length];
				for(int i = 0; i < check.length; i++) {
					for(int j = 0; j < check[i].length; j++) {
						tmp[i][j] = check[i][j];
					}
				}
				for(int d = 0; d < 4; d++) {
					int nr = cctv.r + dr[d];
					int nc = cctv.c + dc[d];
					while(true) {
						if(nr < 0 || nc < 0 || nr >=map.length || nc >= map[nr].length || map[nr][nc] == 6)
							break;
						tmp[nr][nc] = true;
						nr += dr[d];
						nc += dc[d];
					}
				}
				dfs(idx+1,tmp);
				break;
		}
		return;
	}

	private static int countArea(boolean[][] check) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j]==0 && check[i][j])
					cnt++;
			}
		}
		return cnt;
	}
}
