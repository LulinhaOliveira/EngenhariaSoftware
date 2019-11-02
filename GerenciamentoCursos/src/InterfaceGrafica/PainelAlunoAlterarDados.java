package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PainelAlunoAlterarDados extends JFrame {

	private JPanel contentPane;
	private JTextField tEmail;
	private JTextField tTelefone;
	private JTextField textField;
	public static PainelAlunoAlterarDados instance;
    public static PainelAlunoAlterarDados getInstace() {
    	if (PainelAlunoAlterarDados.instance == null) {
			return PainelAlunoAlterarDados.instance = new PainelAlunoAlterarDados();
		}
		return PainelAlunoAlterarDados.instance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAlunoAlterarDados frame = new PainelAlunoAlterarDados();
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
	public PainelAlunoAlterarDados() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(135, 140, 406, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Painel Do Aluno");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(80, 11, 302, 34);
		contentPane.add(label);
		
		JLabel lblNovoEmail = new JLabel("Novo Email:");
		lblNovoEmail.setBounds(20, 80, 91, 14);
		contentPane.add(lblNovoEmail);
		
		tEmail = new JTextField();
		tEmail.setBounds(148, 77, 173, 20);
		contentPane.add(tEmail);
		tEmail.setColumns(10);
		
		JLabel lblnovoTelefone = new JLabel("Novo Telefone:");
		lblnovoTelefone.setBounds(20, 107, 91, 14);
		contentPane.add(lblnovoTelefone);
		
		tTelefone = new JTextField();
		tTelefone.setBounds(148, 104, 173, 20);
		contentPane.add(tTelefone);
		tTelefone.setColumns(10);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(20, 136, 91, 14);
		contentPane.add(lblNovaSenha);
		
		textField = new JTextField();
		textField.setBounds(148, 135, 173, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(20, 166, 91, 23);
		contentPane.add(btnAlterar);
		
		JLabel label_1 = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label_1.setBounds(10, 201, 303, 14);
		contentPane.add(label_1);
	}

}
