package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] command = br.readLine().split("-");
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < command.length; i++) {
			int tmp = 0;
			String[] add = command[i].split("\\+");
			for(int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}
			if(ans == Integer.MAX_VALUE) {
				ans = tmp;
			}else {
				ans -= tmp;
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
