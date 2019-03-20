package lishijia.skill.common;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-20 10:32
 **/
public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void print(Node node){
        while(node!=null){
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
