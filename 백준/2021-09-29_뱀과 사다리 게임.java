package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 뱀과사다리게임 {
	static class Node{
		int data, cnt;

		public Node(int data, int cnt) {
			super();
			this.data = data;
			this.cnt = cnt;
		}

	}
	static int ans = 0;
	static HashMap<Integer, Integer> slide;
	static HashMap<Integer, Integer> snake;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		slide = new LinkedHashMap<Integer, Integer>();
		snake = new LinkedHashMap<Integer, Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			slide.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			snake.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		bfs(new Node(1,0));
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	private static void bfs(Node node) {
		// TODO Auto-generated method stub
		Queue<Node> que = new LinkedList<>();
		boolean[] visited = new boolean[101];
		visited[node.data] = true;
		que.add(node);
		while(!que.isEmpty()) {
			Node n = que.poll();
			if(n.data == 100) {
				ans = n.cnt;
				return;
			}
			if(slide.containsKey(n.data)) {
				n.data = slide.get(n.data);
			}
			if(snake.containsKey(n.data)) {
				n.data = snake.get(n.data);
			}
			for(int i = 1; i <= 6; i++) {
				if(n.data + i > 100 || visited[n.data+i])
					continue;
				visited[n.data+i] = true;
				que.add(new Node(n.data+i, n.cnt+1));
			}
		}
	}
}
