import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class MainView extends JFrame {
    private Alunocrud alunoService = new Alunocrud();
    private Turmacrud turmaService = new Turmacrud();

    public MainView() {
        setTitle("Gerenciamento de Alunos e Turmas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnAdicionarTurma = new JButton("Adicionar Turma");
        JButton btnAdicionarAluno = new JButton("Adicionar Aluno");
        JButton btnListarAlunos = new JButton("Listar Alunos");

        add(btnAdicionarTurma);
        add(btnAdicionarAluno);
        add(btnListarAlunos);

        btnAdicionarTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome da turma:");
                if (nome != null && !nome.trim().isEmpty()) {
                    turmaService.adicionarTurma(nome);
                    JOptionPane.showMessageDialog(null, "Turma adicionada!");
                }
            }
        });

        btnAdicionarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turmaService.listarTurmas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Adicione uma turma primeiro!");
                    return;
                }

                String nome = JOptionPane.showInputDialog("Nome do aluno:");
                String idadeStr = JOptionPane.showInputDialog("Idade do aluno:");
                int idade = Integer.parseInt(idadeStr);

                String[] turmas = turmaService.listarTurmas().stream()
                        .map(Turma::getNome)
                        .toArray(String[]::new);

                String turmaEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha a turma:",
                        "Selecionar Turma", JOptionPane.QUESTION_MESSAGE, null, turmas, turmas[0]);

                for (Turma turma : turmaService.listarTurmas()) {
                    if (turma.getNome().equals(turmaEscolhida)) {
                        alunoService.adicionarAluno(nome, idade, turma);
                        JOptionPane.showMessageDialog(null, "Aluno adicionado!");
                        break;
                    }
                }
            }
        });

        btnListarAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder lista = new StringBuilder("Alunos:\n");
                for (Aluno aluno : alunoService.listarAlunos()) {
                    lista.append(aluno.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, lista.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}
