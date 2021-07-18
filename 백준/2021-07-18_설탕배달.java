package 단계8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 설탕배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int weight = Integer.parseInt(st.nextToken());
		int big = weight/5;
		int small = 0;
		weight %= 5;
		while(true) {
			if(weight == 0) {
				bw.write(big+small+"\n");
				break;
			}
			if(weight%3 == 0) {
				small = weight/3;
				weight %= 3;
				continue;
			}
			if(big <= 0) {
				bw.write(-1+"\n");
				break;
			}
			big--;
			weight+=5;
		}
		bw.flush();
		bw.close();
	}
}
