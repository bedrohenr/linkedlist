public class Node<T> {
    public T value;
    private Node next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public T getValue(){
        return value; 
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node aux){
        this.next = aux;
    }


}