package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BancoDados.Conexao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
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
		lLogin.setBounds(100, 108, 46, 14);
		contentPane.add(lLogin);
		
		JLabel lSenha = new JLabel("Senha:");
		lSenha.setBounds(100, 133, 46, 14);
		contentPane.add(lSenha);
		
		tLogin = new JTextField();
		tLogin.setBounds(156, 105, 86, 20);
		contentPane.add(tLogin);
		tLogin.setColumns(10);
		
		tSenha = new JPasswordField();
		tSenha.setBounds(156, 130, 86, 20);
		contentPane.add(tSenha);
		tSenha.setColumns(10);
		
		JComboBox <String> cPerfil = new JComboBox <String>();
		cPerfil.setBounds(298, 104, 134, 22);
		contentPane.add(cPerfil);
		cPerfil.addItem("Aluno");
		cPerfil.addItem("Professor");
		cPerfil.addItem("Coordenador");
		cPerfil.addItem("Administrador");
		
		JButton bAcessar = new JButton("Acessar");
		bAcessar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {

				if(cPerfil.getSelectedItem() == "Aluno") {
					dispose();
					PainelAluno.getInstace().setVisible(true);
				}else if(cPerfil.getSelectedItem() == "Professor") {
					dispose();
					PainelProfessor.getInstace().setVisible(true);
				}else if(cPerfil.getSelectedItem() == "Coordenador") {
					dispose();
					setAdmCor(0);
					PainelCoordenador.getInstace().setVisible(true);
				}else if(cPerfil.getSelectedItem() == "Administrador") {
					dispose();
					setAdmCor(1);
					PainelAdministrador.getInstace().setVisible(true);
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
