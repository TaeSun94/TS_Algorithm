import java.util.*;
public class 좋은구간 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] input = new int[L];
		for(int i = 0; i < L; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		int n = sc.nextInt();
		int left = 0;
		int right = Integer.MAX_VALUE;
		boolean check = false;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > n) {
				right = Math.min(right, input[i]);
			}
			else if(input[i] < n) {
				left= Math.max(left, input[i]);
			}
			else {
				check = true;
				break;
			}
		}
		int l = n-left-1;
		int r = right-n-1;
		if(check) {
			System.out.println(0);
		}
		else {
			System.out.println(l+r+(l*r));
		}
	}
}
