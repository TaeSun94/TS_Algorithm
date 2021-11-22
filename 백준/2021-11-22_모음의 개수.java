import java.util.*;
import java.io.*;
public class 모음의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String input = br.readLine().toLowerCase();
			int ans = 0;
			if(input.equals("#"))
				break;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i)=='a'||input.charAt(i)=='e'||input.charAt(i)=='i'||input.charAt(i)=='o'||input.charAt(i)=='u') {
					ans++;
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
	}
}
