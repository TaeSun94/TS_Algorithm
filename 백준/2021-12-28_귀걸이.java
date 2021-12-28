import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 귀걸이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			else
				num++;
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for(int i = 0; i < n*2-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int number = Integer.parseInt(st.nextToken());
				if(numbers.contains(number)) {
					numbers.remove((Integer)number);
				}
				else {
					numbers.add(number);
				}
			}
			int res = numbers.get(0);
			System.out.println(num+" "+list.get(res-1));
		}
	}
}
