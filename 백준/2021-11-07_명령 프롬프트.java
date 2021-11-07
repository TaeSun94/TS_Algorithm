import java.util.*;
import java.io.*;
public class 명령프롬프트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		String ans = "";
		for(int i = 0; i < list.get(0).length(); i++) {
			char c = list.get(0).charAt(i);
			boolean flag = false;
			for(int j = 1; j < list.size(); j++) {
				if(list.get(j).charAt(i) != c) {
					flag = true;
					break;
				}
			}
			if(flag)
				ans += '?';
			else
				ans += c;
		}
		bw.write(ans);
		bw.flush();
		bw.close();
	}
}
