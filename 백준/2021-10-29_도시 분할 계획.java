package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 도시분할계획 {
	static int[] parent,rank;
	static PriorityQueue<Edge> list;
	static class Edge implements Comparable<Edge>{
		int s,e,w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		list = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			parent[i]=i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.offer(new Edge(s,e,w));
		}
		bw.write(kruskal(N)+"");
		bw.flush();
		bw.close();
	}
	public static int kruskal(int N) {
		int cost = 0;
		while(N>2) {
			Edge edge = list.poll();
			if(find(edge.s) != find(edge.e)) {
				cost += edge.w;
				N--;
				union(edge.s,edge.e);
			}
		}
		return cost;
	}
	public static int find(int num) {
		if(parent[num] == num) {
			return num;
		}
		return parent[num] = find(parent[num]);
	}
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if(pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
	}
}
