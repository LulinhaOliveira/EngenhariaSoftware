package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PainelAdministrador extends JFrame {

	private JPanel contentPane;
	public static PainelAdministrador instance;
    public static PainelAdministrador getInstace() {
    	if (PainelAdministrador.instance == null) {
			return PainelAdministrador.instance = new PainelAdministrador();
		}
		return PainelAdministrador.instance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAdministrador frame = new PainelAdministrador();
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
	public PainelAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDoAdministrador = new JLabel("Painel Do Administrador");
		lblPainelDoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoAdministrador.setBounds(10, 0, 472, 83);
		contentPane.add(lblPainelDoAdministrador);
		
		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);
		
		JButton btnGerenciamentoDeCurso = new JButton("Gerenciamento de Cursos");
		btnGerenciamentoDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    dispose();
					GerenciamentoDeCursos.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeCurso.setBounds(20, 94, 183, 23);
		contentPane.add(btnGerenciamentoDeCurso);
		
		JButton btnGerenciamentoDeUsurio = new JButton("Gerenciamento de Coordenadores");
		btnGerenciamentoDeUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GerenciamentoDeCoordenadores.getInstace().setVisible(true);
			}
		});
		btnGerenciamentoDeUsurio.setBounds(230, 94, 202, 23);
		contentPane.add(btnGerenciamentoDeUsurio);
		
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
				dispose();
				TelaLogin.setCpf(null);
				TelaLogin.setCurso_aluno_coord(-1);
				TelaLogin.getInstace().setVisible(true);
			}
		});
		button.setBounds(10, 0, 47, 23);
		contentPane.add(button);
	}
}
