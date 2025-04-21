import java.io.File;
import java.util.Scanner;

public class Principal {
    private static int menu(LinkedList<Aluno> list, LinkedList<Aluno> sortedList){
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Pesquisar na lista ordenada");
        System.out.println("2 - Pesquisar na lista não ordenada");
        System.out.println("3 - Sair");
        System.out.print("Sua escolha: ");

        int escolha = scan.nextInt();;
        while(escolha < 1 || escolha > 3){
            System.out.print("Escolha inválida. Tente novamente: ");
            escolha = scan.nextInt();
        }
        
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
        boolean NOT_SORTED = false;
        boolean SORTED = true;
        System.out.println("-- Início do programa");

        String filePath = "alunos.txt";
        File f = new File(filePath);
        if(!f.exists() && !f.isDirectory()) { 
            GeradorArquivosBalanceados.gerarArquivo();
        }

        LinkedList<Aluno> notSortedLL = new LinkedList<>(NOT_SORTED); 
        LinkedList<Aluno> sortedLL = new LinkedList<>(SORTED); 

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
        Aluno vivian = new Aluno(9, "vivian", 9);

        sortedLL.add(lucas);
        sortedLL.add(alicia);
        sortedLL.add(pedro);
        sortedLL.add(kaio);
        sortedLL.add(andre);
        sortedLL.add(livia);
        sortedLL.add(marcos);
        sortedLL.add(jair);
        sortedLL.add(maome);
        sortedLL.add(luiz);
        sortedLL.add(vivian);

        LeitorArquivos.fromFileToList(filePath, sortedLL, notSortedLL);

        System.out.println("Lista ordenada:" +sortedLL.toString());
        // System.out.println("Lista nao ordenada:" +notSortedLL.toString());

        // int escolha;
        // do {
        //     escolha = menu(notSortedLL, sortedLL);
        // }
        // while(escolha != 3);

        System.out.println("Fim da execução do programa --");
    }
    
}