package 프로그래머스;
import java.util.*;
public class 수식최대화 {
	static char[] op = {'+','-','*'};
	static int[] num;
	static long max;
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		max = 0;
		perm(0,expression);
		long answer = max;
		System.out.println(answer);
	}
	static void perm(int idx, String expression) {
		if(idx == op.length) {
			HashMap<String, Integer> inP = new HashMap<>();
			int priority = 0;
			for(int i = 0; i < op.length; i++) {
				inP.put(op[i]+"",priority++);
			}
			ArrayList<String> list = new ArrayList<>();
			String str = "";
			for(int i = 0; i < expression.length(); i++) {
				if(expression.charAt(i)-'0'>=0 &&expression.charAt(i)-'0'<=9) {
					str += expression.charAt(i);
				}
				else {
					list.add(str);
					list.add(expression.charAt(i)+"");
					str = "";
				}
			}
			list.add(str);
			Stack<String> stack = new Stack<>();
			ArrayList<String> al = new ArrayList<>();
			for(int i = 0; i < list.size(); i++) {
				if(!list.get(i).equals("+")&&!list.get(i).equals("-")&&!list.get(i).equals("*"))
					al.add(list.get(i));
				else {
					if(stack.isEmpty()) {
						stack.push(list.get(i));
					}
					else {
						while(true) {
							if(stack.isEmpty()) {
								stack.push(list.get(i));
								break;
							}
							String top = stack.peek();
							if(inP.get(top)>=inP.get(list.get(i))) {
								al.add(stack.pop());
							}
							else {
								stack.push(list.get(i));
								break;
							}
						}
					}
				}
			}
			while(!stack.isEmpty()) {
				al.add(stack.pop());
			}
			for(String op:inP.keySet()) {
				System.out.println(op+" "+inP.get(op));
			}
			for(int i = 0; i < al.size(); i++)
				System.out.print(al.get(i)+" ");
			System.out.println();
			long ans = 0;
			Stack<Long> numbers = new Stack<>();
			for(int i = 0; i < al.size(); i++) {
				if(!al.get(i).equals("+")&&!al.get(i).equals("-")&&!al.get(i).equals("*")) {
					numbers.push(Long.parseLong(al.get(i)));
				}
				else {
					long val1 = numbers.pop();
					long val2 = numbers.pop();
					System.out.println(val1+" "+val2);
					if(al.get(i).equals("+")) {
						val2 += val1;
						numbers.add(val2);
					}
					else if(al.get(i).equals("-")) {
						val2 -= val1;
						numbers.add(val2);
					}
					else {
						val2 *= val1;
						numbers.add(val2);
					}
					System.out.println("계산후 "+val2);
				}
			}
			ans = Math.abs(numbers.pop());
			if(ans > max) {
				max = ans;
			}
			return;
		}

		for(int i = idx; i < op.length; i++) {
			swap(idx,i);
			perm(idx+1,expression);
			swap(idx,i);
		}
	}

	private static void swap(int idx, int i) {
		// TODO Auto-generated method stub
		char tmp = op[idx];
		op[idx] = op[i];
		op[i] = tmp;
	}
}


/*
로직: +,-,*에 대한 우선순위를 순열을 통하여 정한다음 각 결과에 맞게 중위표기식을 후위표기식으로 변환한 뒤 후기표기식 계산을 통하여 MAX값을 도출
*/
