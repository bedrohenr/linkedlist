public class Aluno implements Comparable<Aluno> {
    int matricula;
    String nome;
    float nota;
    
    Aluno(int mat, String nome, float nota){
        this.matricula = mat;
        this.nome = nome;
        this.nota = nota;
    }

    public int compare(Comparable<Aluno> aluno){
        Aluno aluno2 = (Aluno) aluno;
        if (this.matricula < aluno2.matricula)
            return 1;

        if (this.matricula > aluno2.matricula)
            return -1;

        return 0;
    }

    public String toString(){
        return "\n\t{\n\t\tNome: " + this.nome + "\n\t\tMatricula: " + this.matricula + "\n\t\tNota: " + this.nota + "\n\t}";
    }
}
