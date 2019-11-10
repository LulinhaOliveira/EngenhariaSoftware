package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Exception.CampoVazioException;
import Exception.qtdAlunoDisciplinaMaxException;
import Negocio.Entidades.Aluno_Oferta_Disciplina;
import Negocio.Entidades.Disciplina;
import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PainelAlunoMatrícula extends JFrame {

	private JPanel contentPane;
	JComboBox <String> comboBox = new JComboBox <String >();
	JTextArea textArea = new JTextArea();
	public static PainelAlunoMatrícula instance;
	public static PainelAlunoMatrícula getInstace() {
		if (PainelAlunoMatrícula.instance == null) {
			return PainelAlunoMatrícula.instance = new PainelAlunoMatrícula();
		}
		return PainelAlunoMatrícula.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAlunoMatrícula frame = new PainelAlunoMatrícula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void preencheCMB() {
		Fachada.getInstace().disciplinasOfertadas("",TelaLogin.getCurso_aluno_coord(),'S');

		for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
			comboBox.addItem(d.getNome());
		}
	}


	/**
	 * Create the frame.
	 */
	public PainelAlunoMatrícula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Painel Do Aluno");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(130, 11, 302, 34);
		contentPane.add(label);


		comboBox.setBounds(95, 56, 284, 22);
		contentPane.add(comboBox);

		JLabel lblDisciplinas = new JLabel("Disciplinas");
		lblDisciplinas.setBounds(10, 56, 69, 14);
		contentPane.add(lblDisciplinas);

		JButton btnMatrcularse = new JButton("Matr\u00EDcular-se");
		btnMatrcularse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Aluno_Oferta_Disciplina a ;
				try {
					int pos = Fachada.getInstace().buscarPosiçãoDisciplina((String) comboBox.getSelectedItem());
					try {
						Fachada.getInstace().matriculaAluno(a =  new Aluno_Oferta_Disciplina(TelaLogin.getCpf(),Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(pos).getCodigo(),0,0,0,0,"Cursando"));
					} catch (qtdAlunoDisciplinaMaxException e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
					}
				} catch (CampoVazioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PainelAluno.getInstace().preencheCMB();

			}
		});
		btnMatrcularse.setBounds(266, 142, 135, 23);
		contentPane.add(btnMatrcularse);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 89, 195, 76);
		contentPane.add(scrollPane);


		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		preencheCMB();
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod = Fachada.getInstace().buscarPosiçãoDisciplina((String)comboBox.getSelectedItem());

				textArea.setText("Dia 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_1() 
						+ "\nDia 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_2() 
						+ "\nHora 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_1()
						+ "\nHora 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_2()
						);

			}
		});
		btnNewButton.setBounds(266, 89, 135, 23);
		contentPane.add(btnNewButton);
		
		 addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	                PainelAluno.getInstace().preencheCMB();
	                e.getWindow().dispose();
	            }
	        });
	
	}
}
