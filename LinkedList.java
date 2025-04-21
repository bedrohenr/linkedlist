public class LinkedList<T> {
    private Node<Comparable<T>> first, last;
    private int size;
    private boolean sorted;

    public LinkedList(boolean sort){
        this.sorted = false;
        this.first = this.last = null;
        this.size = 0;
        this.sorted = sort;
    }

    public void add(Comparable<T> elem) {
        if(sorted)
            this.addSorted(elem);
        else
            this.addLast(elem);
    }

    public void addLast(Comparable<T> elem){
        Node<Comparable<T>> newE = new Node<>(elem);

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

    public void addSorted(Comparable<T> elem){
        Node<Comparable<T>> newE = new Node<>(elem);
        this.size++;

        if(this.first == null) {
            this.first = newE;
            this.last = newE;
            return;
        }

        Node<Comparable<T>> aux = this.first;
        Node<Comparable<T>> ant = null;

        // Somente um item na lista
        if(this.first.getNext() == null){
            if(newE.getValue().compare(aux.getValue()) == 1){
                newE.setNext(aux);
                this.first = newE;
                this.last = aux;
            } else {
                this.first.setNext(newE);
                this.last = newE;
            }
            return;
        }

        if (newE.getValue().compare(this.first.getValue()) > 0){
            newE.setNext(this.first);
            this.first = newE;
            return;
        }

        while(aux != null){
            // >= 0 == Deve ser inserido antes do aux
            if(newE.getValue().compare(aux.getValue()) >= 0){
                ant.setNext(newE);
                newE.setNext(aux);
                return;
                
            }
            ant = aux;
            aux = aux.getNext();
        }
        ant.setNext(newE);
        if (ant == this.last) {
            this.last = newE;
        }
        return;
        
    }

    public Node<Comparable<T>> search(T elem){
        Node<Comparable<T>> aux = this.first;
        while(aux != null){
            if(aux.getValue().equals(elem))
                return aux;
        }
        return null;
    }

    public Aluno search(int matricula){
        Node aux = this.first;
        Aluno aluno;
        System.out.println("Buscando...");
        while(aux != null){
            aluno = (Aluno) aux.getValue();
            // System.out.println("if"+ aluno.matricula + " == " + matricula);
            if(aluno.matricula == matricula)
                return aluno;

            aux = aux.getNext();
        }
        return null;
    }

    public boolean delete(T elem){
        Node aux = this.first;
        Node before = null;

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
        Node aux = this.first;
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

}