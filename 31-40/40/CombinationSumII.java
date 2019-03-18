import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    int closestPosi(int[]candidates,int target,int right){
        int lo=0;
        int hi=right;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(candidates[mid]>target)
                hi=mid-1;
            else if(candidates[mid]<target)
                lo=mid+1;
            else
                return mid;
        }
        return hi;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates.length<1) return res;
        if(target<candidates[0]) return res;
        int curr=closestPosi(candidates,target,candidates.length-1);
        ArrayList<Integer> stack=new ArrayList<>();
        int sum=0;
        while (!(stack.size()==0&&curr==-1)) {
            if(curr!=-1){
                sum+=candidates[curr];
                //存储的是指针下标
                stack.add(curr);
            }
            if(sum==target){
                ArrayList<Integer>temp=new ArrayList<>();
                for(int i=0;i<stack.size();i++)
                    temp.add(candidates[stack.get(i)]);
                int j=0;
                /*去除重复项*/
                if(!res.contains(temp))
                    res.add(temp);
                int top=stack.remove(stack.size()-1);
                sum-=candidates[top];
                curr=closestPosi(candidates,target-sum,top-1);
            }
            else if(sum>target){
                int top=stack.remove(stack.size()-1);
                sum-=candidates[top];
                curr=closestPosi(candidates,target-sum,top-1);
            }
            else{
                if(curr==-1){
                    int  top=stack.remove(stack.size()-1);
                    sum-=candidates[top];
                    curr=closestPosi(candidates,target-sum,top-1);
                }
                else
                    curr=closestPosi(candidates,target-sum,curr-1);
            }
        }
        return res;
    }
    public static void main(String[]args){
        CombinationSumII test=new CombinationSumII();
        int candidates[]={4,4,2,1,4,2,2,1,3};
        int target=6;
        System.out.println(test.combinationSum2(candidates,target));
    }
}