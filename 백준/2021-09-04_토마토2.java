package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 다중토마토 {
	static class Tomato{
		int r,c,z;

		public Tomato(int r, int c,int z) {
			super();
			this.r = r;
			this.c = c;
			this.z = z;
		}

	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int[][][] map;
	static int days,M,N,H;
	static Queue<Tomato> que;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		flag = true;
		que = new LinkedList<>();
		days = 0;
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < M; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if(map[i][j][h] == 1) {
						que.add(new Tomato(i,j,h));
					}
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
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j][h] == 0)
						return false;
				}
			}
		}
		return true;
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		int len = que.size();
		for(int i = 0; i < len; i++) {
			Tomato tomato = que.poll();
			int up = tomato.z + 1;
			if(up < H) {
				if(map[tomato.r][tomato.c][up]==0) {
					map[tomato.r][tomato.c][up]=1;
					que.add(new Tomato(tomato.r,tomato.c,up));
					flag = true;
				}
			}
			int down = tomato.z -1;
			if(down >= 0) {
				if(map[tomato.r][tomato.c][down]==0) {
					map[tomato.r][tomato.c][down]=1;
					que.add(new Tomato(tomato.r,tomato.c,down));
					flag = true;
				}
			}

			for(int d = 0; d < 4; d++) {
				int nr = tomato.r + dr[d];
				int nc = tomato.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc][tomato.z] != 0 )
					continue;
				if(!flag)
					flag = true;
				map[nr][nc][tomato.z] = 1;
				que.add(new Tomato(nr,nc,tomato.z));
			}
		}
	}
}
