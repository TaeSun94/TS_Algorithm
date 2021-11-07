import java.util.*;
import java.io.*;
public class 분산처리 {
	static HashSet<Integer> hs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hs = new HashSet<>();
			int num = go(a,b,1);
			if(num%10 == 0) {
				bw.write(10+"\n");
			}
			else {
				bw.write(num%10+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	private static int go(int a, int b, int num) {
		// TODO Auto-generated method stub
		if(b == 0) {
			return num;
		}
		num *= a;
		num %= 10;
		return go(a,b-1,num);
	}
}
