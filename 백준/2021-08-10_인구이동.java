package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 인구이동 {
	static int[][] map;
	static boolean[][] check;
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = false;
		//first init map
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		//인구이동이 일어나지 않을 때 까지 반복문
		while(!flag) {
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j])
						bfs(i,j,L,R);
				}
			}
			if(flag) {
				flag = false;
				answer++;
			}
			else
				flag = true;
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static class Country{
		int r, c;

		public Country(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	private static void bfs(int i, int j, int L, int R) {
		// TODO Auto-generated method stub
		Queue<Country> que = new LinkedList<>();
		ArrayList<Country> list = new ArrayList<>();
		visited[i][j] = true;
		que.add(new Country(i,j));
		list.add(new Country(i,j));
		while(!que.isEmpty()) {
			Country country = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = country.r + dr[d];
				int nc = country.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || visited[nr][nc])
					continue;
				if(Math.abs(map[country.r][country.c]-map[nr][nc])>=L && Math.abs(map[country.r][country.c]-map[nr][nc])<=R ) {
					visited[nr][nc] = true;
					que.add(new Country(nr,nc));
					list.add(new Country(nr,nc));
				}
			}
		}
		if(list.size()>1) {
			flag = true;
			int openCnt = list.size();
			int sum = 0;
			for(Country c: list) {
				sum += map[c.r][c.c];
			}
			for(Country c: list) {
				map[c.r][c.c]= sum/openCnt;
			}
		}
	}
}
