package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 연구소 {
	static int max;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Virus> que;
	static class Virus{
		int r,c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = 0;
		que = new LinkedList<>();
		//init map
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					que.add(new Virus(i,j));
			}
		}
		visited = new boolean[N][M];

		//3개 선택하여 벽 세우기
		dfs(0,0,0);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int r, int c, int count) {
		// TODO Auto-generated method stub
		if(count == 3) {
			//바이러스 퍼뜨리기
			int[][] copyMap = new int[map.length][map[0].length];
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(visited[i][j] && map[i][j]==0) {
						copyMap[i][j] = 1;
						continue;
					}
					copyMap[i][j] = map[i][j];
				}
			}
			//너비 순환을 이용하여 바이러스를 퍼트리기
			bfs(copyMap);
			return;
		}
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(!visited[i][j] && map[i][j]==0) {
					visited[i][j] = true;
					dfs(i,j,count+1);
					visited[i][j] = false;
				}
			}
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	private static void bfs(int[][] copyMap) {
		// TODO Auto-generated method stub
		Queue<Virus> tmpQue = new LinkedList<>();
		boolean[][] check = new boolean[copyMap.length][copyMap[0].length];
		for(int i = 0; i < que.size(); i++) {
			Virus virus = que.poll();
			check[virus.r][virus.c] = true;
			tmpQue.add(new Virus(virus.r,virus.c));
			que.add(virus);
		}
		while(!tmpQue.isEmpty()) {
			Virus v = tmpQue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = v.r + dr[d];
				int nc = v.c + dc[d];
				if(nr < 0 || nc < 0 || nr >=copyMap.length || nc >=copyMap[nr].length || check[nr][nc] || copyMap[nr][nc] != 0)
					continue;
				check[nr][nc] = true;
				copyMap[nr][nc] = 2;
				tmpQue.add(new Virus(nr,nc));
			}
		}
		//안전영역 갯수 count
		max = Math.max(max, countArea(copyMap));
		return;
	}
	private static int countArea(int[][] copyMap) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < copyMap.length; i++) {
			for(int j = 0; j < copyMap[i].length; j++) {
				if(copyMap[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
