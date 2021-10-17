package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 특정한최단경로 {
	static int ans = -1;
	static class Edge implements Comparable<Edge>{
		int to, weigth;

		public Edge(int to, int weigth) {
			super();
			this.to = to;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weigth-o.weigth;
		}

	}
	static ArrayList<Edge>[] adj;
	static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
		}
		st = new StringTokenizer(br.readLine()," ");
		int point1 = Integer.parseInt(st.nextToken());
		int point2 = Integer.parseInt(st.nextToken());
		int answer = solve(point1, point2);

		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int solve(int point1, int point2) {
		// TODO Auto-generated method stub
		int res1 = 0;
		int res2 = 0;
		res1 += dijstra(1,point1);
		res1 += dijstra(point1, point2);
		res1 += dijstra(point2, adj.length-1);

		res2 += dijstra(1,point2);
		res2 += dijstra(point2, point1);
		res2 += dijstra(point1, adj.length-1);
		if(res1 < 0)
			res1 = INF;
		if(res2 < 0)
			res2 = INF;
		if(res1 >= INF && res2 >= INF ) {
			return -1;
		}
		if(res1 < 0 && res2 >= 0) {
			return res2;
		}

		return Math.min(res1, res2);
	}
	private static int dijstra(int start, int end) {
		// TODO Auto-generated method stub
		int[] dist = new int[adj.length];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			for(Edge e : adj[edge.to]) {
				if(dist[e.to] > dist[edge.to]+e.weigth) {
					dist[e.to] = dist[edge.to] + e.weigth;
					pq.add(new Edge(e.to, dist[e.to]));
				}
			}
		}
		return dist[end];
	}
}
