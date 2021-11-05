package 홍익대;
import java.util.*;
import java.io.*;
public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] choco = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			choco[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(choco);
		int count = 0;
		int day = 0;
		int tmp = choco[0];
		for(int i = 0; i < choco.length; i++) {
			if(tmp == choco[i])
				continue;
			count += choco[i]-tmp;
			day++;
		}
		bw.write(count+" "+day);
		bw.flush();
		bw.close();
	}
}
