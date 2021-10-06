package 쩜문제추천;
import java.util.*;
import java.io.*;
public class LCS {
	static String str1;
	static String str2;
	static int[][] mem;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		mem = new int[str1.length()+1][str2.length()+1];
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					mem[i][j] = mem[i-1][j-1]+1;
				}
				else {
					mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
				}
			}
		}
		System.out.println(mem[str1.length()][str2.length()]);
	}
}
