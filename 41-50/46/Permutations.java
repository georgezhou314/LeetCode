package com.company;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void swap(int[]nums,int i,int j)
    {
        int temp=nums[i];   nums[i]=nums[j];    nums[j]=temp;
    }
    private void find(List<List<Integer>>res,int[] nums,int i){
        if(i==nums.length){
            List<Integer> a=new ArrayList<>(nums.length);
            for(int tmp:nums)
                a.add(tmp);
            res.add(a);
            return;
        }
        for(int j=i;j<nums.length;j++){
            /*
             * 将数组中两元素交换，一前一后swap()抵消，交换带来的数组有序性影响
             * 例如数组[1,2,3]，交换之后为[1,3,2],[2,1,3]....
             * for循环的边界从i开始，而不是i+1，这样可以将swap()之前的数据保存起来，因为每一次都做一次无用的swap()
             */
            swap(nums,i,j);
            find(res,nums,i+1);
            swap(nums,i,j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        find(res,nums,0);
        return res;
    }
    public static void main(String[] args) {
        Permutations test=new Permutations();
        int []nums={1,2,3};
        List<List<Integer>> res = test.permute(nums);
        System.out.println(res.size());
        System.out.print(res);
    }
}
