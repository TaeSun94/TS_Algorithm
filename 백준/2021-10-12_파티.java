package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 파티 {
	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] adj = new ArrayList[N+1];
		ArrayList<Edge>[] revAdj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			revAdj[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(to,cost));
			revAdj[to].add(new Edge(s,cost));
		}
		int[] dist = dijstra(X, adj);
		int[] revDist = dijstra(X,revAdj);
		int answer = 0;
		for(int i = 1; i < dist.length; i++) {
			if(i==X)
				continue;
			answer = Math.max(answer, dist[i]+revDist[i]);
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int[] dijstra(int x, ArrayList<Edge>[] adj) {
		// TODO Auto-generated method stub
		int[] dist = new int[adj.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[x] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(x,0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			for(Edge e: adj[edge.to]) {
				if(dist[e.to]==Integer.MAX_VALUE || dist[e.to] > dist[edge.to]+e.cost) {
					dist[e.to] = dist[edge.to] + e.cost;
					pq.add(e);
				}
			}
		}
		return dist;
	}
}
