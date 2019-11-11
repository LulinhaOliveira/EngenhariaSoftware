package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Entidades.Aluno_Oferta_Disciplina;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Usuario;
import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelProfessor extends JFrame {

	private JPanel contentPane;
	JComboBox <String> cmbDisciplinasOfertadas = new JComboBox<String>();
	JComboBox <String>cmbAlunos = new JComboBox <String>();
	private JTextField tvalorNota1;
	private JTextField tvalorNota2;
	public static PainelProfessor instance;
	public static PainelProfessor getInstace() {
		if (PainelProfessor.instance == null) {
			return PainelProfessor.instance = new PainelProfessor();
		}
		return PainelProfessor.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelProfessor frame = new PainelProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void preencheCMBDisciplina() {
		cmbDisciplinasOfertadas.removeAllItems();
		Fachada.getInstace().disciplinasOfertadas(TelaLogin.getCpf(),0,'N');

		for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
			cmbDisciplinasOfertadas.addItem(d.getNome());
		}
	}
	public void preencheCMBAlunos() {
		cmbAlunos.removeAllItems();
		Fachada.getInstace().alunosDisciplina((String)cmbDisciplinasOfertadas.getSelectedItem(),0, TelaLogin.getCpf());

		for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
			cmbAlunos.addItem(u.getNome());
		}
	}
	/**
	 * Create the frame.
	 */
	public PainelProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		preencheCMBDisciplina();
		JLabel lblPainelDoProfessor = new JLabel("Painel Do Professor");
		lblPainelDoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoProfessor.setBounds(59, 11, 363, 34);
		contentPane.add(lblPainelDoProfessor);

		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);


		cmbDisciplinasOfertadas.setBounds(66, 56, 303, 22);
		contentPane.add(cmbDisciplinasOfertadas);


		cmbAlunos.setBounds(66, 123, 303, 22);
		contentPane.add(cmbAlunos);

		JButton btnAtribuirFalta = new JButton("Atribuir Falta");
		btnAtribuirFalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod = Fachada.getInstace().buscarPosicaoAluno((String) cmbAlunos.getSelectedItem());
				int cod2 = Fachada.getInstace().buscarPosiçãoDisciplina((String) cmbDisciplinasOfertadas.getSelectedItem());
				Fachada.getInstace().getAodc().atribuirFrequencia(Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCpf(), Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod2).getCodigo());
			}
		});
		btnAtribuirFalta.setBounds(297, 211, 126, 23);
		contentPane.add(btnAtribuirFalta);

		JLabel lblFrequncia = new JLabel("Faltas: ");
		lblFrequncia.setBounds(297, 191, 106, 14);
		contentPane.add(lblFrequncia);

		JLabel lblNota = new JLabel("Nota 1:");
		lblNota.setBounds(9, 194, 47, 14);
		contentPane.add(lblNota);

		JLabel lblNota_1 = new JLabel("Nota 2:");
		lblNota_1.setBounds(10, 220, 46, 14);
		contentPane.add(lblNota_1);

		tvalorNota1 = new JTextField();
		tvalorNota1.setBounds(52, 191, 86, 20);
		contentPane.add(tvalorNota1);
		tvalorNota1.setColumns(10);

		tvalorNota2 = new JTextField();
		tvalorNota2.setBounds(52, 217, 86, 20);
		contentPane.add(tvalorNota2);
		tvalorNota2.setColumns(10);

		JButton btnAtribuirNota = new JButton("Atribuir Nota");
		btnAtribuirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod = Fachada.getInstace().buscarPosicaoAluno((String) cmbAlunos.getSelectedItem());
				int cod2 = Fachada.getInstace().buscarPosiçãoDisciplina((String) cmbDisciplinasOfertadas.getSelectedItem());
				Fachada.getInstace().getAodc().atribuirNota_1(Double.parseDouble(tvalorNota1.getText()), (String )Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCpf(),Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod2).getCodigo());
			}
		});
		btnAtribuirNota.setBounds(148, 190, 121, 23);
		contentPane.add(btnAtribuirNota);

		JButton bAtribuirNota = new JButton("Atribuir Nota");
		bAtribuirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod = Fachada.getInstace().buscarPosicaoAluno((String) cmbAlunos.getSelectedItem());
				int cod2 = Fachada.getInstace().buscarPosiçãoDisciplina((String) cmbDisciplinasOfertadas.getSelectedItem());
				@SuppressWarnings("unused")
				Aluno_Oferta_Disciplina a ;
				Fachada.getInstace().getAodc().atribuirNota_2(Double.parseDouble(tvalorNota2.getText()), (String )Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCpf(),Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod2).getCodigo());
				Fachada.getInstace().getAodc().definirMedia(a = new Aluno_Oferta_Disciplina((String )Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCpf(),Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod2).getCodigo(),Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_1(),
						Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_2(),0,0,""));
				//				Fachada.getInstace().getAodc().alterarStatus(a = new Aluno_Oferta_Disciplina((String )Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCpf(),Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod2).getCodigo(),
//						Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_1(),Double.parseDouble(tvalorNota2.getText()),0,0,""));
				

			}
		});
		bAtribuirNota.setBounds(148, 216, 121, 23);
		contentPane.add(bAtribuirNota);

		JButton btnBuscarAlunos = new JButton("Buscar Alunos");
		btnBuscarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCMBAlunos();
			}
		});
		btnBuscarAlunos.setBounds(148, 89, 126, 23);
		contentPane.add(btnBuscarAlunos);

		JButton btnNewButton = new JButton("Ver Situa\u00E7\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod = Fachada.getInstace().buscarPosicaoAluno((String)cmbAlunos.getSelectedItem());
				tvalorNota1.setText(""+Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_1());
				tvalorNota2.setText(""+Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_2());
				lblFrequncia.setText("Falta: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getFrequencia());
				
			}
		});
		btnNewButton.setBounds(148, 156, 126, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin.setCpf(null);
				TelaLogin.setCurso_aluno_coord(-1);
				TelaLogin.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(10, 11, 47, 23);
		contentPane.add(button);
		
		JButton btnEncerrarDisciplina = new JButton("Encerrar Disciplina");
		btnEncerrarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstace().definirSituacao();
				int cod = Fachada.getInstace().buscarPosicaoAluno((String) cmbAlunos.getSelectedItem());	
				Fachada.getInstace().inativarOferta(Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCodigo());
				Fachada.getInstace().getAtc().removerAluno_Turma(Fachada.getInstace().getAodc().pegarCodigoTurma(Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getCodigo()));
			}
		});
		btnEncerrarDisciplina.setBounds(297, 245, 125, 23);
		contentPane.add(btnEncerrarDisciplina);
		
		JButton btnNewButton_1 = new JButton("/\\");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCMBAlunos();
			}
		});
		btnNewButton_1.setBounds(10, 160, 46, 23);
		contentPane.add(btnNewButton_1);
	}

}
