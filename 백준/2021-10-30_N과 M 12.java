import java.util.*;
public class N과M {
	static int n,m;
	static int[] input;
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		input = new int[n];
		res = new int[m];
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);

		StringBuilder sb = new StringBuilder();
		go(0,0,sb);
		System.out.println(sb.toString());
	}
	private static void go(int idx, int s_idx, StringBuilder sb) {
		// TODO Auto-generated method stub
		if(s_idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		int num = 0;
		for(int i = idx; i < n; i++) {
			if(num == input[i])
				continue;
			res[s_idx] = input[i];
			go(i,s_idx+1,sb);
			num = input[i];
 		}
	}
}
