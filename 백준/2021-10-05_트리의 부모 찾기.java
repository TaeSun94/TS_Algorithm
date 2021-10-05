package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 트리의부모찾기 {
	static int[] parents;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		parents = new int[N+1];

		for(int i = 0;i <N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			adj[num1].add(num2);
			adj[num2].add(num1);
		}
		dfs(N,1,0);
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(parents[i]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int n, int s, int parent) {
		// TODO Auto-generated method stub
		parents[s] = parent;
		for(int num: adj[s]) {
			if(num != parent)
				dfs(n,num,s);
		}
	}
}

/*
			1
		6		4
	3		7		2
5
4,6,1,3,1,4
 */
