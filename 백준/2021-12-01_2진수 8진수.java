import java.util.*;
public class 이진수팔진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int cnt = 2;
		int num = 0;
		for(int i = input.length()-1; i >= 0 ; i--) {
			if(cnt < 0) {
				cnt = 2;
				sb.append(num);
				num = 0;
			}
			if(input.charAt(i)=='1') {
				num += Math.pow(2, 2-cnt);
			}
			cnt--;
		}
		sb.append(num);
		System.out.println(sb.reverse().toString());
	}
}
