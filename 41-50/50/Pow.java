/**
 * @since 2019-7-17 23:34
 * 计算指数,举例说明算法，如果是pow(2,10)
 * 则求解pow(2,5)*pow(2,5)
 *如果是pow(2,11)
 * 则求解pow(2,5)*pow(2,5)*2
 * 考虑幂的偶数和奇数阶次
 */

public class Pow {
    private  double pow(double x,long n){
        if(n==0) return 1;
        if(n==1) return x;
        double tmp;
        if(n%2==0){
            tmp=pow(x,n/2);
            return tmp*tmp;
        }
        else{
            tmp=pow(x,(n-1)/2);
            return tmp*tmp*x;
        }
    }
    public double myPow(double x, int n) {
        long N=n;
        N=Math.abs(N);
        double res=pow(x,N);
        return n<0? 1.0/res :res;
    }
    public static void main(String[]args){
       Pow test=new Pow();
       double res=test.myPow(2,-3);
       // double res=test.myPow(2,10);
       //System.out.println(Double.POSITIVE_INFINITY);
       System.out.println(res);
    }
}
