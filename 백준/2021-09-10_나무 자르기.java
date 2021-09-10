package 쩜문제추천;
import java.util.*;
public class 나무자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		long max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			max = Math.max(trees[i], max);
		}
		long start = 0;
		long end = max;
		while(start <= end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int tree: trees) {
				if(tree>mid) {
					sum += tree-mid;
				}
			}
			if(sum >= M) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		System.out.println(end);
	}
}
