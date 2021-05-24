import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> inputs = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(!inputs.contains(nums[i]))
                inputs.add(nums[i]);
        }
        if(inputs.size() <= nums.length/2){
            answer = inputs.size();
        }
        else{
            answer = nums.length/2;
        }
        return answer;
    }
}
