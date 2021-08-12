package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 아기상어 {
	static class Shark{
		int r,c,weight,cnt,eat;

		public Shark(int r, int c, int weight, int cnt, int eat) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
			this.cnt = cnt;
			this.eat = eat;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", weight=" + weight + ", cnt=" + cnt + ", eat=" + eat + "]";
		}

	}
	static int[][] map;
	static Queue<Shark> que;
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		Shark s = new Shark(0,0,0,0,0);
		que = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					s=new Shark(i,j,2,0,0);
					map[i][j] = 0;
				}
			}
		}
		bfs(s);
		bw.write(que.poll().cnt+"");
		bw.flush();
		bw.close();
	}
	private static void bfs(Shark s) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[map.length][map.length];
		visited[s.r][s.c]= true;
		if(s.eat == s.weight ) {
			s.weight++;
			s.eat = 0;
		}
		que.add(s);
		while(!que.isEmpty()) {
			Shark shark = que.poll();
			boolean flag = false;
			for(int d = 0; d < 4; d++) {
				int nr = shark.r + dr[d];
				int nc = shark.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || visited[nr][nc] || map[nr][nc] > shark.weight)
					continue;
				visited[nr][nc] = true;
				if(map[nr][nc]==0 || map[nr][nc] == shark.weight) {
					que.add(new Shark(nr,nc,shark.weight,shark.cnt+1,shark.eat));
				}
				//먹었다면
				else {
					//남은 거에서 찾기
					while(!que.isEmpty()) {
						Shark tmp = que.poll();
						if(tmp.cnt+1 > shark.cnt+1)
							continue;
						for(int dd = 0; dd < 4; dd++) {
							int nnr = tmp.r + dr[dd];
							int nnc = tmp.c + dc[dd];
							if(nnr < 0 || nnc < 0 || nnr >= map.length || nnc >= map.length || visited[nnr][nnc] || map[nr][nc] > tmp.weight)
								continue;
							visited[nnr][nnc] = true;
							if(map[nnr][nnc] < tmp.weight && map[nnr][nnc]>0) {
								if(nr > nnr) {
									nr = nnr;
									nc = nnc;
								}
								else if(nr == nnr) {
									if(nc > nnc) {
										nr = nnr;
										nc = nnc;
									}
								}
							}
						}
					}
					que.clear();
					if(shark.weight == shark.eat+1)
						s = new Shark(nr,nc,shark.weight+1, shark.cnt+1, 0);
					else
						s = new Shark(nr,nc,shark.weight,shark.cnt+1, shark.eat+1);
					que.add(s);
					visited = new boolean[map.length][map.length];
//					map[nr][nc] = -1;
					visited[nr][nc] = true;
					flag = true;
//					System.out.println(s.toString());
//					for(int[] m: map)
//						System.out.println(Arrays.toString(m));
					map[nr][nc] = 0;
				}
				if(flag)
					break;
			}
		}
		que.add(s);
	}
}
