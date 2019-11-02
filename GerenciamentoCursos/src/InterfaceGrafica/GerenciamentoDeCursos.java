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
public class GerenciamentoDeCursos extends JFrame {

	private JPanel contentPane;
	public static GerenciamentoDeCursos instance;
    public static GerenciamentoDeCursos getInstace() {
    	if (GerenciamentoDeCursos.instance == null) {
			return GerenciamentoDeCursos.instance = new GerenciamentoDeCursos();
		}
		return GerenciamentoDeCursos.instance;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoDeCursos frame = new GerenciamentoDeCursos();
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
	public GerenciamentoDeCursos() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerenciamentoDeCursos = new JLabel("Gerenciamento De Cursos");
		lblGerenciamentoDeCursos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGerenciamentoDeCursos.setBounds(40, 11, 414, 74);
		contentPane.add(lblGerenciamentoDeCursos);
		
		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Cadastro.getInstace().dispose();
					new Cadastro().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastro.setBounds(40, 115, 117, 23);
		contentPane.add(btnCadastro);
		
		JButton btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Buscar.getInstace().dispose();
					new Buscar().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBusca.setBounds(282, 115, 117, 23);
		contentPane.add(btnBusca);
		
		JButton btnInativar = new JButton("Inativar");
		btnInativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Inativa.getInstace().dispose();
					new Inativa().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInativar.setBounds(40, 190, 117, 23);
		contentPane.add(btnInativar);
		
		JButton btnAtualizarDados = new JButton("Atualizar Dados");
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Atualizar.getInstace().dispose();
					new Atualizar().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarDados.setBounds(282, 190, 117, 23);
		contentPane.add(btnAtualizarDados);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(TelaLogin.getInstace().getAdmCor() == 0) {
					PainelCoordenador.getInstace().setVisible(true);	
				}else if (TelaLogin.getInstace().getAdmCor() == 1) {
					PainelAdministrador.getInstace().setVisible(true);	
				}
			}
		});
		button.setBounds(10, 11, 47, 23);
		contentPane.add(button);
	}

}
