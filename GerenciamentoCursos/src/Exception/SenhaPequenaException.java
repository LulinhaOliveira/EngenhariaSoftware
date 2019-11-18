package Exception;

@SuppressWarnings("serial")
public class SenhaPequenaException extends Exception{
	public String toString() {
		return "Senha Deve Conter 6 ou Mais Caracteres e Não Deve Possuir Espaço";
	}
}
