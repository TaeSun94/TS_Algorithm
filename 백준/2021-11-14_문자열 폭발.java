import java.util.*;
import java.io.*;
public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String boomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= boomb.length()) {
				boolean flag = true;
				for(int j = 0; j < boomb.length(); j++) {
					if(stack.get(stack.size() - boomb.length()+j)!=boomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j = 0; j < boomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		if(stack.isEmpty()) {
			bw.write("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(char c: stack)
				sb.append(c);
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
