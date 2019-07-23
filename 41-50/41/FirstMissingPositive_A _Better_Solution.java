package com.company;
public class Main {
    private void swap(int[]nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        //将n放在n-1的位置上,则为和谐的，从前往后依次放好
        //当从前往后扫描时，出现第一个nums[i]!=i+1的数，则为不和谐数，返回
        //[3,-1,2,4]放好为[1,2,3,4]
        for(int i=0;i<len;i++){
            //第三个条件防止[1,1]这样的数据，交换过的数据一直是重复的，陷入死循环
            while(nums[i]>0&&nums[i]<=len&& nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<len;i++)
            if(nums[i]!=i+1)
                return i+1;
        return len+1;
    }
    public static void main(String[] args) {

        Main main=new Main();
        int nums[]={1,1};
        int i = main.firstMissingPositive(nums);
        int nums2[]={3,4,-1,1};
        int j = main.firstMissingPositive(nums2);
        int nums3[]={7,8,9,11,12};
        int t = main.firstMissingPositive(nums3);
        System.out.println("i="+i+"j="+j+"t"+t);
    }
}
