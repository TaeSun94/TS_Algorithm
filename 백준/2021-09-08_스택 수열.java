package 쩜문제추천;
import java.util.*;
public class 스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		int N = sc.nextInt();
		for(int num = 1; num <= N; num++) {
			que.add(num);
		}
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int start = 0;
		while(N-->0) {
			int number = sc.nextInt();
			if(number > start) {
				for(int i = start+1; i <= number; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				start = number;
			}
			else if(stack.peek() != number) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb.toString());
	}
}
