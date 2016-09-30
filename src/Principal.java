import java.util.Scanner;
import java.util.regex.Pattern;

public class Principal {
		
	
	public static void main(String[]args){
		
		Weblinking WebLink = new Weblinking();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o texto: ");
		
		String texto = teclado.nextLine();
		
		WebLink.WebLinkingCalc(texto);
		
		System.out.println(WebLink.getCountSent());
		System.out.println(WebLink.getSenteces().toString());
		System.out.println(WebLink.getCountUrl());
		System.out.println(WebLink.getContainedUrls().toString());
		
		System.out.println("Resultado Weblinkg: " + WebLink.CalcUrlDetection());
		
		
		
		
		String texto1 = "www.google.com.br/okok e estou tentando também nesse caso, google.com caso pegue vai ser legal.";
		String texto2 = "abcd. okok. estou testando isso aqui. na verdade estou testando.";
		
		
	}

}
