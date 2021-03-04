package 프로그래머스;

public class 시저암호 {
	public static void main(String[] args) {
		String s = "z";
		int n = 1;
		String answer = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' ') {
				answer += " ";
				continue;
			}
			int tmp = s.charAt(i)+n;
			if(s.charAt(i)>= 'A' && s.charAt(i)<='Z') {
				if(tmp>'Z') {
					tmp -= 'Z'-'A'+1;
				}
			}
			else {
				if(tmp >'z') {
					tmp -= 'z'-'a'+1;
				}
			}
			answer += (char)tmp;
		}
		System.out.println(answer);
	}
}
