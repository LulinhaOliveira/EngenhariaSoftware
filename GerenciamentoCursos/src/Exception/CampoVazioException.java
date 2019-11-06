package Exception;

@SuppressWarnings("serial")
public class CampoVazioException extends Exception{

	public String toString(String campo) {
		return campo + "Vazio";	
	}
}
