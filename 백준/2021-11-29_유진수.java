import java.util.*;
public class 유진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();

		long pre = 1;
		boolean flag = false;
		if(N.length() > 1) {
			for(int i = 0; i < N.length()-1; i++) {
				pre *= N.charAt(i)-'0';
				long post = 1;
				for(int j = i+1; j < N.length(); j++) {
					post *= N.charAt(j)-'0';
				}
				if(pre == post) {
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
