package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class PrimeiroAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiroAcesso frame = new PrimeiroAcesso();
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
	public PrimeiroAcesso() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(97, 126, 237, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNovaSenha = new JButton("Nova Senha");
		btnNovaSenha.setBounds(151, 201, 133, 23);
		contentPane.add(btnNovaSenha);
		
		JLabel lblDigiteSuaSenha = new JLabel("Digite sua Senha:");
		lblDigiteSuaSenha.setBounds(97, 101, 84, 14);
		contentPane.add(lblDigiteSuaSenha);
		
		JLabel lblPrimeiroAcesso = new JLabel("Primeiro Acesso");
		lblPrimeiroAcesso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrimeiroAcesso.setBounds(115, 11, 248, 37);
		contentPane.add(lblPrimeiroAcesso);
	}
}
