/*
* 让数字和位置匹配,如果大于N,即不放入数字
* 从头到尾扫描一次数组,返回数组中的与该位置下标不相等的值
* */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int N=nums.length;
        int temp[]=new int[N];
        for(int i=0;i<N;i++){
            if(nums[i]<=N && nums[i]>0)
               temp[nums[i]-1]=nums[i];
        }
        int i;
        for(i=0;i<N;i++)
            if(temp[i]!=(i+1))
                break;
        return i+1;
    }
    public static void main(String[]args){
        FirstMissingPositive test=new FirstMissingPositive();
        int nums[]={7,8,9,11,12};
        System.out.println(test.firstMissingPositive(nums));
    }
}