package 쩜문제추천;
import java.util.*;
public class 수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> list = new HashSet<>();
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			if(list.contains(sc.nextInt())) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}
}
