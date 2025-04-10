import java.util.*;

class Solution {
    static int[] res = new int[3];
    static int ans = 0;
    public int solution(int[] number) {
        comb(0,0,number);
        return ans;
    }
    
    static void comb(int idx, int s_idx, int[] nums) {
        if(s_idx == res.length) {
            int sum = 0;
            for(int i = 0; i < res.length; i++) {
                sum += res[i];
            }
            if(sum == 0) {
                ans++;
            }
            
            return;
        }
        if(idx == nums.length) {
			return;
		}

		res[s_idx] = nums[idx];
		comb(idx+1, s_idx+1, nums);
		comb(idx+1, s_idx, nums);
    }
}
