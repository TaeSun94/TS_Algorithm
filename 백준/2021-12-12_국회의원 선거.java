import java.util.*;
public class 국회의원 선거 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dasom = sc.nextInt();
		int[] input = new int[N-1];
		for(int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		int ans = 0;
		if(N==1) {
			System.out.println(0);
			return;
		}
		while(true) {
			Arrays.sort(input);
			boolean flag = true;
			if(dasom <= input[input.length-1]) {
				dasom++;
				input[input.length-1]--;
				ans++;
				flag = false;
			}
			if(flag) {
				break;
			}
		}
		System.out.println(ans);
	}
}
