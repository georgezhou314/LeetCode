package com.company;


public class RotateImage {
    private void print(int[][]matrix){
        int size=matrix.length;
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println("------------------");
    }
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;
        if(matrix[0].length!=matrix.length) return;
        int len=matrix.length;
        for(int i=matrix.length;i>1;i-=2){
            int x0=(len-i)/2;
            int y0;
            int x0_offset=x0;
            /*坐标变化原则
             *col:=len-1-row
             * row:=col
             */
            //旋转一圈的坐标，完成了一圈的轮廓坐标的旋转
            //(x0,y0)要旋转的点,(x1,y1)为要旋转的点的着陆点，完成旋转后，(x0,y0)进行更新
            for(int j=0;j<i-1;j++){
                y0=x0_offset+j;
                int last=matrix[x0][y0];
                //每次旋转四个点的坐标
                for(int k=0;k<4;k++){
                    int x1=y0;
                    int y1=len-1-x0;
                    int tmp=matrix[x1][y1];
                    matrix[x1][y1]=last;
                    last=tmp;
                    x0=x1;
                    y0=y1;
                    //print(matrix);
                }
            }
        }
        print(matrix);
    }
    public static void main(String[] args) {
	// write your code here
        RotateImage test=new RotateImage();
        int[][]matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        test.rotate(matrix);
    }
}
