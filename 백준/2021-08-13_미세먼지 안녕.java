package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 미세먼지안녕 {
	static class Dust{
		int r,c;

		public Dust(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static Queue<Dust> que;
	static int[][] airConditioner = new int[2][2];
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		que = new LinkedList<>();
		int index = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airConditioner[index][0] = i;
					airConditioner[index++][1] = j;
				}
			}
		}
		for(int t = 0; t < T; t++) {
			//dust추가
			addDustQue();
			//확산
			diffusion();
			//처리
			rotate();
		}
//		for(int[] m : map)
//			System.out.println(Arrays.toString(m));
		int answer = countDust();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int countDust() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] > 0)
					cnt+=map[i][j];
			}
		}
		return cnt;
	}
	private static void addDustQue() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] > 0) {
					que.add(new Dust(i,j));
				}
			}
		}
	}
	private static void rotate() {
		// TODO Auto-generated method stub
		for(int conditioner = 0; conditioner < 2; conditioner++) {
			int r = airConditioner[conditioner][0];
			int c = airConditioner[conditioner][1];
			if(conditioner == 0) {
				//좌 -> 우
				for(int i = c; i > 0; i--) {
					if(map[r][i]==-1)
						continue;
					map[r][i] = map[r][i-1];
				}
				//상 -> 하
				for(int i = r; i > 0; i--) {
					if(map[i][0]==-1)
						continue;
					map[i][0] = map[i-1][0];
				}
				//우 -> 좌
				for(int i = 0; i < map[0].length-1; i++) {
					map[0][i] = map[0][i+1];
				}
				//하 -> 상
				for(int i = 0; i < r; i++) {
					if(map[i+1][map[0].length-1]==-1) {
						map[i][map[0].length-1] = 0;
					}
					else {
						map[i][map[0].length-1] = map[i+1][map[0].length-1];
					}
				}
				//좌 -> 우
				for(int i = map[0].length-1; i > c; i--) {
					if(map[r][i-1]==-1) {
						map[r][i] = 0;
					}
					else {
						map[r][i] = map[r][i-1];
					}
				}
			}
			else {
				for(int i = c; i > 0; i--) {
					if(map[r][i]==-1)
						continue;
					map[r][i] = map[r][i-1];
				}
				for(int i = r; i < map.length-1; i++) {
					if(map[i][0] == -1)
						continue;
					map[i][0] = map[i+1][0];
				}
				for(int i = 0; i < map[0].length-1; i++) {
					map[map.length-1][i] = map[map.length-1][i+1];
				}
				for(int i = map.length-1; i > r; i--) {
					if(map[i-1][map[0].length-1]==-1) {
						map[i][map[0].length-1] = 0;
					}
					else
						map[i][map[0].length-1] = map[i-1][map[0].length-1];
				}
				for(int i = map[0].length-1; i > c; i--) {
					if(map[r][i-1] == -1)
						map[r][i] = 0;
					else
						map[r][i] = map[r][i-1];
				}
			}
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void diffusion() {
		// TODO Auto-generated method stub
		int[][] tmpMap = new int[map.length][map[0].length];
		tmpMap[airConditioner[0][0]][airConditioner[0][1]] = -1;
		tmpMap[airConditioner[1][0]][airConditioner[1][1]] = -1;
		while(!que.isEmpty()) {
			Dust dust = que.poll();
			int cnt = 0;
			int amount = map[dust.r][dust.c]/5;
			for(int d = 0; d < 4; d++) {
				int nr = dust.r + dr[d];
				int nc = dust.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || map[nr][nc] == -1)
					continue;
				tmpMap[nr][nc] += amount;
				cnt++;
			}
			tmpMap[dust.r][dust.c] += map[dust.r][dust.c]-amount*cnt;
		}
		map = tmpMap;
	}
}
