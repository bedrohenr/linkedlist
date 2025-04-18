public class LinkedList<T> {
    private Node<T> first, last;
    private int size;
    private boolean sorted;

    public LinkedList(boolean sort){
        this.sorted = false;
        this.first = this.last = null;
        this.size = 0;
        this.sorted = sort;
    }

    public void add(T elem) {
        if(sorted)
            this.addSorted((Comparable<T>) elem);
        else
            this.addLast(elem);
    }

    public void addLast(T elem){
        Node<T> newE = new Node<>(elem);

        if(this.first == null){
            this.first = newE;
            this.last = newE;
            this.size++;
        } else {
            this.last.setNext(newE);
            this.last = newE;
            this.size++;
        }
    }

    public void addOrd(T elem){
        // TODO: Checar na lista com comparable
    }

    public Node<T> search(T elem){
        Node<T> aux = this.first;
        while(aux != null){
            if(aux.getValue().equals(elem))
                return aux;
        }
        return null;
    }

    public boolean delete(T elem){
        Node<T> aux = this.first;
        Node<T> before = null;

        while ( aux != null ){
            if(aux.getValue().equals(elem)){
                if( aux== this.first){
                    this.first = this.first.getNext();
                    if(aux == this.last)
                    this.last = null;
                } else {
                    before.setNext(aux.getNext());

                    if( aux == this.last )
                        this.last = before;
                }
                this.size--;
                return true;
            } 
            before = aux;
            aux = aux.getNext();
        }
        return false;
    }

    public String toString(){
        Node<T> aux = this.first;
        String s = "[";

        while( aux != null ){
            s += aux.getValue();
            
            if(aux != this.last)
                s += ",";
            
            aux = aux.getNext();
        }

        s += "\n]";

        return s;
    }

    public int getSize(){
        return this.size;
    }

    public boolean compareable() {
        return True;
    }

}