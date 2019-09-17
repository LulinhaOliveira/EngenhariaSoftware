package Negocio.Entidades;

public class Aluno_Oferta_Disciplina {
	private String cpf; 
	private int codigo; 
	private double nota_1;
	private double nota_2; 
	private double media_final; 
	private int frequencia; 
	private char ativo;
	
	public Aluno_Oferta_Disciplina(String cpf, int codigo, double nota_1, double nota_2, double media_final,
			int frequencia, char ativo) {
		super();
		this.cpf = cpf;
		this.codigo = codigo;
		this.nota_1 = nota_1;
		this.nota_2 = nota_2;
		this.media_final = media_final;
		this.frequencia = frequencia;
		this.ativo = ativo;
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
	public double getNota_1() {
		return nota_1;
	}
	public void setNota_1(double nota_1) {
		this.nota_1 = nota_1;
	}
	public double getNota_2() {
		return nota_2;
	}
	public void setNota_2(double nota_2) {
		this.nota_2 = nota_2;
	}
	public double getMedia_final() {
		return media_final;
	}
	public void setMedia_final(double media_final) {
		this.media_final = media_final;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	} 
}
