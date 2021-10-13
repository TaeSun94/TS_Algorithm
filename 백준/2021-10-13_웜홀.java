package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 웜홀 {
	static class Road{
		int end,weight;

		public Road(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}
	static int[] dist;
	static int N,M,W;
	static ArrayList<Road>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dist = new int[N+1];
			adj = new ArrayList[N+1];
			for(int i = 0; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i = 0; i < M+W; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				if(i < M) {
					adj[s].add(new Road(e,w));
					adj[e].add(new Road(s,w));
				}
				else {
					adj[s].add(new Road(e,-w));
				}
			}
			bw.write(bellmanFord() ? "YES\n" : "NO\n");
		}
		bw.flush();
		bw.close();
	}
	static int INF = 987654321;
	private static boolean bellmanFord() {
		// TODO Auto-generated method stub
		Arrays.fill(dist,INF);
		dist[1] = 0;
		boolean flag = false;
		for(int i = 1; i < N; i++) {
			flag = false;
			for(int j = 1; j <= N; j++) {
				for(Road road: adj[j]) {
					if(dist[road.end] > dist[j]+road.weight) {
						dist[road.end] = dist[j]+road.weight;
						flag = true;
					}
				}
			}
			if(!flag)
				break;
		}
		if(flag) {
			for(int i = 1; i <= N; i++) {
				for(Road road : adj[i]) {
					if(dist[road.end] > dist[i]+road.weight)
						return true;
				}
			}
		}
		return false;
	}
}
