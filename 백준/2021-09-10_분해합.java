package 쩜문제추천;
import java.util.*;
public class 분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for(int i = 1; i < N; i++) {
			int number = i;
			int sum = 0;
			while(number != 0) {
				sum += number%10;
				number /= 10;
			}
			if(sum+i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
