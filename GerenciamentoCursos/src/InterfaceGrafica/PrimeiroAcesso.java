package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada.Fachada;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class PrimeiroAcesso extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	public static PrimeiroAcesso instance;
	public static PrimeiroAcesso getInstace() {
		if (PrimeiroAcesso.instance == null) {
			return PrimeiroAcesso.instance = new PrimeiroAcesso();
		}
		return PrimeiroAcesso.instance;
	}
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JPasswordField();
		textField.setBounds(97, 126, 237, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNovaSenha = new JButton("Nova Senha");
		btnNovaSenha.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstace().getUc().atualizarUsuario("00000000000", "", "", "", textField.getText());
			}
		});
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
