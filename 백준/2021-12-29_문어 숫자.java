import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 문어숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int sum = 0;
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('-');
		list.add('\\');
		list.add('(');
		list.add('@');
		list.add('?');
		list.add('>');
		list.add('&');
		list.add('%');
		while(true) {
			String input = br.readLine();
			if(input.equals("#")) {
				break;
			}
			for(int i = 0; i < input.length(); i++) {
				int now = -1;
				if(list.contains(input.charAt(i))) {
					now = list.indexOf(input.charAt(i));
				}

				sum += now*Math.pow(8, input.length()-1-cnt);
				cnt++;
			}
			System.out.println(sum);
			cnt = 0;
			sum = 0;
		}
	}
}
