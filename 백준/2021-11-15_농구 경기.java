import java.util.*;
import java.io.*;
public class 농구경기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[str.charAt(0)-'a']++;
		}
		boolean flag = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]>=5) {
				flag = true;
				bw.write((char)(i+'a'));
			}
		}
		if(!flag)
			bw.write("PREDAJA\n");
		bw.flush();
		bw.close();
	}
}
