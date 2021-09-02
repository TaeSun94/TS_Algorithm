package 쩜문제추천;
import java.util.*;
public class 이항계수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int child = 1;
		int parent = 1;
		for(int i = 1; i <= K; i++) {
			child *= (N-i+1);
			parent *= i;
		}
		System.out.println(child/parent);
	}
}
