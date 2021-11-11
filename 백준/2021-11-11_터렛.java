import java.util.*;
import java.io.*;
/*
원의 교점 갯수 구하기
 */
public class 터렛 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			double dist = Math.sqrt(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));
			if(dist == 0 && r1 == r2) {
				bw.write(-1+"\n");
			}
			else if(dist == r1+r2 || Math.abs(r1-r2)==dist) {
				bw.write(1+"\n");
			}
			else if(dist < r1+r2 && Math.abs(r1-r2)<dist) {
				bw.write(2+"\n");
			}
			else{
				bw.write(0+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
