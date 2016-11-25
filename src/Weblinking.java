
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weblinking {

	private List<String> containedUrls = new ArrayList<String>();
	private List<String> sentences = new ArrayList<String>();
	private List<String> base = new ArrayList<String>();
	private int CountUrl;
	private int CountSent;
	private int CountWebPagein;

	public Weblinking() {

		clear();

	}

	private void clear() {

		this.containedUrls.clear();
		this.sentences.clear();
		this.base.clear();
		this.CountSent = 0;
		this.CountUrl = 0;
		this.CountWebPagein = 0;

	}

	// ======================= Gets&Sets =========================//

	public int getCountUrl() {
		return this.CountUrl;
	}

	public List<String> getBase() {
		return base;
	}

	public int getCountWebPagein() {
		return CountWebPagein;
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

	public void setBase(List<String> base) {
		this.base = base;
	}

	// ======================================================//

	private static void replaceAll(StringBuffer builder, String from, String to) {

		/**
		 * Dada uma string (builder), uma segunda string (form) ser� buscada
		 * dentro da anterior, e substituida por outra string (to)
		 */

		int index = builder.indexOf(from);
		while (index != -1) {
			builder.replace(index, index + from.length(), to);
			index += to.length();
			index = builder.indexOf(from, index);
		}
	}

	private static void replace(StringBuffer Alt1) {

		/**
		 * Subistitue .? sobrando no meio do texto para n�o atrapalhar na quebra
		 * de senten�as
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

	private void extractUrls(String text) {

		/**
		 * Uma estrutura textual que atrav�s de tamb�m operadores l�gicos,
		 * alimenta uma vari�vel, que por sua vez usa dos m�todos pattern e
		 * matcher para identificar e extrair textos que contenham a extrutura
		 * que foi inserida anteriormente. Estas urls s�o salvas e contadas para
		 * utiliza��o posteior
		 */

		String urlRegex = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
				+ "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";

		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
		Matcher urlMatcher = pattern.matcher(text);

		while (urlMatcher.find()) {
			this.containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
		}

		this.CountUrl = this.containedUrls.size();

	}

	private void CutSenteces(String text) {

		/**
		 * Recorta as strings dos hiperlinks do texto
		 */

		StringBuffer Alt1 = new StringBuffer(text);

		for (int j = 0; j < this.containedUrls.size(); j++) {
			replaceAll(Alt1, containedUrls.get(j), "");
		}

		/**
		 * chamada do m�todo replace
		 */

		replace(Alt1);

		/**
		 * Quebra o texto cortado em sente�as definidas por ponto
		 */

		String textCut = new String(Alt1);

		String Alt2[] = textCut.split(Pattern.quote("."));

		for (int i = 0; i < Alt2.length; i++) {
			this.sentences.add(Alt2[i]);
		}

		this.CountSent = this.sentences.size();

	}

	private double CalcUrlDetection() {

		/**
		 * M�todo que utiliza as v�riaveis globais devidamente atualizadas para
		 * efetuar a fun��o e retornar um valor double com o resultado
		 */

		/**
		 * Apenas foi considerado o fator Weblinkformat, pois o fator
		 * hiperlinked text considera apenas hiperlinks dentro de palavras do
		 * texto, o que na abordagem java utilizada se torna impratic�vel a
		 * an�lise
		 */

		Integer WeblinkFormat = 1;

		Float a = (float) this.getCountUrl();
		Float b = (float) this.getCountSent();

		Float result = ((a.floatValue() / b.floatValue()) * WeblinkFormat);

		return result;
	}

	public double WebLinkingCalc(String text) {
		
		/**
		 * Este m�todo compartilha m�todos com a abordagem WeblinkQualityCalc,
		 * por isso, para garantir a consist�ncia dos resultados � feita a
		 * limpeza das vari�veis globais logo no in�cio da execu��o.
		 */
		
		/**
		 * Caso haja necessidade de salvar os resultados referentes a uma execu��o
		 * do m�todo WeblinkQualityCalc que seja feita antes da execu��o deste m�todo,
		 * utilize os gets para salvar os dados anteriores.
		 */

		/**
		 * Feita a chamada dos m�todos extractUrls e CutSentences
		 * � chamado o m�todo CalcUrlDetection que � respons�vel pela fun��o a
		 * ser calculada.
		 * Retorna o resultado da fun��o WebLinking.
		 */
		
		clear();

		this.extractUrls(text);
		this.CutSenteces(text);

		return this.CalcUrlDetection();

	}

	public double WeblinkQualityCalc(String text) {
		
		/**
		 * Neste m�todo primeiro � feita a limpeza das vari�veis globais,
		 * � feita a extra��o das urls, e para cada url encontrada, � feita
		 * uma varredura da lista (base) contendo as palavras-chave de relev�ncia.
		 * Esta varredura � feita para em cada url para cada palavra-chave.
		 */
		
		/**
		 * � necess�rio haver preenchido a lista (base) antes de ser efetuada
		 * a chamada deste m�todo.
		 */
		
		/**
		 * Este m�todo compartilha m�todos com a abordagem WeblinkingCalc,
		 * por isso, para garantir a consist�ncia dos resultados � feita a
		 * limpeza das vari�veis globais logo no in�cio da execu��o.
		 */
		
		/**
		 * Caso haja necessidade de salvar os resultados referentes a uma execu��o
		 * do m�todo WeblinkingCalc que seja feita antes da execu��o deste m�todo,
		 * utilize os gets para salvar os dados anteriores.
		 */
		
		clear();
		this.extractUrls(text);

		int numb = base.size();
		int numc = containedUrls.size();

		for (int i = 0; i < numc; i++) {
			for (int j = 0; j < numb; j++)
				if (containedUrls.get(i).matches(base.get(j)))
					this.CountWebPagein = this.CountWebPagein + 1;
		}

		return CalcToWQ();

	}

	private double CalcToWQ() {

		/**
		 * M�todo que utiliza as v�riaveis globais devidamente atualizadas para
		 * efetuar a fun��o e retornar um valor double com o resultado
		 */

		Float a = (float) this.getCountWebPagein();
		Float b = (float) this.base.size();

		Float result = (a.floatValue() / b.floatValue());

		return result;
	}

}
