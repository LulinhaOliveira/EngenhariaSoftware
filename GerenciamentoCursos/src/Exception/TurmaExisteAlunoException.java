package Exception;

@SuppressWarnings("serial")
public class TurmaExisteAlunoException  extends Exception{

	public String toString() {
		return "Ainda Há Alunos na Turma";
	}
}
