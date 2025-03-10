import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private List<Aluno> alunos;

    public Turma() {
        this.id = id;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Aluno> getAlunos() { return alunos; }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return "Turma{id=" + id + ", nome='" + nome + "', totalAlunos=" + alunos.size() + "}";
    }
}

