import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Weblinking WebLink = new Weblinking();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o texto: ");

		String texto = teclado.nextLine();
		
		System.out.println("==============================================================================================================================================================================================================================================================================================================================================================================================================================================================");

		System.out.println("Resultado Weblinking: " + WebLink.WebLinkingCalc(texto));

		System.out.println("N�mero de senten�as: " + WebLink.getCountSent());
		System.out.println("As senten�as: \n" + WebLink.getSenteces().toString());
		System.out.println("N�mero de Url's: " + WebLink.getCountUrl());
		System.out.println("As Url's: \n" + WebLink.getContainedUrls().toString());
		
		System.out.println("==============================================================================================================================================================================================================================================================================================================================================================================================================================================================");
		
		System.out.println("Para efetuar o c�lculo do WeblinkQuality: \n"
				+ "preencha antes uma lista contendo as palavras-chave de refer�ncia para o f�rum, \n"
				+ "em seguida utilize o m�todo setBase e passe a lista como par�metro, \n"
				+ "depois � s� chamar o m�todo WeblinkQualityCalc passando o texto a ser analisado \n"
				+ "e o m�todo retornar� o resultado referente ao c�lculo.");

	}

}
