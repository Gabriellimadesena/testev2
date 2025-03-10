import java.util.ArrayList;
import java.util.List;

public class Turmacrud {
    private List<Turma> turmas = new ArrayList<>();
    private int proximoId = 1;

    public void adicionarTurma(String nome) {
        turmas.add(new Turma());
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }

    public Turma buscarTurmaPorId(int id) {
        for (Turma turma : turmas) {
            if (turma.getId() == id) {
                return turma;
            }
        }
        return null;
    }
}

