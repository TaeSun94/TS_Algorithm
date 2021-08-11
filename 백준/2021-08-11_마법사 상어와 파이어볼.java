package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 마법사상어와파이어볼 {
	static class Fireball{
		int m, s, d;

		public Fireball( int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
	static LinkedList<Fireball>[][] map;
	static Set<int[]> set;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				map[i][j] = new LinkedList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].add(new Fireball(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		//k번 만큼 수행
		for(int k = 0; k < K; k++) {
			move();
			//2단계
			split();
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(Fireball f: map[i][j]) {
					answer += f.m;
				}
			}
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static void split() {
		// TODO Auto-generated method stub

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[i][j].size()>=2) {
					int sumM = 0;
					int sumS = 0;
					boolean odd = false, even = false;
					for(Fireball f: map[i][j]) {
						sumM += f.m;
						sumS += f.s;
						if(f.d%2 == 0)
							even = true;
						else
							odd = true;
					}
					int m = sumM/5;
					int s = sumS/map[i][j].size();
					map[i][j].clear();
					if(m > 0) {
						for(int d = 0; d < 4; d++) {
							if(odd && even) {
								map[i][j].add(new Fireball(m,s,1+2*d));
							}
							else {
								map[i][j].add(new Fireball(m,s,0+2*d));
							}
						}
					}
				}
			}
		}
	}
	private static void move() {
		// TODO Auto-generated method stub
		LinkedList<Fireball>[][] tmp = new LinkedList[map.length][map.length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++)
				tmp[i][j] = new LinkedList<>();
		}
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[i][j].size()>=1) {
					for(Fireball f: map[i][j]) {
						int dis = f.s % map.length;
						int ni = i + dr[f.d]*dis;
						int nj = j + dc[f.d]*dis;
						if(ni < 0) {
							ni += map.length;
						}
						else if(ni >= map.length)
							ni -= map.length;
						if(nj < 0)
							nj += map.length;
						else if(nj>=map.length)
							nj -= map.length;
						tmp[ni][nj].add(new Fireball(f.m,f.s,f.d));
					}
				}
			}
		}
		map = tmp;
		return;
	}
}
