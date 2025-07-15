import java.util.*;
/*
 * 1 <= N <= 1000000
 * 1 <= Aj <= 1000000
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<Integer> al = new ArrayList<>();
		al.add(arr[0]);

		for (int i = 1; i < N; i++) {
			if (al.get(al.size()-1) < arr[i]) {
				al.add(arr[i]);
			} else {
				int low = 0;
				int high = al.size()-1;

				while (low < high) {
					int mid = (low + high) / 2;
					if(arr[i] > al.get(mid)) {
						low = mid + 1;
					} else {
						high = mid;
					}
				}
				al.set(low, arr[i]);
			}
		}

		System.out.println(al.size());
	}
}
