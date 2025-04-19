import java.util.Scanner;

public class Principal {
    private static int menu(LinkedList<Aluno> list, LinkedList<Aluno> sortedList){
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Pesquisar na lista ordenada");
        System.out.println("2 - Pesquisar na lista não ordenada");
        System.out.println("3 - Sair");
        System.out.print("Sua escolha: ");

        int escolha = scan.nextInt();;
        while(escolha < 0 && escolha > 3)
            escolha = scan.nextInt();

        
        if(escolha != 3){
            System.out.print("Insira a matricula a ser buscada: ");
            int matricula = scan.nextInt();
            makeShowSearch(escolha, matricula, list, sortedList);
        }

        return escolha;
    }

    private static void makeShowSearch(int escolha, int matricula, LinkedList<Aluno> list, LinkedList<Aluno> sortedList){
        Aluno rAluno = null;

        long start, elapsed;
        String output = "";
        switch(escolha){
            case 1:
                start = System.currentTimeMillis();
                rAluno = sortedList.search(matricula);
                elapsed = System.currentTimeMillis() - start; 
                output = "A busca na lista ordenada durou: " + elapsed + " milisegundos";
                break;
            case 2:
                start = System.currentTimeMillis();
                rAluno = list.search(matricula);
                elapsed = System.currentTimeMillis() - start; 
                output = "A busca na lista não ordenada durou: " + elapsed + " milisegundos";
                break;
        }

        if(rAluno != null){
            System.out.println("Aluno com matricula \""+ matricula +"\" encontrado");
            System.out.println(rAluno.print());
            System.out.println(output);
        } else {
            System.out.println("Erro. Aluno com matricula \""+ matricula +"\" não encontrado");
        }
    }

    public static void main(String[] args) {
        System.out.println("-- Started");


        Aluno pedro = new Aluno(1, "pedro", 10);
        Aluno kaio = new Aluno(2, "kaio", 9);
        Aluno lucas = new Aluno(4, "lucas", 9);
        Aluno alicia = new Aluno(3, "alicia", 9);
        Aluno marcos = new Aluno(2, "marcos", 9);
        Aluno livia = new Aluno(4, "livia", 9);
        Aluno andre = new Aluno(1, "andre", 9);
        Aluno luiz = new Aluno(5, "luiz", 9);
        Aluno jair = new Aluno(3, "jair", 9);
        Aluno maome = new Aluno(3, "maome", 9);
        Aluno denis = new Aluno(9, "denis", 9);

        LinkedList<Aluno> ll = new LinkedList<>(true); 

        ll.add(lucas);
        ll.add(alicia);
        ll.add(pedro);
        ll.add(kaio);
        ll.add(andre);
        ll.add(livia);
        ll.add(marcos);
        ll.add(jair);
        ll.add(maome);
        ll.add(luiz);
        ll.add(denis);

        System.out.println(ll.toString());

        // System.out.println("Teste" + pedro.compare(kaio));
        System.out.println("Tamanho da lista: " + ll.getSize());
        System.out.println("Ended --");
    }
    
}