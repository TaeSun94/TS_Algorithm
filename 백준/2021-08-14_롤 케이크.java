package 쩜문제추천;

import java.util.*;

public class 롤케이크 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int ans = 0;

	public static void main(String[] args) {
		int arr[] = new int[N];
		int arr2[] = new int[N];
		int idx = 0;

		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for(int i=0; i<N; i++) {
			if(arr[i] == 10) ans++;
			else if(arr[i] > 10) {
				 if(arr[i] % 10 == 0)
					 cut(arr[i]);
				 else arr2[idx++] = arr[i];
			}
		}

		if(M > 0)
			for(int i=0; i<idx; i++) cut(arr2[i]);

		System.out.println(ans);
	}

	private static void cut(int len) {
		if(M <= 0) return;
		else {
			ans++;
			M--;
			int length = len - 10;
			if(length > 10) {
				cut(length);
			}
			else {
				if(length == 10) ans++;
				return;
			}
		}
	}
}
