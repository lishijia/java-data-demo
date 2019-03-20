package lishijia.skill.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 把一个数组元素组合（n）
 * @author: lishijia
 * @create: 2019-03-20 13:39
 **/
public class Combination {

    static void combination(List<Integer> selected, List<Integer> data, int n){

        if(n==0){
            for(Integer value : selected){
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if(data.size()==0){
            return;
        }

        selected.add(data.get(0));
        combination(selected, data.subList(1, data.size()), n-1);

        selected.remove(selected.size()-1);
        combination(selected, data.subList(1,data.size()),n);
    }

    public static void main(String args[]){

        combination(new ArrayList<Integer>(), Arrays.asList(1,2,3,4,5),2);

    }

}
