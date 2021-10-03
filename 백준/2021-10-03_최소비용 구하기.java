package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 최소비용구하기 {
	static class Edge implements Comparable<Edge>{
		int to, fee;

		public Edge(int to, int fee) {
			super();
			this.to = to;
			this.fee = fee;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.fee-o.fee;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", fee=" + fee + "]";
		}

	}
	static ArrayList<ArrayList<Edge>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			list.get(from).add(new Edge(to,fee));
		}
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		bw.write(dijkstra(start,end)+"");
		bw.flush();
		bw.close();
	}
	private static int dijkstra(int start, int end) {
		// TODO Auto-generated method stub
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[list.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Edge(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(dist[e.to] < e.fee)
				continue;
			for(int i = 0; i < list.get(e.to).size(); i++) {
				if(dist[list.get(e.to).get(i).to] > dist[e.to]+list.get(e.to).get(i).fee) {
					dist[list.get(e.to).get(i).to] = dist[e.to]+list.get(e.to).get(i).fee;
					pq.add(new Edge(list.get(e.to).get(i).to,dist[list.get(e.to).get(i).to]));
				}
			}
		}
		return dist[end];
	}
}
