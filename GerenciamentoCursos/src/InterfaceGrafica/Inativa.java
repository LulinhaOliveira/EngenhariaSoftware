package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Negocio.Entidades.Curso;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Turma;
import Negocio.Entidades.Usuario;
import Negocio.Fachada.Fachada;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Inativa extends JFrame {

	private JPanel contentPane;
	JComboBox <String> comboBox = new JComboBox <String>();
	public static Inativa instance;
	public static Inativa getInstace() {
		if (Inativa.instance == null) {
			return Inativa.instance = new Inativa();
		}
		return Inativa.instance;
	}

	public void preencheCMB() {
		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			@SuppressWarnings("unused")
			Curso c;
			Fachada.getInstace().getCcurso().buscarCurso(c = new Curso(0,"","",'S',""));

			for(Curso a : Fachada.getInstace().getCcurso().getCp().getCursosLista()) {
				comboBox.addItem(a.getNome());
			}
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				@SuppressWarnings("unused")
				Disciplina d;
				Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina(0,"","", 0,'S',TelaLogin.getCurso_aluno_coord(),0));
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				@SuppressWarnings("unused")
				Disciplina d;
				Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina(0,"","", 0,'S',0,0));
			}

			for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
				comboBox.addItem(d.getNome());
			}
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			@SuppressWarnings("unused")
			Turma t;
			Fachada.getInstace().getTc().buscarTurma(t = new Turma(0,"","","","",'S'));

			for(Turma a : Fachada.getInstace().getTc().getTp().getTurmalista()){
				comboBox.addItem(a.getNome());

			}

		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			Fachada.getInstace().buscarPerfil("coordenador",'S',0);


			for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
				comboBox.addItem(u.getNome());
			}

		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			Fachada.getInstace().buscarPerfil("professor",'S',0);


			for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
				comboBox.addItem(u.getNome());
			}
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				Fachada.getInstace().buscarPerfil("aluno",'S',TelaLogin.getCurso_aluno_coord());


				for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
					comboBox.addItem(u.getNome());
				}
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				Fachada.getInstace().buscarPerfil("aluno",'S',0);


				for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
					comboBox.addItem(u.getNome());
				}			
			}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
				Fachada.getInstace().disciplinasOfertadas("", TelaLogin.getCurso_aluno_coord(),'S');

				for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
					comboBox.addItem(d.getNome());
				}

			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inativa frame = new Inativa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Inativa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox.setBounds(29, 48, 380, 22);
		contentPane.add(comboBox);

		JButton btnInativar = new JButton("Inativar");
		btnInativar.setBounds(173, 225, 91, 23);
		contentPane.add(btnInativar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 119, 380, 93);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JLabel lblInativar = new JLabel("Inativar");
		lblInativar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInativar.setBounds(156, 0, 169, 37);
		contentPane.add(lblInativar);

		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(173, 85, 89, 23);
		contentPane.add(btnVer);

		preencheCMB();
		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getCcurso().inativarCurso((String)comboBox.getSelectedItem());
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Curso c = new Curso((String)comboBox.getSelectedItem(),"","");
					Fachada.getInstace().getCcurso().buscarCurso(c);
					for(Curso c2 : Fachada.getInstace().getCcurso().getCp().getCursosLista()) {
						textArea.setText(c2.toString());
					}
				}
			});
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {

			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getDc().inativarDisciplina((String)comboBox.getSelectedItem());
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Disciplina d = new Disciplina(0,(String)comboBox.getSelectedItem(),"", 0,'S',0,0);
					Fachada.getInstace().getDc().buscarDisciplina(d);

					for(Disciplina d2 : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
						textArea.setText(d2.toString());
					}

				}
			});
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {


			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getTc().inativarTurma((String)comboBox.getSelectedItem());				
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Turma t = new Turma((String)comboBox.getSelectedItem(),"","","");
					Fachada.getInstace().getTc().buscarTurma(t);
					for(Turma t2 : Fachada.getInstace().getTc().getTp().getTurmalista()) {
						textArea.setText(t2.toString());
					}

				}
			});
		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {

			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String  cpf =Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem());
					
					Fachada.getInstace().getUc().desativarUsuario(cpf);
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario((String) comboBox.getSelectedItem());

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {

			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String  cpf =Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem());
					
					Fachada.getInstace().getUc().desativarUsuario(cpf);
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario((String) comboBox.getSelectedItem());

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {

			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String  cpf =Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem());
					
					Fachada.getInstace().getUc().desativarUsuario(cpf);
				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario((String) comboBox.getSelectedItem());

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {

			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod = Fachada.getInstace().buscarPosiçãoDisciplina((String) comboBox.getSelectedItem());

					Fachada.getInstace().getOdc().inativarOferta_Disciplina(Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getCodigo());

				}
			});

			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod = Fachada.getInstace().buscarPosiçãoDisciplina((String) comboBox.getSelectedItem());

					textArea.setText("Disciplina: " + Fachada.getInstace().getDc().getDr().getDisciplinaLista().get(cod).getNome()
							+ "\n Dia 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_1()
							+ "\n Dia 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_2()
							+ "\n Hora 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_1()
							+ "\n Hora 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_2()
							);
				}
			});
		}

	}
}
