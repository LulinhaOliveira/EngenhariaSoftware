package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
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
	public static Inativa getInstace() throws Throwable {
		if (Inativa.instance == null) {
			return Inativa.instance = new Inativa();
		}
		return Inativa.instance;
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
					Inativa frame = new Inativa();
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
		
		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			preencheCMB("Cursos");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Turmas do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todas as Turmas (Administrador) (preencherCMB)
			}
			preencheCMB("Disciplinas");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
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
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			preencheCMB("Coordenadores");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Turmas do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todas as Turmas (Administrador) (preencherCMB)
			}
			preencheCMB("Professores");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				//Apenas Turmas do Curso do Coordenador (preencherCMB)
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				//Todas as Turmas (Administrador) (preencherCMB)
			}
			preencheCMB("Alunos");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			preencheCMB("Ofertas");
			btnInativar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		
	}
}
