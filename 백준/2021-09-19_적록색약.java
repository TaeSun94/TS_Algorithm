package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 적록색약 {
	static class RGB{
		char data;
		int r,c;
		public RGB(char data, int r, int c) {
			super();
			this.data = data;
			this.r = r;
			this.c = c;
		}

	}
	static char[][] map;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[N][N];
		cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		bw.write(cnt+" ");
		cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					RGbfs(i,j);
				}
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void RGbfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<RGB> que = new LinkedList<>();
		visited[i][j] = true;
		que.add(new RGB(map[i][j],i,j));
		while(!que.isEmpty()) {
			RGB rgb = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = rgb.r + dr[d];
				int nc = rgb.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || visited[nr][nc])
					continue;
				if(rgb.data == 'B') {
					if(map[nr][nc] != rgb.data)
						continue;
				}
				else {
					if(map[nr][nc] == 'B')
						continue;
				}
				visited[nr][nc] = true;
				que.add(new RGB(rgb.data, nr, nc));
			}
		}
		cnt++;
		return;
	}
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<RGB> que = new LinkedList<>();
		visited[i][j] = true;
		que.add(new RGB(map[i][j],i,j));
		while(!que.isEmpty()) {
			RGB rgb = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = rgb.r + dr[d];
				int nc = rgb.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || visited[nr][nc] || map[nr][nc] != rgb.data)
					continue;
				visited[nr][nc] = true;
				que.add(new RGB(rgb.data, nr, nc));
			}
		}
		cnt++;
		return;
	}
}
