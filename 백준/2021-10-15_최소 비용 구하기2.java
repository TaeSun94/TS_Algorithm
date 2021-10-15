package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 최소비용구하기2 {
	static class Node implements Comparable<Node>{
		int to,weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}

	}
	static ArrayList<Node>[] adj;
	static int[] dist,parent;
	static int start,end,cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		dist = new int[n+1];
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(e,w));
		}
		st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijstra();
		Stack<Integer> stack = path();
//		System.out.println(Arrays.toString(parent));
		bw.write(dist[end]+"\n");
		bw.write(cnt+"\n");
		String str = "";
		while(!stack.isEmpty()) {
			int num = stack.pop();
			str += num+" ";
		}
		bw.write(str);
		bw.flush();
		bw.close();
	}
	private static Stack<Integer> path() {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		int now = end;
		while(now != start) {
			stack.push(now);
			cnt++;
			now = parent[now];
		}
		stack.push(now);
		cnt++;
		return stack;
	}
	private static void dijstra() {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[adj.length];
		pq.add(new Node(start,0));
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(check[node.to])
				continue;
			check[node.to] = true;
			for(Node n: adj[node.to]) {
				if(dist[n.to] > dist[node.to] + n.weight) {
					dist[n.to] = dist[node.to] + n.weight;
					pq.add(new Node(n.to, dist[n.to]));
					parent[n.to] = node.to;
				}
			}
		}
	}
}
