package 쩜문제추천;
import java.util.*;
public class 최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				pq.add(num);
			}
		}
	}
}
