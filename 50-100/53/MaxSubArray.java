public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int tmp=0;
        int sum=0;
        //前面累加<0，就丢弃
        for(int i=0;i<nums.length;i++){
            tmp += nums[i];
            if(tmp<0) tmp=0;
            sum=sum > tmp ? sum : tmp;
        }
        //整个数组全是非整数，捡一个最小的
        if(sum==0){
            sum=nums[0];
            for(int i=1;i<nums.length;i++)
                sum = sum>nums[i] ? sum : nums[i];
        }
        return sum;

    }
    public static void main(String[] args) {
        MaxSubArray test=new MaxSubArray();
        int []nums={-2,-1,-3};
        int sum = test.maxSubArray(nums);
        System.out.println(sum);
    }
}
