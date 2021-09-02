package 쩜문제추천;
import java.util.*;
public class 요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		int k = 0;
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(!que.isEmpty()) {
			int num = que.poll();
			k++;
			if(k == K) {
				if(que.isEmpty()) {
					sb.append(num+">");
				}
				else {
					sb.append(num+", ");
				}
				k=0;
				continue;
			}
			que.add(num);
		}
		System.out.println(sb.toString());
	}
}
