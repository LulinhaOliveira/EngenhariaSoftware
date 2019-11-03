package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField tvalorNota1;
	private JTextField tvalorNota2;
	public static PainelProfessor instance;
    public static PainelProfessor getInstace() {
    	if (PainelProfessor.instance == null) {
			return PainelProfessor.instance = new PainelProfessor();
		}
		return PainelProfessor.instance;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelProfessor frame = new PainelProfessor();
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
	public PainelProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDoProfessor = new JLabel("Painel Do Professor");
		lblPainelDoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainelDoProfessor.setBounds(59, 11, 363, 34);
		contentPane.add(lblPainelDoProfessor);
		
		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbDisciplinasOfertadas = new JComboBox();
		cmbDisciplinasOfertadas.setBounds(66, 56, 303, 22);
		contentPane.add(cmbDisciplinasOfertadas);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbAlunos = new JComboBox();
		cmbAlunos.setBounds(66, 123, 303, 22);
		contentPane.add(cmbAlunos);
		
		JButton btnAtribuirFalta = new JButton("Atribuir Falta");
		btnAtribuirFalta.setBounds(296, 216, 126, 23);
		contentPane.add(btnAtribuirFalta);
		
		JLabel lblFrequncia = new JLabel("Frequ\u00EAncia:");
		lblFrequncia.setBounds(297, 191, 106, 14);
		contentPane.add(lblFrequncia);
		
		JLabel lblNota = new JLabel("Nota 1:");
		lblNota.setBounds(9, 194, 47, 14);
		contentPane.add(lblNota);
		
		JLabel lblNota_1 = new JLabel("Nota 2:");
		lblNota_1.setBounds(10, 220, 46, 14);
		contentPane.add(lblNota_1);
		
		tvalorNota1 = new JTextField();
		tvalorNota1.setBounds(52, 191, 86, 20);
		contentPane.add(tvalorNota1);
		tvalorNota1.setColumns(10);
		
		tvalorNota2 = new JTextField();
		tvalorNota2.setBounds(52, 217, 86, 20);
		contentPane.add(tvalorNota2);
		tvalorNota2.setColumns(10);
		
		JButton btnAtribuirNota = new JButton("Atribuir Nota");
		btnAtribuirNota.setBounds(148, 190, 121, 23);
		contentPane.add(btnAtribuirNota);
		
		JButton bAtribuirNota = new JButton("Atribuir Nota");
		bAtribuirNota.setBounds(148, 216, 121, 23);
		contentPane.add(bAtribuirNota);
		
		JButton btnBuscarAlunos = new JButton("Buscar Alunos");
		btnBuscarAlunos.setBounds(148, 89, 126, 23);
		contentPane.add(btnBuscarAlunos);
		
		JButton btnNewButton = new JButton("Ver Situa\u00E7\u00E3o");
		btnNewButton.setBounds(148, 156, 126, 23);
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
		button.setBounds(10, 11, 47, 23);
		contentPane.add(button);
	}

}
