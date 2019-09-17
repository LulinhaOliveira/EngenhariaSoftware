package Negocio.Entidades;

public class Aluno_Turma {
	private String cpf;
	private int codigo;
	
	public Aluno_Turma(String cpf, int codigo) {
		this.cpf = cpf;
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
