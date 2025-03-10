import java.util.ArrayList;
import java.util.List;

public class Alunocrud {
    private List<Aluno> alunos = new ArrayList<>();
    private int proximoId = 1;


    public void adicionarAluno(String nome, int idade, Turma turma) {
        Aluno aluno = new Aluno(proximoId++, nome, idade, turma);
        alunos.add(aluno);
        turma.adicionarAluno(aluno);
    }


    public List<Aluno> listarAlunos() {
        return alunos;
    }


    public boolean atualizarAluno(int id, String nome, int idade) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                aluno.setNome(nome);
                aluno.setIdade(idade);
                return true;
            }
        }
        return false;
    }


    public boolean removerAluno(int id) {
        return alunos.removeIf(aluno -> aluno.getId() == id);
    }
}

