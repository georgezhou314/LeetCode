public class Solution {
    public int missingElement(int[] nums, int k) {
        if(nums.length==1){
            return nums[0]+k;
        }
        int temp=nums[0];
        int numsIndex=0;
        for(int i=0;i<k;){
            if(numsIndex>=nums.length){
                temp=temp+k-i;
                //System.out.println("break:"+temp);
                break;
            }
            if(temp==nums[numsIndex])
                numsIndex++;
            else{
                temp++;
                if(temp!=nums[numsIndex])
                i++;
            }
        }
        return temp;
    }
    public String smallestEquivalentString(String A, String B, String S) {
       int []nums=new int[26];
       for(int i=0;i<26;i++)
           nums[i]=-1;
       //a--97
        for(int i=0;i<A.length();i++){
            int tempA=A.charAt(i)-97;
            int tempB=B.charAt(i)-97;
            int big=tempA>tempB?tempA:tempB;
            int small=tempA<tempB?tempA:tempB;
            if(nums[big]==-1){
                nums[big]=small;
            }
            else{
                int index=big;
                while (nums[index]!=-1&&nums[index]!=index){
                    index=nums[index];
                }
                if(small<index)
                    nums[index]=small;
            }
        }
        //
        StringBuffer result=new StringBuffer();
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-97;
            while(nums[index]!=-1&&nums[index]!=index){
                index=nums[index];
            }
            index+=97;
            char charTemp=(char)index;
            result.append(charTemp);
        }
       return result.toString();
    }
    public static void main(String[]args){
        Solution s1=new Solution();
        String A="leetcode";
        String B="programs";
        String S="sourcecode";
        String result=s1.smallestEquivalentString(A,B,S);
        System.out.println(result);
        int a='a';
        System.out.println(a);

    }
}
