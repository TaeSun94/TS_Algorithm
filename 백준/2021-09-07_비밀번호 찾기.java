package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> passwordTxt = new HashMap<>();
		for(int index = 0; index < N; index++) {
			String[] splitData = br.readLine().split(" ");
			passwordTxt.put(splitData[0], splitData[1]);
		}
		for(int index = 0; index < M; index++) {
			bw.write(passwordTxt.get(br.readLine())+"\n");
		}
		bw.flush();
		bw.close();
	}
}
