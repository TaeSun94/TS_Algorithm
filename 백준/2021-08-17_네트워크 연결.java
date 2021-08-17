package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 네트워크연결 {
	static class Edge implements Comparable<Edge>{
		int a,b, weight;

		public Edge(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a,b,cost));
		}
		parents = new int[N+1];
		for(int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		int answer = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int a = find(edge.a);
			int b = find(edge.b);
			if(a==b)
				continue;
			answer+=edge.weight;
			union(a,b);
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	public static int find(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	public static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra == rb)
			return;
		parents[ra] = rb;
	}
}
