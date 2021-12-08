import java.util.*;
public class 수열 정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			list.add(A[i]);
		}
		Collections.sort(list);
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		for(int i = 0; i < list.size(); i++) {

			for(int j = 0; j < N; j++) {
				if(ans[j] != -1)
					continue;
				if(list.get(i)==A[j]) {
					ans[j] = i;
					break;
				}
			}
		}
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
	}
}
