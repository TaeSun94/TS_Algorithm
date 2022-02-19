import java.util.*;
import java.io.*;
public class 트리와쿼리 {
	static int[] parent;
	static int[] size;
	static LinkedList<Integer>[] adjList;
	static LinkedList<Integer>[] subList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[N+1];
		subList = new LinkedList[N+1];
		parent = new int[N+1];
		size = new int[N+1];

		for(int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
			subList[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);
		}
		makeTree(R,-1);
		count(R);
		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			bw.write(size[q]+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void count(int now) {
		// TODO Auto-generated method stub
		size[now] = 1;
		for(int next: subList[now]) {
			count(next);
			size[now] += size[next];
		}
	}
	private static void makeTree(int now, int p) {
		// TODO Auto-generated method stub
		for(int next: adjList[now]) {
			if(next != p) {
				subList[now].add(next);
				parent[next] = now;
				makeTree(next,now);
			}
		}
	}
}
