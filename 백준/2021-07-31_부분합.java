import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int Lpos = 0;
		int Rpos = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(true) {
			if(sum >= S) {
				sum -= arr[Lpos++];
				min = Math.min(Rpos-Lpos+1, min);
			}
			else if(Rpos == arr.length)
				break;
			else
				sum += arr[Rpos++];
		}
        if(min == Integer.MAX_VALUE) {
	        bw.write(0+"\n");
		}
        else{
    		bw.write(min+"\n");
        }
		bw.flush();
		bw.close();
	}
}
