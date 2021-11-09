import java.util.*;
import java.io.*;
public class 하얀칸 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		for(int i = 0; i < 8; i++) {
			String str = br.readLine();
			if(i%2 == 0) {
				for(int j = 0; j < str.length(); j++) {
					if(j%2 == 0 && str.charAt(j)=='F') {
						ans++;
					}
				}
			}
			else {
				for(int j = 0; j < str.length(); j++) {
					if(j%2 == 1 && str.charAt(j)=='F') {
						ans++;
					}
				}
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
