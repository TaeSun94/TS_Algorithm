class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length;i++) {
	    	int skill_pos = 0;
	    	String tree = skill_trees[i];
	    	boolean flag = false;
	    	for(int j = 0; j < tree.length(); j++) {
	    		boolean flag2 = false;
	    		for(int k = skill_pos; k < skill.length(); k++) {
	    			if(tree.charAt(j)==skill.charAt(k)) {
	    				if(k != skill_pos) {
	    					flag2 = true;
	    					break;
	    				}
	    				skill_pos++;
	    				break;
	    			}
	    		}
	    		if(flag2) {
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if(!flag)
	    		answer++;
	    }
        return answer;
    }
}
