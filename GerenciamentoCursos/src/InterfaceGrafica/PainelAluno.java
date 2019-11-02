package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PainelAluno extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbDisciplinas;
    
	@SuppressWarnings("rawtypes")
	public JComboBox getCmbDisciplinas() {
		return cmbDisciplinas;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbDisciplinas(JComboBox cmbDisciplinas) {
		this.cmbDisciplinas = cmbDisciplinas;
	}

	public static PainelAluno instance;
    public static PainelAluno getInstace() {
    	if (PainelAluno.instance == null) {
			return PainelAluno.instance = new PainelAluno();
		}
		return PainelAluno.instance;
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAluno frame = new PainelAluno();
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
	@SuppressWarnings("rawtypes")
	public PainelAluno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHistrico = new JButton("Hist\u00F3rico");
		btnHistrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAlunoHistorico.getInstace().setVisible(true);
				
			}
		});
		btnHistrico.setBounds(320, 78, 124, 23);
		contentPane.add(btnHistrico);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAlunoAlterarDados.getInstace().setVisible(true);
			}
		});
		btnAlterarDados.setBounds(320, 112, 124, 23);
		contentPane.add(btnAlterarDados);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(23, 216, 325, 14);
		contentPane.add(lblProfessor);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(23, 241, 90, 14);
		contentPane.add(lblNota1);
		
		JLabel lblNota = new JLabel("Nota 2:");
		lblNota.setBounds(123, 241, 94, 14);
		contentPane.add(lblNota);
		
		JLabel lblMdia = new JLabel("M\u00E9dia:");
		lblMdia.setBounds(227, 241, 90, 14);
		contentPane.add(lblMdia);
		
		JLabel lblFrequncia = new JLabel("Frequ\u00EAncia: ");
		lblFrequncia.setBounds(328, 241, 116, 14);
		contentPane.add(lblFrequncia);
		
		cmbDisciplinas = new JComboBox();
		cmbDisciplinas.setBounds(267, 178, 177, 22);
		contentPane.add(cmbDisciplinas);
		
		JLabel lblCpf = new JLabel("C.P.F :");
		lblCpf.setBounds(23, 64, 271, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(23, 82, 271, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade :");
		lblIdade.setBounds(23, 96, 66, 14);
		contentPane.add(lblIdade);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(171, 96, 139, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(23, 112, 287, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSexo = new JLabel("Sexo : ");
		lblSexo.setBounds(103, 96, 66, 14);
		contentPane.add(lblSexo);
		
		JLabel lblPainelDoAluno = new JLabel("Painel Do Aluno");
		lblPainelDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoAluno.setBounds(99, 11, 302, 34);
		contentPane.add(lblPainelDoAluno);
		
		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 277, 303, 14);
		contentPane.add(label);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(353, 212, 91, 23);
		contentPane.add(btnVer);
		
		JButton btnNewButton = new JButton("Matr\u00EDcula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAlunoMatrícula.getInstace().setVisible(true);
			}
		});
		btnNewButton.setBounds(320, 146, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin.setCpf(null);
				TelaLogin.setCurso_aluno_coord(-1);
				TelaLogin.getInstace().setVisible(true);
			}
		});
		button.setBounds(18, 11, 47, 23);
		contentPane.add(button);

		
	}
}
