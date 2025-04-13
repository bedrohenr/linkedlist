public class Aluno implements Comparator<Aluno> {
    int matricula;
    String nome;
    float nota;
    
    Aluno(int mat, String nome, float nota){
        this.matricula = mat;
        this.nome = nome;
        this.nota = nota;
    }

    public int compare(Aluno aluno){
        if (this.matricula > aluno.matricula)
            return 1;

        if (this.matricula < aluno.matricula)
            return -1;

        return 0;
    }
}
