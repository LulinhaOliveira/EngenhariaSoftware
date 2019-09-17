package Negocio.Entidades;

public class Turma {
	private int codigo; 
	private String nome; 
	private String sigla; 
	private String turno; 
	private String semestre; 
	private char ativo;
	
	
	public Turma(int codigo, String nome, String sigla, String turno, String semestre, char ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
		this.turno = turno;
		this.semestre = semestre;
		this.ativo = ativo;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
}
