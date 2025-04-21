import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivos {
    public void readFile(String nomeArquivo){
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);
                
                System.out.printf("ID: %d | Nome: %s | Nota: %.2f%n", id, nome, nota);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }


    public static void fromFileToList(String nomeArquivo, LinkedList<Aluno> sortedLL, LinkedList<Aluno> notSortedLL){

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);
            System.out.println(); 

            String linha;

            String[] partes; // Info da linha
            int id;  // id/Matricua
            String nome; // Nome do aluno
            float nota;
            Aluno aluno; // Obj aluno
            System.out.println("Iniciando criação dos alunos pelo arquivo.\n...");
            while ((linha = reader.readLine()) != null) {
                partes = linha.split(";");

                id = Integer.parseInt(partes[0]);
                nome = partes[1];
                nota = Float.parseFloat(partes[2]);
                
                // System.out.printf("ID: %d | Nome: %s | Nota: %.2f%n", id, nome, nota);
                aluno = new Aluno(id, nome, nota);

                sortedLL.add(aluno);
                notSortedLL.add(aluno);
            }
            System.out.println("Fim da criação dos alunos e adicionados as listas.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }
}
