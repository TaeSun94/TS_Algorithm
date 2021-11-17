import java.util.*;
public class 이상한곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		long ans = 0;
		if(A.equals("0") || B.equals("0")) {
			System.out.println(0);
			return;
		}
		for(int i = 0; i < A.length(); i++) {
			for(int j = 0; j < B.length(); j++) {
				ans += (A.charAt(i)-'0')*(B.charAt(j)-'0');
			}
		}
		System.out.println(ans);
	}
}
