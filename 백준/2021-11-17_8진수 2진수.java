import java.util.*;
import java.io.*;
public class 팔진수이진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			String binary = Integer.toBinaryString(str.charAt(i)-'0');
			if(i == 0) {
				bw.write(binary);
				continue;
			}
			while(binary.length() != 3) {
				binary = "0"+binary;
			}
			bw.write(binary);
		}
		bw.flush();
		bw.close();
	}
}
