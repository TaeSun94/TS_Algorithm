import java.util.*;
public class 온라인판매 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] input = new int[M];
		for(int i = 0; i < M; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		int ans = 0;
		int max = 0;
		int price = 0;
		for(int i = 0; i < M; i++) {
			if(M-i<N) {
				ans = input[i]*(M-i);
			}
			else {
				ans = input[i]*N;
			}
			if(max < ans) {
				price = input[i];
				max = ans;
			}
		}
		System.out.println(price+" "+max);
	}
}
