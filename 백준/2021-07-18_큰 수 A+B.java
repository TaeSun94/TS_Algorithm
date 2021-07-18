package 단계8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 큰수A더하기B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer(st.nextToken());
		String str1 = sb.reverse().toString();
		sb = new StringBuffer(st.nextToken());
		String str2 = sb.reverse().toString();
		sb = new StringBuffer();
		boolean flag = false;
		if(str1.length()> str2.length()) {
			for(int i = 0; i < str2.length(); i++) {
				int num = str1.charAt(i)-'0' + str2.charAt(i)-'0';
				if(flag) {
					num++;
					flag = false;
				}
				if(num >= 10) {
					flag = true;
				}
				sb.append(num%10);
			}
			for(int i = str2.length(); i < str1.length(); i++) {
				int num = str1.charAt(i)-'0';
				if(flag) {
					num++;
					flag = false;
				}
				if(num >= 10) {
					flag = true;
				}
				sb.append(num%10);
			}
			if(flag) {
				sb.append(1);
			}
		}
		else {
			for(int i = 0; i < str1.length(); i++) {
				int num = str1.charAt(i)-'0' + str2.charAt(i)-'0';
				if(flag) {
					num++;
					flag = false;
				}
				if(num >= 10) {
					flag = true;
				}
				sb.append(num%10);
			}
			for(int i = str1.length(); i < str2.length(); i++) {
				int num = str2.charAt(i)-'0';
				if(flag) {
					num++;
					flag = false;
				}
				if(num >= 10) {
					flag = true;
				}
				sb.append(num%10);
			}
			if(flag) {
				sb.append(1);
			}
		}
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
	}
}
