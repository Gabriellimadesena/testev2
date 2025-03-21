public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private Turma turma;

    public Aluno(int id, String nome, int idade, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", nome='" + nome + "', idade=" + idade + ", turma=" + turma.getNome() + "}";
    }
}

