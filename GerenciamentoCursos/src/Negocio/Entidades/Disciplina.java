package Negocio.Entidades;

public class Disciplina {
	private int codigo; 
	private String nome;
	private String ementa; 
	private int numero_creditos; 
	private char ativo;
	private int codigo_curso; 
	private int codigo_turma;
	
	
	public Disciplina(int codigo, String nome, String ementa, int numero_creditos, char ativo, int codigo_curso,
			int codigo_turma) {
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = ementa;
		this.numero_creditos = numero_creditos;
		this.ativo = ativo;
		this.codigo_curso = codigo_curso;
		this.codigo_turma = codigo_turma;
	}
	public Disciplina(String nome) {
		this.nome = nome;
	}
	public Disciplina(String nome , int codigo_curso){
		this.nome = nome;
		this.codigo_curso = codigo_curso;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public int getNumero_creditos() {
		return numero_creditos;
	}
	public void setNumero_creditos(int numero_creditos) {
		this.numero_creditos = numero_creditos;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public int getCodigo_turma() {
		return codigo_turma;
	}
	public void setCodigo_turma(int codigo_turma) {
		this.codigo_turma = codigo_turma;
	}
	@Override
	public String toString() {
		return "Nome: " + nome + "\nEmenta: " + ementa + "\nNumero_creditos: "
				+ numero_creditos + "\nAtivo: " + ativo + "\nCodigo_curso: " + codigo_curso + "\nCodigo_turma: "
				+ codigo_turma ;
	}
	
	
}
