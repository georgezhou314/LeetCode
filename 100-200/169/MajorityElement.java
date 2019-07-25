package com.company;
/**
 * @Time 2019-07-25 20:23
 * 算法的核心思想是，已知给定的数组中，众数会超过n+1
 * 那么如果nums[i]==tmp,则+1，如果nums[i]!=tmp,则-1
 * 减到零为止，切换tmp
 * 为什么该算法一定能找到众数呢?原因是因为众数>n/2
 * 所以count(众数)-count(the others)>=1
 * 所以最终剩下的必然是众数
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count=1;
        int tmp=nums[0];
        for(int i=1,len=nums.length;i<len;i++){
            if(nums[i]==tmp)
                count++;
            else{
                count--;
                if(count==0){
                    tmp=nums[i];
                    count=1;
                }
            }
        }
        return tmp;
    }
    public static void main(String[] args) {
	// write your code here
        int []nums={3,2,3};
        MajorityElement test=new MajorityElement();
        int major = test.majorityElement(nums);
        System.out.println(major);
        int []nums2={2,2,1,1,1,2,2};
        int majority = test.majorityElement(nums2);
        System.out.println(majority);
        int []nums3={1};
        int majority3 = test.majorityElement(nums3);
        System.out.println(majority3);
    }
}
