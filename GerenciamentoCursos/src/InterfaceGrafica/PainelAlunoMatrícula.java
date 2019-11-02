package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PainelAlunoMatrícula extends JFrame {

	private JPanel contentPane;
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

	/**
	 * Create the frame.
	 */
	public PainelAlunoMatrícula() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(115, 135, 450, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Painel Do Aluno");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(85, 11, 302, 34);
		contentPane.add(label);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 56, 284, 22);
		contentPane.add(comboBox);
		
		JLabel lblDisciplinas = new JLabel("Disciplinas");
		lblDisciplinas.setBounds(10, 56, 69, 14);
		contentPane.add(lblDisciplinas);
		
		JButton btnMatrcularse = new JButton("Matr\u00EDcular-se");
		btnMatrcularse.setBounds(266, 142, 135, 23);
		contentPane.add(btnMatrcularse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 89, 195, 76);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.setBounds(266, 89, 135, 23);
		contentPane.add(btnNewButton);
		
	}

}
