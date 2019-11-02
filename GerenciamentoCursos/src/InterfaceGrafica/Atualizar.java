package InterfaceGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Atualizar extends JFrame {

	private JPanel contentPane;
	JComboBox <String> comboBox = new JComboBox <String>();
	public static Atualizar instance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static Atualizar getInstace() {
		if (Atualizar.instance == null) {
			return Atualizar.instance = new Atualizar();
		}
		return Atualizar.instance;
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
					Atualizar frame = new Atualizar();
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
	public Atualizar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox.setBounds(29, 55, 380, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 131, 162, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(283, 228, 89, 23);
		contentPane.add(btnAtualizar);
		
		JLabel lblAtualizao = new JLabel("Atualiza\u00E7\u00E3o");
		lblAtualizao.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAtualizao.setBounds(136, 11, 178, 47);
		contentPane.add(lblAtualizao);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVer.setBounds(67, 88, 89, 23);
		contentPane.add(btnVer);

		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Horario:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Coordenador:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Ementa:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Creditos:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Sigla:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Turno:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
	
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Nome:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(210, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JPasswordField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			JLabel lblNewLabel_2 = new JLabel("Dia 1:");
			lblNewLabel_2.setBounds(214, 92, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Dia 2:");
			lblNewLabel_3.setBounds(214, 120, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Hora 1:");
			lblNewLabel_4.setBounds(214, 145, 130, 14);
			contentPane.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(283, 89, 141, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(283, 117, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JPasswordField();
			textField_2.setBounds(283, 142, 141, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblHora = new JLabel("Hora 2:");
			lblHora.setBounds(214, 170, 46, 14);
			contentPane.add(lblHora);
			
			textField_3 = new JTextField();
			textField_3.setBounds(283, 170, 141, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblProfessor = new JLabel("Professor:");
			lblProfessor.setBounds(214, 199, 61, 14);
			contentPane.add(lblProfessor);
			
			textField_4 = new JTextField();
			textField_4.setBounds(283, 197, 141, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
		}
		
	}
}

/*
JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setBounds(162, 87, 140, 14);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setBounds(162, 126, 140, 14);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("");
lblNewLabel_4.setBounds(172, 163, 130, 14);
contentPane.add(lblNewLabel_4);

textField = new JTextField();
textField.setBounds(10, 87, 130, 20);
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(10, 140, 130, 20);
contentPane.add(textField_1);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setBounds(10, 190, 130, 20);
contentPane.add(textField_2);
textField_2.setColumns(10);

textField_3 = new JTextField();
textField_3.setBounds(318, 87, 114, 20);
contentPane.add(textField_3);
textField_3.setColumns(10);

textField_4 = new JTextField();
textField_4.setBounds(318, 123, 114, 20);
contentPane.add(textField_4);
textField_4.setColumns(10);

textField_5 = new JTextField();
textField_5.setBounds(318, 157, 114, 20);
contentPane.add(textField_5);
textField_5.setColumns(10);	
 */