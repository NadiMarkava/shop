package collections;

public class CustomLinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    static class Node<E> {
        Node<E> next;
        E value;

        Node(E value) {
            this.value = value;
        }
    }

    public void addAtFirst(E val) {
        Node<E> temp = new Node(val);
        temp.next = head;
        head = temp;

        if (tail == null) {
            tail = temp;
        }
    }

    public void addAtLast(E val){
        if(tail==null){
            addAtFirst(val);
            return;
        }

        Node<E> temp = new Node<E>(val);
        tail.next = temp;
        tail = temp;
    }

    public void remove(CustomLinkedList<E> list,  E val) {
        Node curr = list.head, prev = null;
        while (curr != null && curr.value != val) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node<E> temp = head;
        while(temp!=null){
            builder.append(temp.value).append("->");
            if(temp==tail) builder.append("End");
            temp = temp.next;
        }
        return builder.toString();
    }
}
