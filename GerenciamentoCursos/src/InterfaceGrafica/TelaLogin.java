package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BancoDados.Conexao;
import Exception.SenhaErradaException;
import Exception.cpfErradoException;
import Negocio.Entidades.Aluno;
import Negocio.Entidades.Curso;
import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {
	private static int admCor = -1;
	private static String cpf = null;
	private static int curso_aluno_coord = -1;

	public static String getCpf() {
		return cpf;
	}

	public static void setCpf(String cpf) {
		TelaLogin.cpf = cpf;
	}

	public static int getCurso_aluno_coord() {
		return curso_aluno_coord;
	}

	public static void setCurso_aluno_coord(int curso_aluno_coord) {
		TelaLogin.curso_aluno_coord = curso_aluno_coord;
	}

	public int getAdmCor() {
		return admCor;
	}



	@SuppressWarnings("static-access")
	public void setAdmCor(int admCor) {
		this.admCor = admCor;
	}

	private JPanel contentPane;
	private JTextField tLogin;
	private JPasswordField tSenha;
	public static TelaLogin instance;
	public static TelaLogin getInstace() {
		if (TelaLogin.instance == null) {
			return TelaLogin.instance = new TelaLogin();
		}
		return TelaLogin.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		Conexao.getInstance().conectar();

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lLogin = new JLabel("Login:");
		lLogin.setBounds(161, 108, 46, 14);
		contentPane.add(lLogin);

		JLabel lSenha = new JLabel("Senha:");
		lSenha.setBounds(161, 133, 46, 14);
		contentPane.add(lSenha);

		tLogin = new JTextField();
		tLogin.setBounds(217, 105, 86, 20);
		contentPane.add(tLogin);
		tLogin.setColumns(10);

		tSenha = new JPasswordField();
		tSenha.setBounds(217, 130, 86, 20);
		contentPane.add(tSenha);
		tSenha.setColumns(10);

		JButton bAcessar = new JButton("Acessar");
		bAcessar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Fachada.getInstace().getUc().fazerLogin(tLogin.getText(), tSenha.getText()) == true) {
						setCpf(tLogin.getText());

						if(Fachada.getInstace().getAlunoc().isAluno(tLogin.getText()) == true) {
							try {
								
								PainelAluno.getInstace().dispose();
								new PainelAluno().setVisible(true);
								dispose();
								@SuppressWarnings("unused")
								Aluno a ;
								Fachada.getInstace().getAlunoc().buscarAlunos(a = new Aluno(tLogin.getText(),"",0,"", 'W'));
								setCurso_aluno_coord(Fachada.getInstace().getAlunoc().getAr().getAlunoslista().get(0).getCodigo_curso());
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							

						}else if(Fachada.getInstace().getAc().isAdministrador(tLogin.getText()) == true) {
							try {
								if(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).getSenha().equals("ADM")) {
									PrimeiroAcesso.getInstace().setVisible(true);
								}else {
									PainelAdministrador.getInstace().dispose();
									new PainelAdministrador().setVisible(true);
									dispose();
									setAdmCor(1);
								}

							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}else if(Fachada.getInstace().getPc().isProfessor(tLogin.getText()) == true) {
							try {
								
								PainelProfessor.getInstace().dispose();
								new PainelProfessor().setVisible(true);
								dispose();
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}else if (Fachada.getInstace().getCc().isCoordenador(cpf) == true){
							try {
								PainelCoordenador.getInstace().dispose();
								new PainelCoordenador().setVisible(true);
								
								dispose();
								setAdmCor(0);
								@SuppressWarnings("unused")
								Curso curso;
								Fachada.getInstace().getCcurso().buscarCurso(curso = new Curso("","",tLogin.getText()));
								setCurso_aluno_coord(Fachada.getInstace().getCcurso().getCp().getCursosLista().get(0).getCodigo());
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
		
					
						}
					}
				} catch (SenhaErradaException e) {
					JOptionPane.showMessageDialog(null, e.toString());
					e.printStackTrace();
				} catch (cpfErradoException e) {
					JOptionPane.showMessageDialog(null, e.toString());
					e.printStackTrace();
				}

			}
		});
		bAcessar.setBounds(156, 181, 91, 23);
		contentPane.add(bAcessar);

		JLabel lblSega = new JLabel("SEGA");
		lblSega.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSega.setBounds(173, 11, 105, 49);
		contentPane.add(lblSega);

		JLabel lblSistemaEducacionalDe = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		lblSistemaEducacionalDe.setBounds(10, 277, 303, 14);
		contentPane.add(lblSistemaEducacionalDe);


	}
}
