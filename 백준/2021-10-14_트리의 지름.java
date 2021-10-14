package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 트리의지름2 {
	static class Node{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

	}
	static ArrayList<Node>[] adj;
//	static ArrayList<Node>[] revAdj;
	static int max, pos;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		if(N == 1) {
			System.out.println(0);
			return;
		}
		adj = new ArrayList[N+1];
//		revAdj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
//			revAdj[i] = new ArrayList<>();
		}
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(e,w));
			adj[e].add(new Node(s,w));
		}
		max = 0;
		pos = 0;
		check = new boolean[N+1];
		check[1] = true;
		dfs(1,0);
		check = new boolean[N+1];
		check[pos] = true;
		dfs(pos,0);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int num, int sum) {
		// TODO Auto-generated method stub
		if(max < sum) {
			max = sum;
			pos = num;
		}
		for(Node n : adj[num]) {
			if(!check[n.to]) {
				check[n.to] = true;
				dfs(n.to, sum+n.weight);
			}
		}
		return;
	}
}
