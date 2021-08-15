package 쩜문제추천;
import java.util.*;
public class 줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] edges = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		int[] cnts = new int[N+1];
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			edges[A].add(B);
			cnts[B]++;
		}
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i < cnts.length; i++) {
			if(cnts[i]==0) {
				que.add(i);
			}
		}
		while(!que.isEmpty()) {
			System.out.println(que.peek());
			int next = que.poll();
			for(int i = 0; i < edges[next].size(); i++) {
				cnts[edges[next].get(i)]--;
				if(cnts[edges[next].get(i)]==0) {
					que.add(edges[next].get(i));
				}
			}
		}
	}
}
