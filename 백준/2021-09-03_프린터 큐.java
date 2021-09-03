import java.util.*;
public class 프린터큐 {
	static class Doc{
		int number, priority;

		public Doc(int number, int priority) {
			super();
			this.number = number;
			this.priority = priority;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Doc> que = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int priority = sc.nextInt();
				que.add(new Doc(i, priority));
				pq.add(priority);
			}
			int cnt = 1;
			boolean flag = false;
			while(!pq.isEmpty()) {
				if(flag)
					break;
				int now = pq.poll();
				int size = que.size();
				for(int i = 0; i < size; i++) {
					Doc doc = que.poll();
					if(doc.priority==now) {
						if(M==doc.number) {
							System.out.println(cnt);
							flag = true;
							break;
						}
						cnt++;
						break;
					}
					que.add(doc);
				}
			}
		}
	}
}
