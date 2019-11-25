package suanfa.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ybt
 * @date 2018-10-19
 */
public class arryandsum {

	/*
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	 * 
	 * 示例: 给定 nums = [2, 7, 11, 15], target = 9
	 * 
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 * 
	 * 思路 直接两两相加能否得出目标值，能则输出
	 * 
	 */
	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 }; 
		int target = 17;
		
		
	}
	
	public int[] arryandsum(int[] nums,int target) {
		for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
		return null;
	}
	
	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
