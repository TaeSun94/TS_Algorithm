package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 치킨거리 {
	static int[][] map;
	static int min;
	static class Store{
		int r,c;

		public Store(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static ArrayList<Store> list;
	static int[] input;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Store(i,j));
				}
			}
		}
		input = new int[list.size()];
		for(int i = 0; i < input.length; i++) {
			input[i] = i;
		}
		result = new int[M];
		comb(0,0);
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	static int[][] visited;
	private static void comb(int idx, int s_idx) {
		// TODO Auto-generated method stub
		if(s_idx == result.length) {
			//치킨집 고른 이후 bfs를 돌며 각 집의 치킨 거리를 구한 뒤 해당 점수를 합산하여 최솟값 찾기
			visited = new int[map.length][map.length];
			bfs();
			min = Math.min(min, sumLen());
			return;
		}
		if(idx == input.length)
			return;
		result[s_idx] = input[idx];
		comb(idx+1,s_idx+1);
		comb(idx+1,s_idx);
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Store> que = new LinkedList<>();
		for(int num: result) {
			que.add(list.get(num));
			visited[list.get(num).r][list.get(num).c] = -1;
		}
		while(!que.isEmpty()) {
			Store store = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = store.r + dr[d];
				int nc = store.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || visited[nr][nc] > 0 || visited[nr][nc]<0)
					continue;
				if(visited[store.r][store.c]==-1) {
					visited[nr][nc] = 1;
				}
				else
					visited[nr][nc] = visited[store.r][store.c]+1;
				que.add(new Store(nr,nc));
			}
		}
	}
	private static int sumLen() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					sum += visited[i][j];
				}
			}
		}
		return sum;
	}
}
