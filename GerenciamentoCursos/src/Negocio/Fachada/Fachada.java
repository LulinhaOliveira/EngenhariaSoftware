package Negocio.Fachada;


import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Exception.CampoVazioException;
import Exception.TurmaExisteAlunoException;
import Exception.qtdAlunoDisciplinaMaxException;
import Negocio.AdministradorControle;
import Negocio.AlunoControle;
import Negocio.Aluno_Oferta_DisciplinaControle;
import Negocio.Aluno_TurmaControle;
import Negocio.CoordenadorControle;
import Negocio.CursoControle;
import Negocio.DisciplinaControle;
import Negocio.Oferta_DisciplinaControle;
import Negocio.ProfessorControle;
import Negocio.TurmaControle;
import Negocio.UsuarioControle;
import Negocio.Entidades.Aluno;
import Negocio.Entidades.Aluno_Oferta_Disciplina;
import Negocio.Entidades.Aluno_Turma;
import Negocio.Entidades.Coordenador;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Oferta_Disciplina;
import Negocio.Entidades.Usuario;

public class Fachada {

	private AdministradorControle ac = new AdministradorControle();
	private Aluno_Oferta_DisciplinaControle aodc = new Aluno_Oferta_DisciplinaControle();
	private Aluno_TurmaControle atc = new Aluno_TurmaControle();
	private AlunoControle alunoc = new AlunoControle();
	private CoordenadorControle cc = new CoordenadorControle();
	private CursoControle ccurso = new CursoControle();
	private DisciplinaControle dc = new DisciplinaControle();
	private Oferta_DisciplinaControle odc = new Oferta_DisciplinaControle();
	private ProfessorControle pc = new ProfessorControle();
	private TurmaControle tc = new TurmaControle();
	private UsuarioControle uc = new UsuarioControle();
	public static Fachada instance;
	public static Fachada getInstace() {
		if (Fachada.instance == null) {
			return Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}



	public Fachada (){
		ac = new AdministradorControle();
		atc = new Aluno_TurmaControle();
		aodc = new Aluno_Oferta_DisciplinaControle();
		alunoc = new AlunoControle();
		ccurso = new CursoControle();
		cc = new CoordenadorControle();
		dc = new DisciplinaControle();
		odc = new Oferta_DisciplinaControle();
		pc = new ProfessorControle();
		tc = new TurmaControle();
		uc = new UsuarioControle();

	}


	public AdministradorControle getAc() {
		return ac;
	}


	public void setAc(AdministradorControle ac) {
		this.ac = ac;
	}


	public Aluno_Oferta_DisciplinaControle getAodc() {
		return aodc;
	}


	public void setAodc(Aluno_Oferta_DisciplinaControle aodc) {
		this.aodc = aodc;
	}


	public Aluno_TurmaControle getAtc() {
		return atc;
	}


	public void setAtc(Aluno_TurmaControle atc) {
		this.atc = atc;
	}


	public AlunoControle getAlunoc() {
		return alunoc;
	}


	public void setAlunoc(AlunoControle alunoc) {
		this.alunoc = alunoc;
	}


	public CoordenadorControle getCc() {
		return cc;
	}


	public void setCc(CoordenadorControle cc) {
		this.cc = cc;
	}


	public CursoControle getCcurso() {
		return ccurso;
	}


	public void setCcurso(CursoControle ccurso) {
		this.ccurso = ccurso;
	}


	public DisciplinaControle getDc() {
		return dc;
	}


	public void setDc(DisciplinaControle dc) {
		this.dc = dc;
	}


	public Oferta_DisciplinaControle getOdc() {
		return odc;
	}


	public void setOdc(Oferta_DisciplinaControle odc) {
		this.odc = odc;
	}


	public ProfessorControle getPc() {
		return pc;
	}


	public void setPc(ProfessorControle pc) {
		this.pc = pc;
	}


	public TurmaControle getTc() {
		return tc;
	}


	public void setTc(TurmaControle tc) {
		this.tc = tc;
	}


	public UsuarioControle getUc() {
		return uc;
	}


	public void setUc(UsuarioControle uc) {
		this.uc = uc;
	}


	public void disciplinasAlunos(String cpf, String status) {

		dc.getDr().getDisciplinaLista().clear();
		aodc.getAod().getAluno_oferta_disciplinaLista().clear();

		String sql = "SELECT * FROM aluno_oferta_disciplina JOIN disciplina ON aluno_oferta_disciplina.codigo = disciplina.codigo WHERE "
				+ "aluno_oferta_disciplina.cpf =  '" + cpf + "'";

		if(status != null && !status.trim().equals("")) {
			sql += "AND aluno_oferta_disciplina.ativo = '" + "Cursando" + "'";
		}

		Aluno_Oferta_Disciplina aluno_oferta_disciplina;
		Disciplina disciplina;

		Conexao.getInstance().buscarSQL(sql);

		try {
			while(Conexao.getInstance().getResultset().next()) {
				aluno_oferta_disciplina = new Aluno_Oferta_Disciplina(Conexao.getInstance().getResultset().getString("cpf"),Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_1")),
						Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_2")), Double.parseDouble(Conexao.getInstance().getResultset().getString("media_final")), 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("frequencia")),
						Conexao.getInstance().getResultset().getString("ativo"));
				aodc.getAod().getAluno_oferta_disciplinaLista().add(aluno_oferta_disciplina);

				disciplina = new Disciplina(0
						,Conexao.getInstance().getResultset().getString("nome")
						,"",0,'W',0,0);
				dc.getDr().getDisciplinaLista().add(disciplina);

			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);


	}

	public int buscarPosiçãoDisciplina(String nome) {
		int cont = 0;


		for(Disciplina a : dc.getDr().getDisciplinaLista()) {
			if(!(a.getNome().equals(nome))) {
				cont++;
			}else {
				return cont;
			}
		}

		return 0;

	}

	public int buscarPosicaoAluno(String nome) {
		int cont = 0;

		for(Usuario u : uc.getUsuarioRepositorio().getListaUsuario()){
			if(!(u.getNome().equals(nome))) {
				cont++;
			}else {
				return cont;
			}

		}
		return 0;
	}
	public void disciplinasOfertadas(String cpf, int codigo, char ativo) {
		String sql = "SELECT * FROM oferta_disciplina JOIN disciplina ON oferta_disciplina.codigo = disciplina.codigo";
		int aux = 0;
		Oferta_Disciplina oferta;
		odc.getOd().getOferta_disciplinalista().clear();
		dc.getDr().getDisciplinaLista().clear();

		if(cpf != null & !cpf.trim().equals("")) {
			sql += " WHERE oferta_disciplina.cpf = '" + cpf + "'";
			aux = 1;
		}
		if(ativo == 'S' ) {
			if(aux == 0) {
				sql += " WHERE oferta_disciplina.ativo = 'S'";
				aux = 1;
			}else {
				sql += " AND oferta_disciplina.ativo = 'S'";
			}
		}
		if(codigo != 0) {
			if(aux == 0) {
				sql += "WHERE disciplina.codigo_curso = " + codigo;
			}else {
				sql += "AND disciplina.codigo_curso = " + codigo; 
			}
		}
		Disciplina disciplina;
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				oferta = new Oferta_Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")), Conexao.getInstance().getResultset().getString("dia_1")
						,Conexao.getInstance().getResultset().getString("dia_2"),Conexao.getInstance().getResultset().getString("hora_1"),Conexao.getInstance().getResultset().getString("hora_2"),Conexao.getInstance().getResultset().getString("ativo").charAt(0),
						Conexao.getInstance().getResultset().getString("cpf"));
				odc.getOd().getOferta_disciplinalista().add(oferta);

				disciplina = new Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo"))
						,Conexao.getInstance().getResultset().getString("nome")
						,"",0,'W',0,0);
				dc.getDr().getDisciplinaLista().add(disciplina);

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
	}

