import java.util.*;
import java.io.*;
public class 성곽 {
	static int[][] map, wall;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	static int[] dir = {1,2,4,8};
	static int max = 0;
	static HashMap<Integer,Integer> hm;
	static ArrayList<HashSet<Integer>> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		hm = new HashMap<Integer, Integer>();
		al = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		wall = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int room = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					al.add(new HashSet<>());
					bfs(i,j,room++);
				}
			}
		}
		System.out.println(room-1);
		System.out.println(max);
		int reSize = 0;
		for(int i = 0; i < al.size(); i++) {
			int num = hm.get(i+1);
			if(al.get(i).size() != 0) {
				for(int roomNum: al.get(i)) {
					reSize = Math.max(num+hm.get(roomNum), reSize);
				}
			}
		}
		System.out.println(reSize);
	}
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	private static void bfs(int i, int j, int room) {
		// TODO Auto-generated method stub
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(i,j));
		map[i][j] = room;
		int size = 0;
		while(!que.isEmpty()) {
			Node n = que.poll();
			size++;
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length)
					continue;
				if(map[nr][nc] != 0 && map[nr][nc] != room) {
					al.get(room-1).add(map[nr][nc]);
				}
				if((wall[n.r][n.c] & dir[d])==0 && map[nr][nc]==0) {
					map[nr][nc] = room;
					que.add(new Node(nr,nc));
				}
			}
		}
		hm.put(room,size);
		max = Math.max(max, size);
		return;
	}
}
