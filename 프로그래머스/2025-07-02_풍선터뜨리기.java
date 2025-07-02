class Solution {
    public int solution(int[] a) {
        int answer = 0;

        
        int[] leftMinArr = new int[a.length];
        int[] rightMinArr = new int[a.length];

        leftMinArr[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            leftMinArr[i] = Math.min(a[i], leftMinArr[i - 1]);
        }

        rightMinArr[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightMinArr[i] = Math.min(a[i], rightMinArr[i + 1]);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == leftMinArr[i] || a[i] == rightMinArr[i]){
                answer+=1;
            }
        }

        return answer;
    }

}
