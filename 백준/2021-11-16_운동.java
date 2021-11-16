import java.util.*;
import java.io.*;
public class 운동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int answer = 0;
		int purse = m;
		while(true) {
			if(N == 0) {
				break;
			}
			if(purse+T <= M) {
				purse += T;
				N--;
			}
			else {
				if(purse-R >= m) {
					purse -= R;
				}
				else {
					purse = m;
				}
			}
			answer++;
			if(purse+T > M && purse == m) {
				answer = -1;
				break;
			}
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
