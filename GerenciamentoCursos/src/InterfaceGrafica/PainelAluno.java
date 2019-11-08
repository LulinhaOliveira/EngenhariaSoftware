package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Entidades.Aluno_Oferta_Disciplina;
import Negocio.Entidades.Disciplina;
import Negocio.Fachada.Fachada;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PainelAluno extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cmbDisciplinas = new JComboBox<String>();;
    
	@SuppressWarnings("rawtypes")
	public JComboBox getCmbDisciplinas() {
		return cmbDisciplinas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	
	public void preencheCMB() {
		cmbDisciplinas.removeAllItems();
		Fachada.getInstace().disciplinasAlunos(TelaLogin.getCpf(),"Cursando");
		for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
			cmbDisciplinas.addItem(d.getNome());
		}
		
	}
	/**
	 * Create the frame.
	 */
	public PainelAluno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario(TelaLogin.getCpf());
		preencheCMB();
		
		JButton btnHistrico = new JButton("Hist\u00F3rico");
		btnHistrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAlunoHistorico.getInstace().dispose();
				new PainelAlunoHistorico().setVisible(true);
				
			}
		});
		btnHistrico.setBounds(320, 78, 124, 23);
		contentPane.add(btnHistrico);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAlunoAlterarDados.getInstace().dispose();
				new PainelAlunoAlterarDados().setVisible(true);
				
			}
		});
		btnAlterarDados.setBounds(320, 112, 124, 23);
		contentPane.add(btnAlterarDados);
		
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
		
		cmbDisciplinas.setBounds(227, 178, 217, 22);
		contentPane.add(cmbDisciplinas);
		
		JLabel lblCpf = new JLabel("C.P.F :" + TelaLogin.getCpf());
		lblCpf.setBounds(23, 64, 271, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome : " + (String) Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).getNome());
		lblNome.setBounds(23, 87, 271, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Email : "  + (String)Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).getEmail());
		lblIdade.setBounds(23, 108, 256, 14);
		contentPane.add(lblIdade);
		
		JLabel lblTelefone = new JLabel("Telefone : " + (String)Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).getTelefone());
		lblTelefone.setBounds(23, 150, 139, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblSexo = new JLabel("Sexo : " + Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).getSexo());
		lblSexo.setBounds(23, 125, 66, 14);
		contentPane.add(lblSexo);
		
		JLabel lblPainelDoAluno = new JLabel("Painel Do Aluno");
		lblPainelDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoAluno.setBounds(99, 11, 302, 34);
		contentPane.add(lblPainelDoAluno);
		
		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 277, 303, 14);
		contentPane.add(label);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Aluno_Oferta_Disciplina a;
				int cod = Fachada.getInstace().buscarPosiçãoDisciplina((String) cmbDisciplinas.getSelectedItem());
				
				lblNota1.setText("Nota 1: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_1());
				lblNota.setText("Nota 2: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getNota_2());
				lblMdia.setText("Media : " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getMedia_final());
				lblFrequncia.setText("Falta : " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(cod).getFrequencia());
			}
		});
		btnVer.setBounds(353, 212, 91, 23);
		contentPane.add(btnVer);
		
		JButton btnNewButton = new JButton("Matr\u00EDcula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAlunoMatrícula.getInstace().dispose();
				new PainelAlunoMatrícula().setVisible(true);
			}
		});
		btnNewButton.setBounds(320, 146, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaLogin.setCpf(null);
				TelaLogin.setCurso_aluno_coord(-1);
				TelaLogin.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(18, 11, 47, 23);
		contentPane.add(button);

		
		
		
		
	}
}
