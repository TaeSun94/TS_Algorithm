import java.util.*;
import java.io.*;
public class 책정리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] boxList = new int[N];
		int[] bookList = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			boxList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < M; i++) {
			bookList[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int boxP = 0;
		int bookP = 0;
		while(boxP < N && bookP < M) {
			if(boxList[boxP]-bookList[bookP] >= 0) {
				boxList[boxP]-= bookList[bookP];
				bookP++;
			}else {
				boxP++;
			}
		}
		for(int size: boxList) {
			ans += size;
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
