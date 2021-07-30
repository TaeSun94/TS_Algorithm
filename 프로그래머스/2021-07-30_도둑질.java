/*
정확성  테스트
테스트 1 〉	통과 (0.09ms, 53.2MB)
테스트 2 〉	통과 (0.21ms, 52.8MB)
테스트 3 〉	통과 (0.13ms, 52.9MB)
테스트 4 〉	통과 (0.04ms, 52.2MB)
테스트 5 〉	통과 (0.06ms, 52.9MB)
테스트 6 〉	통과 (0.15ms, 52.5MB)
테스트 7 〉	통과 (0.13ms, 51.7MB)
테스트 8 〉	통과 (0.09ms, 53.4MB)
테스트 9 〉	통과 (0.21ms, 55.9MB)
테스트 10 〉	통과 (0.07ms, 54.2MB)
효율성  테스트
테스트 1 〉	통과 (24.49ms, 103MB)
테스트 2 〉	통과 (21.83ms, 102MB)
테스트 3 〉	통과 (21.90ms, 102MB)
테스트 4 〉	통과 (24.52ms, 102MB)
테스트 5 〉	통과 (23.80ms, 99.5MB)
테스트 6 〉	통과 (22.25ms, 103MB)
테스트 7 〉	통과 (18.89ms, 76.5MB)
테스트 8 〉	통과 (21.85ms, 90.5MB)
테스트 9 〉	통과 (20.38ms, 94.6MB)
테스트 10 〉	통과 (22.16ms, 101MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
*/
class Solution {
    static int[] mem;
	static int[] mem2;
    public int solution(int[] money) {
        mem = new int[money.length-1];
		mem2 = new int[money.length];
		mem[0] = money[0];
		mem[1] = Math.max(mem[0], money[1]);
		for(int i = 2; i < mem.length; i++) {
			mem[i] = Math.max(mem[i-1],mem[i-2] + money[i]);
		}
		mem2[0] = 0;
		mem2[1] = money[1];
		for(int i = 2; i < mem2.length; i++) {
			mem2[i] = Math.max(mem2[i-1], mem2[i-2] + money[i]);
		}
		return Math.max(mem[mem.length-1], mem2[mem2.length-1]);
    }
}
