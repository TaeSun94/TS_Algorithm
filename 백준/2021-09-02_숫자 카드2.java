package 쩜문제추천;
import java.util.*;
public class 숫자카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(map.containsKey(num)) {
				map.replace(num, map.get(num)+1);
			}
			else {
				map.put(num,1);
			}
		}
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			int key = sc.nextInt();
			if(map.containsKey(key)) {
				System.out.print(map.get(key)+" ");
			}
			else {
				System.out.print(0+" ");
			}
		}
	}
}
