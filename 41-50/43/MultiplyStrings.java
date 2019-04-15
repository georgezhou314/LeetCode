
/**
 * 应该用数组代替ArrayList，数组肯定要比ArrayList要快多了
 *还要继续优化
 */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        //num1 is longer than num2
        int []result=new int[num1.length()+num2.length()];
        for(int i=num2.length()-1;i>-1;i--){
            int index=num2.length()-i-1;
            for(int j=num1.length()-1;j>-1;j--){
                int tempMultiplyResult=(num1.charAt(j)-48)*(num2.charAt(i)-48);
                result[index]=result[index]+tempMultiplyResult;
                index++;
            }
            index--;
        }
        //整个数组进行进位操作
        for(int k=0;k<result.length-1;k++){
            result[k+1]=result[k]/10+result[k+1];
            result[k]=result[k]%10;
        }
        int len=result.length;
        if(result[len-1]==0) len-=1;
        StringBuffer str=new StringBuffer(result.length);
        while(len>0)
            str.append(result[--len]);

       return str.toString();
    }

    public static void main(String[]args){
        MultiplyStrings test=new MultiplyStrings();
        test.multiply("23","112");
        test.multiply("999","9999");
        test.multiply("19","299");
        test.multiply("88","88");
        test.multiply("112","23");
        //assertEquals(test.multiply("18888234","1553"),Long.toString(18888234*1553));
    }
}
