package LinkedList;
public class Principal {
    public static void main(String[] args) {
        System.out.println("Running");

        LinkedList<String> ll = new LinkedList<>(); 

        ll.add("Oii");
        ll.add("Helooo");
        ll.add("Faaaaala Derick");
        ll.add("Yo");

        System.out.println("Tamanho da lista: " + ll.getSize());
        System.out.println(ll.toString());
    }
    
}