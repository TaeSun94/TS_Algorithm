import java.util.*;
import java.io.*;
public class 불켜기 {
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static boolean[][] visited, map;
	static ArrayList<Node>[][] lists;
	static class Node{
		int r,c;

		public Node(int r, int c) {
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
		visited = new boolean[N][N];
		map = new boolean[N][N];
		lists = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				lists[i][j] = new ArrayList<>();
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			lists[x][y].add(new Node(a,b));
		}
		int ans = bfs(0,0)+1;
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}


	private static int bfs(int r, int c) {
		// TODO Auto-generated method stub
		Queue<Node> que = new LinkedList<>();
		initVisited();
		visited[r][c] = true;
		que.add(new Node(r,c));
		boolean flag = false;
		map[r][c] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(Node n: lists[node.r][node.c]) {
				if(!map[n.r][n.c]) {
					map[n.r][n.c]= true;
					cnt++;
					flag = true;
				}
			}
			for(int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || visited[nr][nc] || !map[nr][nc])
					continue;
				que.add(new Node(nr,nc));
				visited[nr][nc] = true;
			}
		}
		if(flag) {
			cnt += bfs(0,0);
		}
		return cnt;
	}


	private static void initVisited() {
		// TODO Auto-generated method stub
		for(int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
