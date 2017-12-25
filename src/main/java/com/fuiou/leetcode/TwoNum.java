package com.fuiou.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoNum {

	public int[] twoSumOn2(int[] nums, int target) {
		int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
        		if(nums[i]+nums[j] == target){
        			System.out.println(i);
        			System.out.println(j);
        			return new int[]{i,j};
        		}
			}
				
		}
        return result;
    }
	
	public int[] twoSumOn(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer index = map.get(target-nums[i]);
			if(index != null){
				System.out.println(i);
				System.out.println(index);
				return new int[]{i,index};
			}else{
				map.put(nums[i], i);
			}
		}
		return new int[]{0,0};
    }
	public static void main(String[] args) {
		TwoNum tn = new TwoNum();
		tn.twoSumOn2(new int[]{2, 7, 11, 15},17);	
		tn.twoSumOn(new int[]{2, 7, 11, 15},17);	
		
	}
}
