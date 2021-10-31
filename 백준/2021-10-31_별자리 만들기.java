package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 별자리만들기 {
	static class Edge implements Comparable<Edge>{
		int start, end;
		double cost;
		public Edge(int start, int end, double cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
	static class Point{
		double x,y;
		int num;
		public Point(int num,double x, double y) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Point> list = new ArrayList<>();
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine()," ");
			list.add(new Point(i,Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i < list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				double cost = distance(list.get(i),list.get(j));
				pq.add(new Edge(i,j,cost));
			}
		}
		double ans = 0.0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(!isConnect(edge.start,edge.end)) {
				ans += edge.cost;
				union(edge.start,edge.end);
			}
		}
		bw.write(Math.round(ans*100)/100.0+"");
		bw.flush();
		bw.close();
	}
	private static boolean isConnect(int start, int end) {
		// TODO Auto-generated method stub
		return find(start) == find(end) ? true: false;
	}
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}
	private static double distance(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
	}
}
