import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Weblinking WebLink = new Weblinking();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o texto: ");

		String texto = teclado.nextLine();
		
		System.out.println("==============================================================================================================================================================================================================================================================================================================================================================================================================================================================");

		System.out.println("Resultado Weblinking: " + WebLink.WebLinkingCalc(texto));

		System.out.println("Número de sentenças: " + WebLink.getCountSent());
		System.out.println("As sentenças: \n" + WebLink.getSenteces().toString());
		System.out.println("Número de Url's: " + WebLink.getCountUrl());
		System.out.println("As Url's: \n" + WebLink.getContainedUrls().toString());
		
		System.out.println("==============================================================================================================================================================================================================================================================================================================================================================================================================================================================");


	}

}
