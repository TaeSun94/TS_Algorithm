package 홍익대;
import java.util.*;
import java.io.*;
public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		char[][] board = new char[5][str.length()];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
			}
			if(i != 4)
				str = br.readLine();
		}

		String ready = ".omln";
		String ing = "owln.";
		char[][] ans = new char[5][str.length()];
		for(int i = 0; i < board[0].length; i++) {
			String now = "";
			for(int j = 0; j < 5; j++) {
				now += board[j][i];
			}
			if(now.equals(ready)) {
				now = ing;
			}
			else if(now.equals(ing)) {
				now = ready;
			}

			for(int j = 0; j < 5; j++) {
				ans[j][i] = now.charAt(j);
			}
		}

		for(int i = 0; i < 5; i++) {
			String answer = "";
			for(int j = 0; j < board[i].length; j++) {
				answer += ans[i][j];
			}
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
	}
}