	public void alunosDisciplina(String nomedisciplina) {
		Fachada.getInstace().getDc().getDr().getDisciplinaLista().clear();
		int codigo = Fachada.getInstace().getDc().buscarCodigo(nomedisciplina);;

		String sql = "SELECT * FROM aluno_oferta_disciplina JOIN usuario ON aluno_oferta_disciplina.cpf = usuario.cpf WHERE aluno_oferta_disciplina.codigo = " + codigo ;

		Aluno_Oferta_Disciplina aluno_disciplina;
		Usuario usuario;
		aodc.getAod().getAluno_oferta_disciplinaLista().clear();
		uc.getUsuarioRepositorio().getListaUsuario().clear();

		Conexao.getInstance().buscarSQL(sql);

		try {
			while(Conexao.getInstance().getResultset().next()) {
				aluno_disciplina = new Aluno_Oferta_Disciplina(Conexao.getInstance().getResultset().getString("cpf"),Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_1")),
						Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_2")), Double.parseDouble(Conexao.getInstance().getResultset().getString("media_final")), 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("frequencia")),
						Conexao.getInstance().getResultset().getString("ativo"));
				aodc.getAod().getAluno_oferta_disciplinaLista().add(aluno_disciplina);

				usuario = new Usuario(Conexao.getInstance().getResultset().getString("cpf"), Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("email"), Conexao.getInstance().getResultset().getString("sexo").charAt(0), 
						Conexao.getInstance().getResultset().getString("telefone"),
						Conexao.getInstance().getResultset().getString("senha"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				uc.getUsuarioRepositorio().getListaUsuario().add(usuario);

			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);


	}

	public void inativarOferta(int codigo2) {
		String sql = "SELECT COUNT(*) as cont FROM aluno_oferta_disciplina JOIN oferta_disciplina ON aluno_oferta_disciplina.codigo = oferta_disciplina.codigo WHERE aluno_oferta_disciplina.ativo = 'Cursando' AND aluno_oferta_disciplina.codigo = " + codigo2;
		int codigo = -1;

		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				codigo = Integer.parseInt(Conexao.getInstance().getResultset().getString("cont"));
			}
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);

		if(codigo == 0) {
			odc.inativarOferta_Disciplina(codigo2);
		}

	}

	public void definirSituacao() {
		@SuppressWarnings("unused")
		Aluno_Oferta_Disciplina a;
		aodc.buscarAluno_Disciplina(a = new Aluno_Oferta_Disciplina(""));

		for(Aluno_Oferta_Disciplina a2 : aodc.getAod().getAluno_oferta_disciplinaLista()) {
			aodc.alterarStatus(a2);
		}

	}



	public void buscarPerfil(String type, char ativo, int codigo) {
		String sql = "SELECT usuario.* FROM usuario JOIN ";
		Usuario usuario;
		int aux = 0;
		if(type.equals("coordenador")) {
			sql += "coordenador ON usuario.cpf = coordenador.cpf";
		}else if(type.equals("professor")) {
			sql += "professor ON usuario.cpf = professor.cpf";
		}else if(type.equals("aluno")) {
			sql += "aluno ON usuario.cpf = aluno.cpf";
		}
		if(ativo == 'S') {
			sql += " WHERE usuario.ativo = 'S'";
			aux = 1;
		}

		if(codigo != 0) {
			if(aux == 0) {
				sql += " WHERE aluno.codigo_curso = " + codigo;
			}else {
				sql += " AND aluno.codigo_curso = " + codigo;
			}
		}

		Conexao.getInstance().buscarSQL(sql);
		uc.getUsuarioRepositorio().getListaUsuario().clear();

		try {
			while (Conexao.getInstance().getResultset().next()) {

				usuario = new Usuario(Conexao.getInstance().getResultset().getString("cpf"), Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("email"), Conexao.getInstance().getResultset().getString("sexo").charAt(0), 
						Conexao.getInstance().getResultset().getString("telefone"),
						Conexao.getInstance().getResultset().getString("senha"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				uc.getUsuarioRepositorio().getListaUsuario().add(usuario);

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Conexao.getInstance().setResultset(null);
	}

	public boolean ofertaExiste(int codigo) {
		String sql = "SELECT COUNT(*) as cont FROM oferta_disciplina WHERE oferta_disciplina.codigo = " + codigo;
		int cont = -1;
		Conexao.getInstance().buscarSQL(sql);

		try {
			while(Conexao.getInstance().getResultset().next()) {
				cont = Integer.parseInt(Conexao.getInstance().getResultset().getString("cont"));
			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Conexao.getInstance().setResultset(null);
		if(cont == 0) {
			return false;
		}

		return true;



	}
	public void cadastrarOferta(String nomeDisciplina, String nomeProfessor, String dia_1, String dia_2, String hora_1, String hora_2) {
		Oferta_Disciplina o;

		int cod = dc.buscarCodigo(nomeDisciplina);

		String cpf =  uc.buscarCodigo(nomeProfessor);

		o = new Oferta_Disciplina(cod, dia_1, dia_2, hora_1, hora_2,'S',cpf); 

		if(ofertaExiste(cod) == true) {
			odc.atualizarOferta_Disciplina(o, cod);
		}else {
			try {
				odc.inserirOferta_Disciplina(o);
			} catch (CampoVazioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void cadastrarAluno(String cpf, String nome, String telefone, String email, String password, char sexo, int codigo_curso) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add(cpf);
		myList.add(nome);
		myList.add(email);
		myList.add(sexo);
		myList.add(telefone);
		myList.add(password);

		uc.inserirUsuario(myList);
		Aluno a = new Aluno(cpf,"CURDATE()",codigo_curso,cpf,'S');



		try {
			alunoc.inserirAluno(a);
		} catch (CampoVazioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cadastrarProfessor(String cpf, String nome, String telefone, String email, String password, char sexo) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add(cpf);
		myList.add(nome);
		myList.add(email);
		myList.add(sexo);
		myList.add(telefone);
		myList.add(password);

		uc.inserirUsuario(myList);

		pc.inserirProfessor(cpf);
	}
	public void cadastrarCoordenador(String cpf, String nome, String telefone, String email, String password, char sexo) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add(cpf);
		myList.add(nome);
		myList.add(email);
		myList.add(sexo);
		myList.add(telefone);
		myList.add(password);

		uc.inserirUsuario(myList);

		Coordenador c = new Coordenador(cpf);
		try {
			cc.inserirCoordenador(c);
		} catch (CampoVazioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void matriculaPrimeiroPeriodo(int codigo_curso, String cpf) {
		String sql = "SELECT * FROM oferta_disciplina JOIN disciplina ON"
				+ " oferta_disciplina.codigo = disciplina.codigo JOIN turma ON disciplina.codigo_turma = turma.codigo WHERE"
				+ " disciplina.codigo_curso = " + codigo_curso + " AND turma.semestre = 1" ;
		Oferta_Disciplina oferta;
		Disciplina disciplina;
		odc.getOd().getOferta_disciplinalista().clear();
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				oferta = new Oferta_Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")), Conexao.getInstance().getResultset().getString("dia_1")
						,Conexao.getInstance().getResultset().getString("dia_2"),Conexao.getInstance().getResultset().getString("hora_1"),Conexao.getInstance().getResultset().getString("hora_2"),Conexao.getInstance().getResultset().getString("ativo").charAt(0),
						Conexao.getInstance().getResultset().getString("cpf"));
				odc.getOd().getOferta_disciplinalista().add(oferta);
				
				disciplina =  new Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo"))
						,Conexao.getInstance().getResultset().getString("nome")
						,Conexao.getInstance().getResultset().getString("ementa")
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("num_creditos"))
						,Conexao.getInstance().getResultset().getString("ativo").charAt(0)
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_curso"))
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_turma")));
					dc.getDr().getDisciplinaLista().add(disciplina);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);

		int cont = 0;
	
		@SuppressWarnings("unused")
		Aluno_Oferta_Disciplina a;
		@SuppressWarnings("unused")
		Aluno_Turma at;
		for(Oferta_Disciplina od : Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista()) {
			if(cont < 5) {
				try {
					aodc.inserirAluno_Disciplina(a = new Aluno_Oferta_Disciplina(cpf, od.getCodigo(),0,0,0,0,"Cursando"));
					atc.inserirAluno_Turma(cpf,dc.getDr().getDisciplinaLista().get(cont).getCodigo_turma());
				} catch (CampoVazioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cont++;
			}else {
				break;
			}
		}
	}
	
	public int qtdAluno_Disciplina(String cpf) {
		int qtd = 0;
		String sql = "SELECT COUNT(*) as cont FROM aluno_oferta_disciplina WHERE aluno_oferta_disciplina.cpf = '" + cpf + "' AND aluno_oferta_disciplina = 'Cursando'";
		Conexao.getInstance().buscarSQL(sql);
		
		try {
			while(Conexao.getInstance().getResultset().next()) {
				qtd = Integer.parseInt(Conexao.getInstance().getResultset().getString("cont"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
				
				
		return qtd;
	}

	public void matriculaAluno(Aluno_Oferta_Disciplina a) throws CampoVazioException, qtdAlunoDisciplinaMaxException  {
		    int codigo_turma;
	
		    if(qtdAluno_Disciplina(a.getCpf()) < 5) {
				aodc.inserirAluno_Disciplina(a);
				codigo_turma = aodc.pegarCodigoTurma(a.getCodigo());
				atc.inserirAluno_Turma(a.getCpf(),codigo_turma);
		    }else {
		    	throw new  qtdAlunoDisciplinaMaxException();
		    }

			
	}
	
	public boolean alunos_disciplina_turma(String turma) {
		String sql = "SELECT COUNT(*) as contador FROM aluno_oferta_disciplina JOIN disciplina ON aluno_oferta_disciplina.codigo = disciplina.codigo join turma on turma.codigo = disciplina.codigo_turma JOIN aluno_turma ON turma.codigo = aluno_turma.codigo WHERE aluno_oferta_disciplina.ativo = 'CURSANDO' AND turma.nome = " + turma;
	
		Conexao.getInstance().buscarSQL(sql);
		
		int cont = -1;
		try {
			while(Conexao.getInstance().getResultset().next()) {
			 cont = Integer.parseInt(Conexao.getInstance().getResultset().getString("contador"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
		
		if(cont == 0) {
			return true;
		}
		return false;
	}
	
	public void inativarTurma(String turma) throws TurmaExisteAlunoException {
		if(alunos_disciplina_turma(turma) == true) {
			tc.inativarTurma(turma);
		}else {
			throw new TurmaExisteAlunoException();
		}
	}
	
}
