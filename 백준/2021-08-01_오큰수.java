/*
결과 : 시간초과
Frist Try -> 배열을 통한 가장 가까운 큰 수 찾기 방법 -> O(N^2) 시간복잡도
*/
package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			boolean flag = false;
			for(int j = i+1; j < N; j++) {
				if(arr[i]< arr[j]) {
					bw.write(arr[j]+" ");
					flag = true;
					break;
				}
			}
			if(!flag) {
				bw.write(-1+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}

/*
결과 : 시간초과
Second Try -> 2개의 스택을 이용하여 인풋 데이터와 큰 수를 저장하는 스택을 기준으로 작거나 같으면 저장 스택 pop 아니라면 peek값을 넣어주고 해당 저장 스택에 push
*/
package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}
		Stack<Integer> tmpStack = new Stack<>();
		while(!stack.isEmpty()) {
			int num = stack.pop();
			if(tmpStack.isEmpty()) {
				sb.insert(0, -1+" ");
				tmpStack.push(num);
			}
			else {
				while(true) {
					if(tmpStack.isEmpty()) {
						sb.insert(0, -1+" ");
						tmpStack.push(num);
						break;
					}
					if(tmpStack.peek() <= num) {
						tmpStack.pop();
					}
					else {
						sb.insert(0, tmpStack.peek()+" ");
						tmpStack.push(num);
						break;
					}
				}
			}
		}
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
/*
결과 : 통과
Third Try -> 인풋값을 처음부터 반복문을 돌며 index값을 저장한 뒤 스택에 저장하여 해당 인덱스에 인풋값을 바꿔주는 형식
*/
package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else {
				if(numbers[stack.peek()] > numbers[i]) {
					stack.push(i);
				}
				else {
					while(!stack.isEmpty()&&numbers[stack.peek()]<numbers[i]) {
						numbers[stack.pop()] = numbers[i];
					}
					stack.push(i);
				}
			}
		}
		while(!stack.isEmpty()) {
			numbers[stack.pop()] = -1;
		}
		for(int i = 0; i < numbers.length;i++) {
			bw.write(numbers[i]+" ");
		}
		bw.flush();
		bw.close();
	}
}
