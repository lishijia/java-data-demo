package lishijia.skill.binarySearch;


/**
 * 二分查找
 */
public class BinarySearch {

    static int search(int[] arry, int k){

        int a = 0;
        int b= arry.length;
        while( a < b){
            int m = (a + b) / 2;
            //System.out.println(m);
            if(k<arry[m]){
                b=m;
            }else if(k>arry[m]){
                a=m+1;
            }else{
                return m;
            }
        }
        return -1;
    }


    public static void main(String args[]){

        //以下为测试用例

        System.out.println(search(new int[]{1,2,5,10,11}, -1));
        System.out.println(search(new int[]{1,2,5,10,11}, 5));
        System.out.println(search(new int[]{1,2,5,10,11}, 12));

        System.out.println("=============================");

        System.out.println(search(new int[]{}, 12));
        System.out.println(search(new int[]{12}, 12));
        System.out.println(search(new int[]{12}, 13));
        System.out.println("=============================");

        System.out.println(search(new int[]{12,13}, 10));
        System.out.println(search(new int[]{12,13}, 13));
        System.out.println(search(new int[]{12,13}, 14));


    }


}
