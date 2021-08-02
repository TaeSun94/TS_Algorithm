package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 주사위굴리기 {
	static int[] cube;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static class Cube{
		int r, c;

		public Cube(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
	static int[][] map;
	static Queue<Cube> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		cube = new int[] {0,0,0,0,0,0};
		map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		que = new LinkedList<>();
		que.add(new Cube(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < K; i++) {
			Cube c = que.poll();
			int dir = Integer.parseInt(st.nextToken())-1;
			int nr = c.r + dr[dir];
			int nc = c.c + dc[dir];
			if(nr< 0|| nc < 0 || nr >= map.length || nc >= map[nr].length) {
				que.add(c);
				continue;
			}
			swap(dir);
			if(map[nr][nc] != 0) {
				cube[1] = map[nr][nc];
				map[nr][nc] = 0;
			}
			else {
				map[nr][nc] = cube[1];
			}
			que.add(new Cube(nr,nc));
			bw.write(cube[0]+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void swap(int dir) {
		int tmp = 0;
		switch(dir) {
		case 0:
			tmp = cube[0];
			cube[0] = cube[2];
			cube[2] = cube[1];
			cube[1] = cube[3];
			cube[3] = tmp;
			break;
		case 1:
			tmp = cube[0];
			cube[0] = cube[3];
			cube[3] = cube[1];
			cube[1] = cube[2];
			cube[2] = tmp;
			break;
		case 2:
			tmp = cube[0];
			cube[0] = cube[4];
			cube[4] = cube[1];
			cube[1] = cube[5];
			cube[5] = tmp;
			break;

		case 3:
			tmp = cube[0];
			cube[0] = cube[5];
			cube[5] = cube[1];
			cube[1] = cube[4];
			cube[4] = tmp;
			break;
		}
		return;
	}
}
