import java.util.*;
public class 회전하는큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList<Integer> dq = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			dq.add(i);
		}
		int answer = 0;
		for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int t = dq.indexOf(num);
			int pos = 0;
			if(dq.size() % 2 == 0) {
				pos = dq.size() / 2 - 1;
			}
			else {
				pos = dq.size() / 2;
			}

			if(t <= pos) {
				for(int j = 0; j < t; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					answer++;
				}
			}
			else {
				for(int j = 0; j < dq.size() - t; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					answer++;
				}

			}
			dq.pollFirst();
		}
		System.out.println(answer);
	}
}
