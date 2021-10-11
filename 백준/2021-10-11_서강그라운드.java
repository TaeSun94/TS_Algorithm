package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 서강그라운드 {
	static ArrayList<Edge>[] adj;
	static class Edge{
		int to, cost;
		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	static ArrayList<Integer> nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		nodes = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < n; i++) {
			nodes.add(Integer.parseInt(st.nextToken()));
		}
		int[][] dist = new int[n][n];
		for(int i = 0; i < dist.length; i++) {
			for(int j = 0; j < dist[i].length; j++) {
				if(i==j)
					continue;
				dist[i][j] = 1000;
			}
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken());
			dist[s][to] = l;
			dist[to][s] = l;
		}
		for(int k = 0; k <dist.length; k++) {
			for(int i = 0; i < dist.length; i++) {
				for(int j = 0; j < dist.length; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
//		for(int[] d:dist)
//			System.out.println(Arrays.toString(d));
//		System.out.println();
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if(dist[i][j] <= m) {
					sum += nodes.get(j);
				}
			}
			answer = Math.max(answer, sum);
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
