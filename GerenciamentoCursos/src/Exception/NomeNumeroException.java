package Exception;

@SuppressWarnings("serial")
public class NomeNumeroException extends Exception{
	public String toString() {
		return "Nome Não Deve Conter Numeros Nem Ficar em Branco";
	}
}
