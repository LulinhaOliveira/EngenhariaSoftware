package InterfaceGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	JComboBox <String> comboBox = new JComboBox <String>();
	public static Buscar instance;
	public static Buscar getInstace() throws Throwable {
		if (Buscar.instance == null) {
			return Buscar.instance = new Buscar();
		}
		return Buscar.instance;
	}
	
	public void preencheCMB(String nome) {
		comboBox.addItem(nome);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox.setBounds(29, 48, 380, 22);
		contentPane.add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(173, 225, 91, 23);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 92, 380, 120);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JLabel lblInativar = new JLabel("Buscar");
		lblInativar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInativar.setBounds(156, 0, 169, 37);
		contentPane.add(lblInativar);

		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			preencheCMB("Cursos");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Disciplinas do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todas as Disciplinas (Administrador) (preencherCMB)
			}
			preencheCMB("Disciplinas");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Turmas do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todas as Turmas (Administrador) (preencherCMB)
			}
			preencheCMB("Turmas");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			preencheCMB("Coordenadores");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Professores do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todos os Professores (Administrador) (preencherCMB)
			}
			preencheCMB("Professores");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Alunos do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todos os Alunos (Administrador) (preencherCMB)
			}
			preencheCMB("Alunos");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			preencheCMB("Ofertas");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
		}
	}

}
