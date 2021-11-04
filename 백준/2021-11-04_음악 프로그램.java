package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 음악프로그램 {
//	static ArrayList<Integer>[] adj;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//가수 숫자
		int N = Integer.parseInt(st.nextToken());
		//간선 숫자
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		indegree = new int[N+1];
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			String[] split = br.readLine().split(" ");
			int now = Integer.parseInt(split[1]);
			for(int j = 2; j < split.length; j++) {
				indegree[Integer.parseInt(split[j])]++;
				adj.get(now).add(Integer.parseInt(split[j]));
				now = Integer.parseInt(split[j]);
			}
		}

		Queue<Integer> que = new LinkedList<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			res.add(now);
			for(int next: adj.get(now)) {
				indegree[next]--;
				if(indegree[next]==0) {
					que.add(next);
				}
			}
		}
		if(res.size()!= N) {
			bw.write("0\n");
		}
		else {
			for(int num: res) {
				bw.write(num+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
