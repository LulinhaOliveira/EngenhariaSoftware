package Negocio.Fachada;

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


	




}
