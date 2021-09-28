package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 좌표압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] tmp = arr.clone();
		Arrays.sort(arr);
		HashMap<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],cnt++);
			}
		}
		for(int i = 0; i < tmp.length; i++) {
			bw.write(map.get(tmp[i])+" ");
		}
		bw.flush();
		bw.close();
	}
}
