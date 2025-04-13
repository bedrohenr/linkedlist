public class Principal {
    public static void main(String[] args) {
        System.out.println("-- Started");

        LinkedList<Integer> ll = new LinkedList<>(); 

        ll.add(12);
        ll.add(24);
        ll.add(36);
        ll.add(48);

        System.out.println(ll.toString());
        System.out.println("Tamanho da lista: " + ll.getSize());

        System.out.println("Ended --");
    }
    
}