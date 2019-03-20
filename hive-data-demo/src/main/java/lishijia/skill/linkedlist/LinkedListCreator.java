package lishijia.skill.linkedlist;

import lishijia.skill.common.Node;

import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 根据一个数组创建一个LinkedList使用递归，
 * 循环的方式（性能比递归好，递归创建100万级别的时候，会报错StackOverflow）
 * @author: lishijia
 * @create: 2019-03-20 10:33
 **/
public class LinkedListCreator {

    Node createWithRecursion(List<Integer> data){
        if(data == null || data.size()==0){
            return null;
        }
        Node node = new Node(data.get(0));
        node.setNext(createWithRecursion(data.subList(1, data.size())));
        return node;
    }

    Node createWithFor(List<Integer> data){
        Node head = new Node(data.get(0));
        Node pre = head;
        for(int i=1;i<data.size();i++){
            pre.setNext(new Node(data.get(i)));
            pre = pre.getNext();
        }
        return head;
    }


    public static void main(String args[]){
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node.print(linkedListCreator.createWithFor(Arrays.asList(1,2,3,4,5)));
        Node.print(linkedListCreator.createWithRecursion(Arrays.asList(1,2,3,4,5)));
    }

}
