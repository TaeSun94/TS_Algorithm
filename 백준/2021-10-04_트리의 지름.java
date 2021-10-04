package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 트리의지름 {
	static class Node{
		int num, cost;

		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

	}
	static ArrayList<Node>[] list;
	static boolean[] check;
	static int max = 0;
	static int node = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e == -1)
					break;
				int cost = Integer.parseInt(st.nextToken());
				list[v].add(new Node(e,cost));
			}
		}
		check = new boolean[V+1];
		dfs(1,0);
		check = new boolean[V+1];
		dfs(node,0);

		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int num, int sum) {
		// TODO Auto-generated method stub
		if(max < sum) {
			max = sum;
			node = num;
		}
		check[num] = true;
		for(Node n: list[num]) {
			if(!check[n.num]) {
				dfs(n.num,sum+n.cost);
			}
		}
	}
}
