package lishijia.skill.linkedlist;

import lishijia.skill.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class LinedListDelete {

    static Node remove(Node head, int deleteValue){

        while(head!=null && head.getValue()==deleteValue){
            head = head.getNext();
        }

        if(head == null){
            return null;
        }

        Node prev = head;


        while(prev.getNext() != null){
            if(prev.getNext().getValue()==deleteValue){
                prev.setNext(prev.getNext().getNext());
            }else{
                prev = prev.getNext();
            }
        }

        return head;
    }


    public static void main(String args[]){
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node node = linkedListCreator.createWithFor(Arrays.asList(1,2,2,2,5));
        Node.print(remove(node, 2));

        Node.print(remove(linkedListCreator.createWithFor(Arrays.asList(2,2,1,2,3,4,5)),2));
        Node.print(remove(linkedListCreator.createWithFor(Arrays.asList(2,2,1,2,3,2,2)),2));
        Node.print(remove(linkedListCreator.createWithFor(Arrays.asList(11,2,2,2)),2));

        Node.print(remove(linkedListCreator.createWithFor(Arrays.asList(2)),2));
        Node.print(remove(linkedListCreator.createWithFor(Arrays.asList(1)),2));

        Node.print(remove(linkedListCreator.createWithFor(new ArrayList<Integer>()),2));
    }

}
