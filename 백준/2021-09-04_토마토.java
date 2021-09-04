package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 토마토 {
	static class Tomato{
		int r,c;

		public Tomato(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int[][] map;
	static int days;
	static Queue<Tomato> que;
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = true;
		que = new LinkedList<>();
		days = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.add(new Tomato(i,j));
				}
			}
		}

		while(true) {
			if(!flag || checkMap()) {
				if(!flag) {
					days = -1;
				}
				break;
			}
			flag = false;
			bfs();
			days++;
		}
		System.out.println(days);
	}
	private static boolean checkMap() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		int len = que.size();
		for(int i = 0; i < len; i++) {
			Tomato tomato = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = tomato.r + dr[d];
				int nc = tomato.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] != 0 )
					continue;
				if(!flag)
					flag = true;
				map[nr][nc] = 1;
				que.add(new Tomato(nr,nc));
			}
		}
	}
}
