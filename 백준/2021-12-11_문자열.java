import java.util.*;
public class 문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int ans = A.length();

		for(int i = 0; i < B.length()-A.length()+1; i++) {
			int min = 0;
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(j+i)) {
					min++;
				}
			}
			ans = Math.min(ans, min);
		}
		System.out.println(ans);
	}
}
