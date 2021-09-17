package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long num = pow(A,B,C);
		bw.write(num+"");
		bw.flush();
		bw.close();
	}

	private static long pow(long a, long b, long c) {
		// TODO Auto-generated method stub
		if(b==1) {
			return a%c;
		}
		long tmp = pow(a,b/2,c);
		if(b%2==1) {
			return (tmp*tmp%c)*a%c;
		}
		return tmp%c;
	}
}
