/*
아직 정해를 얻지 못함.
*/
package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 스타트택시 {
	static class Taxi{
		int r,c;
		long oil;
		int isRide;
		public Taxi(int r, int c, long oil, int isRide) {
			super();
			this.r = r;
			this.c = c;
			this.oil = oil;
			this.isRide =isRide;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt;
	static int[][] map;
	static int[][] passenger;
	static Taxi taxi;
	static long oil;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		oil = Long.parseLong(st.nextToken());
		cnt = 0;
		map = new int[N][N];
		passenger = new int[M][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		taxi = new Taxi(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,0,-1);
		int idx = 2;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			passenger[i][0] = Integer.parseInt(st.nextToken())-1;
			passenger[i][1] = Integer.parseInt(st.nextToken())-1;
			passenger[i][2] = Integer.parseInt(st.nextToken())-1;
			passenger[i][3] = Integer.parseInt(st.nextToken())-1;
			map[passenger[i][0]][passenger[i][1]] = idx;
			map[passenger[i][2]][passenger[i][3]] = idx++;
		}
		bfs(M);
		if(cnt != M) {
			bw.write(-1+"");
		}
		else {
			bw.write(oil+"");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs(int m) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[map.length][map.length];
		Queue<Taxi> que = new LinkedList<>();
		visited[taxi.r][taxi.c] = true;
		//생성된 장소에 승객이 있다면
		if(map[taxi.r][taxi.c] > 1) {
			que.add(new Taxi(taxi.r,taxi.c,taxi.oil,map[taxi.r][taxi.c]));
			map[taxi.r][taxi.c] = 0;
		}
		else {
			que.add(new Taxi(taxi.r,taxi.c,taxi.oil,-1));
		}
		while(!que.isEmpty()) {
			if(cnt == m) {
				break;
			}
			Taxi t = que.poll();
			if(oil < t.oil) {
				System.out.println(t.isRide+"있는데 멈춤");
				continue;
			}
			for(int d = 0; d < 4; d++) {
				int nr = t.r + dr[d];
				int nc = t.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || map[nr][nc] == 1 || visited[nr][nc]) {
					continue;
				}
				visited[nr][nc] = true;
				if(map[nr][nc] == 0) {
					que.add(new Taxi(nr,nc,t.oil+1,t.isRide));
				}
				else {
					if(t.isRide==-1) {
						if(passenger[map[nr][nc]-2][0]==nr && passenger[map[nr][nc]-2][1]==nc) {
							if(oil >= t.oil) {
								System.out.println(map[nr][nc]+" 승객 탐");
								oil -= t.oil;
								que.clear();
								visited = new boolean[map.length][map.length];
								visited[nr][nc] = true;
								que.add(new Taxi(nr,nc,0,map[nr][nc]));
								map[nr][nc] = 0;
								break;
							}
						}
						else {
							que.add(new Taxi(nr,nc,t.oil+1,t.isRide));
						}
					}
					else {
						if(map[nr][nc] == t.isRide) {
							if(oil >= t.oil) {
								oil += t.oil+1;
								taxi = new Taxi(nr,nc,0,-1);
								System.out.println(map[nr][nc]+" 승객 내림");
								map[nr][nc] = 0;
								visited = new boolean[map.length][map.length];
								visited[nr][nc] = true;
								cnt++;
								que.clear();
								que.add(new Taxi(nr,nc,0,-1));
								break;
							}
						}
						else {
							que.add(new Taxi(nr,nc,t.oil+1,t.isRide));
						}
					}
				}
			}
		}
		return;
	}
}
