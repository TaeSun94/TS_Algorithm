import java.util.*;
public class 이진수덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String A = sb.append(sc.next()).reverse().toString();
		sb = new StringBuilder();
		String B = sb.append(sc.next()).reverse().toString();
		int[] mem = new int[A.length() > B.length() ? A.length()+1:B.length()+1];
		if(A.length() < B.length()) {
			for(int i = 0; i < A.length(); i++) {
				mem[i] = A.charAt(i)-'0'+B.charAt(i)-'0';
			}
			for(int i = A.length(); i < B.length(); i++) {
				mem[i] = B.charAt(i)-'0';
			}
		}else if(A.length() > B.length()) {
			for(int i = 0; i < B.length(); i++) {
				mem[i] = A.charAt(i)-'0'+B.charAt(i)-'0';
			}
			for(int i = B.length(); i < A.length(); i++) {
				mem[i] = A.charAt(i)-'0';
			}
		}
		else {
			for(int i = 0; i < A.length(); i++) {
				mem[i] = A.charAt(i)-'0'+B.charAt(i)-'0';
			}
		}
		for(int i = 0; i < mem.length-1; i++) {
			if(mem[i] >= 2) {
				mem[i]-=2;
				mem[i+1]++;
			}
		}
		String ans = "";
		boolean flag = false;
		for(int i = mem.length-1; i >= 0; i--) {
			if(mem[i] == 0 && !flag)
				continue;
			if(mem[i] == 1) {
				flag = true;
			}
			ans += mem[i];
		}
		if(ans.length()>0)
			System.out.println(ans);
		else {
			System.out.println("0");
		}
	}
}
