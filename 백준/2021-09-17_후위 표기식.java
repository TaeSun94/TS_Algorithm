package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('(',0);
		map.put('+',1);
		map.put('-',1);
		map.put('*',2);
		map.put('/',2);
		Stack<Character> stack = new Stack<>();
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
				ans+=str.charAt(i);
				continue;
			}
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
				continue;
			}
			if(str.charAt(i)==')') {
				while(!stack.isEmpty()) {
					char c = stack.pop();
					if(c=='(') {
						break;
					}
					ans+=c;
				}
				continue;
			}
			while(!stack.isEmpty() && map.get(stack.peek())>= map.get(str.charAt(i))) {
				ans += stack.pop();
			}
			stack.push(str.charAt(i));
			System.out.println(ans);
		}
		while(!stack.isEmpty()) {
			ans+=stack.pop();
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
