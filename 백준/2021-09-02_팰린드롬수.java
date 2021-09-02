package 쩜문제추천;
import java.util.*;
public class 팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.next();
			if(str.equals("0")) {
				break;
			}
			StringBuilder sb = new StringBuilder();
			String tmp = sb.append(str).reverse().toString();
			if(str.equals(tmp)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
