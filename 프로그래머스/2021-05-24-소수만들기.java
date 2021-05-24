class Solution {
    static int[] result;
    static int ans;
    public int solution(int[] nums) {
        ans = 0;
        result = new int[3];
        comb(0,0,nums);
        int answer = ans;
        return answer;
    }
    public void comb(int idx, int s_idx, int[] nums){
        if(s_idx == result.length){
            boolean flag = false;
            int sum = 0;
            for(int i = 0; i < result.length; i++){
                sum += result[i];
            }
            for(int i = 2; i <= sum/2; i++){
                if(sum%i==0){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                ans++;
            return;
        }
        if(idx==nums.length)
            return;
        result[s_idx] = nums[idx];
        comb(idx+1, s_idx+1, nums);
        comb(idx+1, s_idx, nums);
    }
}
