import java.util.*;
public class 적어도대부분의배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[5];
		int ans = 1;
		for(int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		while(true) {
			int cnt = 0;
			for(int i = 0; i < input.length; i++) {
				if(ans%input[i]==0)
					cnt++;
			}
			if(cnt >= 3)
				break;
			ans++;
		}
		System.out.println(ans);
	}
}
