package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 연구소3 {
	static int[][] map;
	static class Virus{
		int r, c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Virus [r=" + r + ", c=" + c + "]";
		}

	}
	static int[] input;
	static int[] result;
	static ArrayList<Virus> list;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Virus(i,j));
				}
			}
		}
		if(list.size() < M)
			M = list.size();
		input = new int[list.size()];
		result = new int[M];
		for(int i = 0; i < input.length; i++) {
			input[i] = i;
		}
		comb(0,0);
		if(min == Integer.MAX_VALUE) {
			bw.write(-1+"");
		}
		else {
			bw.write(min+"");
		}
		bw.flush();
		bw.close();
	}
	private static void comb(int sidx, int idx) {
		// TODO Auto-generated method stub
		if(sidx == result.length) {
			Queue<Virus> que = new LinkedList<>();
			for(int i = 0; i < result.length; i++) {
				que.add(list.get(result[i]));
			}
			bfs(que);
			return;
		}
		if(idx == input.length)
			return;
		result[sidx] = input[idx];
		comb(sidx+1, idx+1);
		comb(sidx, idx+1);
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(Queue<Virus> que) {
		// TODO Auto-generated method stub
		int[][] dist = new int[map.length][map.length];
		int len = que.size();
		for(int i = 0; i < len; i++) {
			Virus v = que.poll();
			dist[v.r][v.c]= -1;
			que.add(v);
		}
		while(!que.isEmpty()) {
			Virus v = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = v.r + dr[d];
				int nc = v.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || dist[nr][nc] != 0 || map[nr][nc] == 1)
					continue;
				if(dist[v.r][v.c]==-1) {
					dist[nr][nc] = 1;
				}
				else {
					dist[nr][nc] = dist[v.r][v.c]+1;
				}
				que.add(new Virus(nr,nc));
			}
		}
		//빈공간에 0이 없는지 check
		int max = 0;
		boolean flag = false;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0 && dist[i][j] == 0) {
					flag = true;
					break;
				}
				if(map[i][j]==2 && max < dist[i][j])
					continue;
				max = Math.max(dist[i][j],max);
			}
		}
		if(!flag) {
			min = Math.min(max,min);
		}
	}
}
