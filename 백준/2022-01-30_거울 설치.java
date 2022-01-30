import java.util.*;
import java.io.*;

public class 거울설치 {
	static char[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[][][] visited;
	static int s_r = -1, s_c = -1, e_r = -1,e_c =-1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '#') {
					if(s_r == -1) {
						s_r = i;
						s_c = j;
					}
					else {
						e_r = i;
						e_c = j;
					}
				}
			}
		}
		visited = new boolean[N][N][4];
		bfs();

	}

	static class Node implements Comparable<Node> {
		int r, c, d, count;

		public Node(int r, int c, int d, int count) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}

	}

	private static void bfs() {
		// TODO Auto-generated method stub

		PriorityQueue<Node> que = new PriorityQueue<>();
		for (int d = 0; d < 4; d++) {
			que.add(new Node(s_r, s_c, d, 0));
			visited[s_r][s_c][d] = true;
		}
		while (!que.isEmpty()) {
			Node n = que.poll();
			if (map[n.r][n.c] == '#' && e_r == n.r && e_c == n.c) {
				System.out.println(n.count);
				return;
			}
			int nr = n.r + dr[n.d];
			int nc = n.c + dc[n.d];
			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || visited[nr][nc][n.d] || map[nr][nc] == '*')
				continue;
			visited[nr][nc][n.d] = true;
			if (map[nr][nc] == '!') {
				if (n.d < 2) {
					for (int d = 2; d < 4; d++) {
						visited[nr][nc][d] = true;
						que.add(new Node(nr, nc, d, n.count + 1));
					}
				} else {
					for (int d = 0; d < 2; d++) {
						visited[nr][nc][d] = true;
						que.add(new Node(nr, nc, d, n.count + 1));
					}
				}
			}
			que.add(new Node(nr,nc,n.d,n.count));
		}
	}
}
