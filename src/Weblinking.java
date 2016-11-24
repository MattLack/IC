
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weblinking {

	private List<String> containedUrls = new ArrayList<String>();
	private List<String> sentences = new ArrayList<String>();
	private int CountUrl;
	private int CountSent;

	// ======================= Gets =========================//

	public int getCountUrl() {
		return this.CountUrl;
	}

	public List<String> getContainedUrls() {
		return this.containedUrls;
	}

	public int getCountSent() {
		return this.CountSent;
	}

	public List<String> getSenteces() {
		return this.sentences;
	}

	// ======================================================//

	public static void replaceAll(StringBuffer builder, String from, String to) {

		int index = builder.indexOf(from);
		while (index != -1) {
			builder.replace(index, index + from.length(), to);
			index += to.length();
			index = builder.indexOf(from, index);
		}
	}
	
	
	public static void replace(StringBuffer Alt1) {

		/**
		 * Subistitue .? sobrando no meio do texto para não atrapalhar na quebra de
		 * sentenças
		 */
		
		replaceAll(Alt1, "...", "");
		replaceAll(Alt1, ".a", "#a");
		replaceAll(Alt1, ".b", "#b");
		replaceAll(Alt1, ".c", "#c");
		replaceAll(Alt1, ".d", "#d");
		replaceAll(Alt1, ".e", "#e");
		replaceAll(Alt1, ".f", "#f");
		replaceAll(Alt1, ".g", "#g");
		replaceAll(Alt1, ".h", "#h");
		replaceAll(Alt1, ".i", "#i");
		replaceAll(Alt1, ".j", "#j");
		replaceAll(Alt1, ".k", "#k");
		replaceAll(Alt1, ".l", "#l");
		replaceAll(Alt1, ".m", "#m");
		replaceAll(Alt1, ".n", "#n");
		replaceAll(Alt1, ".o", "#o");
		replaceAll(Alt1, ".p", "#p");
		replaceAll(Alt1, ".q", "#q");
		replaceAll(Alt1, ".r", "#r");
		replaceAll(Alt1, ".s", "#s");
		replaceAll(Alt1, ".t", "#t");
		replaceAll(Alt1, ".u", "#u");
		replaceAll(Alt1, ".v", "#v");
		replaceAll(Alt1, ".w", "#w");
		replaceAll(Alt1, ".x", "#x");
		replaceAll(Alt1, ".y", "#y");
		replaceAll(Alt1, ".z", "#z");

	}
	

	public void extractUrls(String text) {

		String urlRegex = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
				+ "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";

		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
		Matcher urlMatcher = pattern.matcher(text);

		while (urlMatcher.find()) {
			this.containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
		}

		this.CountUrl = this.containedUrls.size();

	}

	public void CutSenteces(String text) {

		// Recorta as strings dos hiperlinks do texto

		StringBuffer Alt1 = new StringBuffer(text);

		for (int j = 0; j < this.containedUrls.size(); j++) {
			this.replaceAll(Alt1, containedUrls.get(j), "");
		}

		// Recorta as reticencias do texto

		this.replace(Alt1);

		this.replaceAll(Alt1, ".com", "(ponto)com");

		/**
		 * Quebra o texto cortado em senteças definidas por ponto
		 */

		String textCut = new String(Alt1);

		String Alt2[] = textCut.split(Pattern.quote("."));

		for (int i = 0; i < Alt2.length; i++) {
			this.sentences.add(Alt2[i]);
		}

		this.CountSent = this.sentences.size();

	}

	
	public double CalcUrlDetection() {
		
		/**
		 * Método que utiliza as váriaveis globais devidamente atualizadas
		 * para efetuar a função e retornar um valor double com o resultado
		 */
		
		/**
		 * Apenas foi considerado o fator Weblinkformat,  
		 */

		Integer WeblinkFormat = 1;

		Float a = (float) this.getCountUrl();
		Float b = (float) this.getCountSent();

		Float result = ((a.floatValue() / b.floatValue()) * WeblinkFormat);

		return result;
	}
	
	

	public double WebLinkingCalc(String text) {
		
		/**
		 * Retorna o resultado da função WebLinking
		 */
		
		this.extractUrls(text);
		this.CutSenteces(text);

		return this.CalcUrlDetection();

	}

	

	

}
