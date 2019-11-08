package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PainelAlunoHistorico extends JFrame {

	private JPanel contentPane;
	JScrollPane scrollPane = new JScrollPane();
	JTextArea textArea = new JTextArea(); 
	public static PainelAlunoHistorico instance;
	    public static PainelAlunoHistorico getInstace() {
	    	if (PainelAlunoHistorico.instance == null) {
				return PainelAlunoHistorico.instance = new PainelAlunoHistorico();
			}
			return PainelAlunoHistorico.instance;
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAlunoHistorico frame = new PainelAlunoHistorico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void preencherTextArea() {
		textArea.removeAll();
		
		Fachada.getInstace().disciplinasAlunos(TelaLogin.getCpf(),"");
		
		for(int i = 0 ; i <  Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().size() ; i++) {
			textArea.setText(textArea.getText() + "Nome Disciplina: " + Fachada.getInstace().getDc().getDr().getDisciplinaLista().get(i).getNome() 
					+ "\n Nota 1: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(i).getNota_1()
					+ "\n Nota 2: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(i).getNota_2()
					+ "\n Media: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(i).getMedia_final()
					+ "\n Faltas: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(i).getFrequencia()
					+ "\n Situação: " + Fachada.getInstace().getAodc().getAod().getAluno_oferta_disciplinaLista().get(i).getAtivo()
					+ "\n\n"
					);
		}
		
	}
	/**
	 * Create the frame.
	 */
	public PainelAlunoHistorico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Painel Do Aluno");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(92, 11, 302, 34);
		contentPane.add(label);
		
		JLabel lblHistrico = new JLabel("Hist\u00F3rico");
		lblHistrico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistrico.setBounds(150, 56, 105, 25);
		contentPane.add(lblHistrico);
		
		scrollPane.setBounds(29, 92, 351, 120);
		contentPane.add(scrollPane);
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel label_1 = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label_1.setBounds(10, 223, 303, 14);
		contentPane.add(label_1);
		
		preencherTextArea();
		
	}
}
