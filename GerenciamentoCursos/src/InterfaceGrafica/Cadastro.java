package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.CampoVazioException;
import Negocio.Entidades.Curso;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Turma;
import Negocio.Entidades.Usuario;
import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField textField_5;
	private JLabel lblCadastro_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblCurso;
	private JTextField textField_6;
	private JComboBox <String> comboBox = new JComboBox <String>();
	private JComboBox <String> comboBox_1 = new JComboBox <String>();
	public static Cadastro instance;
	public static Cadastro getInstace()  {
		if (Cadastro.instance == null) {
			return Cadastro.instance = new Cadastro();
		}
		return Cadastro.instance;
	}
	
	public void preencherCMBDisciplina(){
		comboBox.removeAllItems();
		@SuppressWarnings("unused")
		Disciplina d;
		Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina("",TelaLogin.getCurso_aluno_coord()));
		
		for(Disciplina d2 : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
			comboBox.addItem(d2.getNome());
		}
	}
	
	public void preencherCMBProfessores() {
		comboBox_1.removeAllItems();
		Fachada.getInstace().buscarPerfil("professor");
		
		for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
			comboBox_1.addItem(u.getNome());
		}
		
	}
	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}


	public Cadastro() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCadastro_1 = new JLabel("Cadastro");
		lblCadastro_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastro_1.setBounds(147, 11, 135, 44);
		contentPane.add(lblCadastro_1);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(174, 219, 91, 23);
		contentPane.add(btnCadastrar);


		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {		

			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Horario Funcionamento: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("CPF do Coordenador: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Curso curso =  new Curso((String)textField.getText(),(String)textField_1.getText(),(String)textField_2.getText());


					try {
						Fachada.getInstace().getCcurso().inserirCurso(curso);
					} catch (CampoVazioException e1) {
						JOptionPane.showMessageDialog(null, e1.toString("Nome Não Pode Ser "));

					}

				}
			});

		}else if (GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Ementa: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("numero de Creditos: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Curso: ");
			lblNewLabel_2.setBounds(162, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Turma: ");
			lblNewLabel_3.setBounds(162, 126, 140, 14);
			contentPane.add(lblNewLabel_3);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			if (TelaLogin.getInstace().getAdmCor() == 0) {
				lblNewLabel_2.setEnabled(false);
				textField_3.setEnabled(false);
			}				
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(TelaLogin.getInstace().getAdmCor() == 0) {
						@SuppressWarnings("unused")
						Disciplina d;
						Fachada.getInstace().getDc().inserirDisciplina(d = new Disciplina(0,textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),'S',TelaLogin.getCurso_aluno_coord(),Integer.parseInt(textField_4.getText())));
					}else if (TelaLogin.getInstace().getAdmCor() == 1) {
						@SuppressWarnings("unused")
						Disciplina d;
						Fachada.getInstace().getDc().inserirDisciplina(d = new Disciplina(0,textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),'S',Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText())));
					}				
				}
			});

		}else if (GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Sigla: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Turno: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Semestre: ");
			lblNewLabel_2.setBounds(162, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Turma turma = new Turma((String)textField.getText(),(String)textField_1.getText(),(String)textField_2.getText(), (String) textField_3.getText());;

					try {
						Fachada.getInstace().getTc().inserirTurma(turma);
					} catch (CampoVazioException e1) {
						JOptionPane.showMessageDialog(null, e1.toString("Nenhum Campo Pode Ser "));
					}
				}
			});

		}else if (GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	

			JRadioButton rdbtnM = new JRadioButton("M");
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});


		}else if (GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	

			JRadioButton rdbtnM = new JRadioButton("M");
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});


		}else if (GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			lblCurso = new JLabel("Curso");
			lblCurso.setBounds(184, 194, 140, 14);
			contentPane.add(lblCurso);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	


			textField_6 = new JTextField();
			textField_6.setBounds(318, 191, 114, 20);
			contentPane.add(textField_6);
			textField_6.setColumns(10);

			JRadioButton rdbtnM = new JRadioButton("M");
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);

			if (TelaLogin.getInstace().getAdmCor() == 0) {
				lblCurso.setEnabled(false);
				textField_6.setEnabled(false);
			}				
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(TelaLogin.getInstace().getAdmCor() == 0) {
						//Cadastra no Curso do Coordenador
					}else if (TelaLogin.getInstace().getAdmCor() == 1) {
						//Cadastra em Qualquer Curso.
					}	
				}
			});


		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			comboBox.setBounds(44, 61, 339, 20);
			contentPane.add(comboBox);

			
			comboBox_1.setBounds(44, 105, 339, 20);
			contentPane.add(comboBox_1);

			preencherCMBDisciplina();
			preencherCMBProfessores();
			
			JLabel lblLabel = new JLabel("Dia 1");
			lblLabel.setBounds(10, 126, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Dia 2");
			lblNewLabel.setBounds(10, 165, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_2 = new JLabel("Hora 1");
			lblNewLabel_2.setBounds(174, 126, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Hora 2");
			lblNewLabel_3.setBounds(174, 165, 140, 14);
			contentPane.add(lblNewLabel_3);

			textField = new JTextField();
			textField.setBounds(174, 143, 126, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 143, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(174, 188, 126, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().cadastrarOferta((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem(), textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
				}
			});
		}


	}
}

/*
JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setBounds(162, 87, 140, 14);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setBounds(162, 126, 140, 14);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("");
lblNewLabel_4.setBounds(172, 163, 130, 14);
contentPane.add(lblNewLabel_4);

textField = new JTextField();
textField.setBounds(10, 87, 130, 20);
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(10, 140, 130, 20);
contentPane.add(textField_1);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setBounds(10, 190, 130, 20);
contentPane.add(textField_2);
textField_2.setColumns(10);

textField_3 = new JTextField();
textField_3.setBounds(318, 87, 114, 20);
contentPane.add(textField_3);
textField_3.setColumns(10);

textField_4 = new JTextField();
textField_4.setBounds(318, 123, 114, 20);
contentPane.add(textField_4);
textField_4.setColumns(10);

textField_5 = new JTextField();
textField_5.setBounds(318, 157, 114, 20);
contentPane.add(textField_5);
textField_5.setColumns(10);	
 */