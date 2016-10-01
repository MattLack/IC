import java.util.Scanner;

public class Principal {
		
	
	public static void main(String[]args){
		
		Weblinking WebLink = new Weblinking();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o texto: ");
		
		String texto = teclado.nextLine();
		
		
		System.out.println("Resultado Weblinking: "+ WebLink.WebLinkingCalc(texto));
		
		System.out.println(WebLink.getCountSent());
		System.out.println(WebLink.getSenteces().toString());
		System.out.println(WebLink.getCountUrl());
		System.out.println(WebLink.getContainedUrls().toString());
		
		
		
	}

}
