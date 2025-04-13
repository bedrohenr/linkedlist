public class Principal {
    public static void main(String[] args) {
        System.out.println("-- Started");


        Aluno pedro = new Aluno(1, "pedro", 10);
        Aluno kaio = new Aluno(2, "kaio", 9);
        Aluno lucas = new Aluno(4, "lucas", 9);
        Aluno alicia = new Aluno(3, "alicia", 9);

        LinkedList<Aluno> ll = new LinkedList<>(false); 

        ll.add(pedro);
        ll.add(alicia);
        ll.add(lucas);
        ll.add(kaio);

        System.out.println(ll.toString());
        System.out.println("Tamanho da lista: " + ll.getSize());
        System.out.println("Ended --");
    }
    
}