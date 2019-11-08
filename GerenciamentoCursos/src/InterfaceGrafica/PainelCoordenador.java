package InterfaceGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelCoordenador extends JFrame {

	private JPanel contentPane;
	public static PainelCoordenador instance;
    public static PainelCoordenador getInstace() {
    	if (PainelCoordenador.instance == null) {
			return PainelCoordenador.instance = new PainelCoordenador();
		}
		return PainelCoordenador.instance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelCoordenador frame = new PainelCoordenador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PainelCoordenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPainelDoAdministrador = new JLabel("Painel Do Coordenador");
		lblPainelDoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoAdministrador.setBounds(10, 0, 472, 83);
		contentPane.add(lblPainelDoAdministrador);

		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);

		JButton btnGerenciamentoDeDisciplina = new JButton("Gerenciamento de Disciplinas");
		btnGerenciamentoDeDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciamentoDeDisciplinas.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeDisciplina.setBounds(20, 142, 183, 23);
		contentPane.add(btnGerenciamentoDeDisciplina);

		JButton btnGerenciamentoDeTurma = new JButton("Gerenciamento de Turmas");
		btnGerenciamentoDeTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciamentoDeTurmas.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeTurma.setBounds(20, 189, 183, 23);
		contentPane.add(btnGerenciamentoDeTurma);

		JButton btnGerenciamentoDeProfessor = new JButton("Gerenciamento de Professores");
		btnGerenciamentoDeProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciamentoDeProfessores.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeProfessor.setBounds(230, 142, 202, 23);
		contentPane.add(btnGerenciamentoDeProfessor);

		JButton btnGerenciamentoDeAlunos = new JButton("Gerenciamento de Alunos");
		btnGerenciamentoDeAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciamentoDeAlunos.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeAlunos.setBounds(230, 189, 202, 23);
		contentPane.add(btnGerenciamentoDeAlunos);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin.setCpf(null);
				TelaLogin.setCurso_aluno_coord(-1);
				TelaLogin.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(10, 0, 47, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Gerenciamento de Ofertas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciamentoOfertas.getInstace().setVisible(true);			}
		});
		btnNewButton.setBounds(109, 93, 204, 23);
		contentPane.add(btnNewButton);
	}

}
