package lishijia.skill.linkedlist;

import lishijia.skill.common.Node;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-20 10:53
 **/
public class ReverserLinedList {

    Node reverserWithRecursion(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }
        Node newHead = reverserWithRecursion(head.getNext());
        // 设置当前的下一个的下一个是当前(反转)
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    Node reverserWithWhile(Node head){
        Node newHead = null;
        Node curHead = head;

        while(curHead != null){
            Node node = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = node;
        }

        return newHead;
    }



    public static void main(String args[]){
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node node = linkedListCreator.createWithFor(Arrays.asList(1,2,3,4,5));
        Node.print(node);

        ReverserLinedList reverserLinedList = new ReverserLinedList();
//        Node.print(reverserLinedList.reverserWithRecursion(node));

        Node.print(reverserLinedList.reverserWithWhile(node));
    }

}
