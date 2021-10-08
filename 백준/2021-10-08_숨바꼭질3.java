package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 숨바꼭질3 {
	static int N,K,answer;
	static class Node implements Comparable<Node>{
		int pos,cnt;

		public Node(int pos, int cnt) {
			super();
			this.pos = pos;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		bfs();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[100001];
		pq.add(new Node(N,0));

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			check[n.pos] = true;
			if(n.pos == K) {
				answer = Math.min(answer, n.cnt);
				continue;
			}
			if(n.pos*2 <= 100000 && !check[n.pos*2]) {
				pq.add(new Node(n.pos*2, n.cnt));
			}
			if(n.pos+1 <= 100000 && !check[n.pos+1]) {
				pq.add(new Node(n.pos+1, n.cnt+1));
			}
			if(n.pos-1 >= 0 && !check[n.pos-1]) {
				pq.add(new Node(n.pos-1, n.cnt+1));
			}
		}
	}
}
