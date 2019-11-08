package Exception;

@SuppressWarnings("serial")
public class SenhaErradaException extends Exception{

	public String toString() {
		return "Senha Não Confere";
	}
}
