package Negocio.Entidades;

public class Curso {
	private int codigo ;
	private String nome; 
	private String horario_funcionamento; 
	private char ativo = 's' ;
	private String cpf_coordenador;
	
	public Curso(int codigo, String nome, String horario_funcionamento, char ativo, String cpf_coordenador) {
		this.codigo = codigo;
		this.nome = nome;
		this.horario_funcionamento = horario_funcionamento;
		this.ativo = ativo;
		this.cpf_coordenador = cpf_coordenador;
	}
	
	public Curso (String nome, String horario_funcionamento, String cpf_coordenador) {
		this.nome = nome;
		this.horario_funcionamento = horario_funcionamento;
		this.cpf_coordenador = cpf_coordenador;
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
	public String getHorario_funcionamento() {
		return horario_funcionamento;
	}
	public void setHorario_funcionamento(String horario_funcionamento) {
		this.horario_funcionamento = horario_funcionamento;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public String getCpf_coordenador() {
		return cpf_coordenador;
	}
	public void setCpf_coordenador(String cpf_coordenador) {
		this.cpf_coordenador = cpf_coordenador;
	}
}
