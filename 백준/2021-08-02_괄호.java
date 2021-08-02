package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			if(check(str,stack)) {
				bw.write("YES\n");
			}
			else
				bw.write("NO\n");
		}
		bw.flush();
		bw.close();
	}

	private static boolean check(String str, Stack<Character> stack) {
		// TODO Auto-generated method stub
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
				continue;
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}
}
