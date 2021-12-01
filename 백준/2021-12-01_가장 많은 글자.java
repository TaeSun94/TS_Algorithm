import java.util.*;
public class 가장많은글자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mem = new int[26];
		while(sc.hasNextLine()) {
			String input = sc.nextLine();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i)==' ')
					continue;
				mem[input.charAt(i)-'a']++;
			}
		}
		int max = 0;
		String ans = "";
		for(int i = 0; i < mem.length; i++) {
			if(max < mem[i]) {
				ans = (char)('a'+i)+"";
				max = mem[i];
			}
			else if(max == mem[i]) {
				ans += (char)('a'+i);
			}
		}
		System.out.println(ans);
	}
}
