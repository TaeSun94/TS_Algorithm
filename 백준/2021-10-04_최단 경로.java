package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 최단경로 {
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
	static ArrayList<Edge>[] edges;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		edges = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v,w));
		}

		dist[start] = 0;
		dijstra(start);
		for(int i = 1; i <= V; i++) {
			if(dist[i] != Integer.MAX_VALUE)
				bw.write(dist[i]+"\n");
			else
				bw.write("INF\n");
		}
		bw.flush();
		bw.close();
	}
	private static void dijstra(int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(dist[e.to] < e.cost)
				continue;
			for(Edge edge: edges[e.to]) {
				if(dist[edge.to] > dist[e.to]+edge.cost) {
					dist[edge.to] = dist[e.to]+edge.cost;
					pq.add(new Edge(edge.to,dist[edge.to]));
				}
			}
		}
	}
}
