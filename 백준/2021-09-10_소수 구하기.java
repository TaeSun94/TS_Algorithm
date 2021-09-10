package 쩜문제추천;
import java.util.*;
public class 소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] primeNum = new boolean[N+1];
		primeNum[0] = primeNum[1] = true;
		for(int i = 2; i*i <= N; i++) {
			for(int j = i*i; j <= N; j+=i) {
				primeNum[j] = true;
			}
		}
		for(int i = M; i <= N; i++) {
			if(!primeNum[i]) {
				System.out.println(i);
			}
		}
	}
}
