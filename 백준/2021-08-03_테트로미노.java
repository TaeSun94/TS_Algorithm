package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int[][] paper;
	static int max;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		//init paper
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,1,paper[i][j]);
				visited[i][j] = false;
			}
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void dfs(int r, int c, int count, int sum) {
		// TODO Auto-generated method stub
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0||nc < 0 || nr >= paper.length || nc >= paper[nr].length)
				continue;
			if(visited[nr][nc])
				continue;
			visited[nr][nc] = true;
			dfs(nr,nc,count+1,sum+paper[nr][nc]);
			if(count == 2) {
				for(int k = 0; k < 4; k++) {
					int kr = r + dr[k];
					int kc = c + dc[k];
					if(kr < 0 || kc < 0 || kr >= paper.length || kc >= paper[kr].length || visited[kr][kc])
						continue;
					visited[kr][kc] = true;
					dfs(kr,kc,count+2, sum+paper[nr][nc]+paper[kr][kc]);
					visited[kr][kc] = false;
				}
			}
			visited[nr][nc] = false;
		}
	}
}
