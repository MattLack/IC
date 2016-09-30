

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weblinking {
	
	private List<String> containedUrls = new ArrayList<String>();
	private List<String> sentences = new ArrayList<String>();
	private int CountUrl;
	private int CountSent;

	
	//======================= Gets =========================// 
	
	public int getCountUrl(){	
		return this.CountUrl;
	}
	
	public List<String> getContainedUrls(){
		return this.containedUrls;
	}
	
	public int getCountSent(){
		return this.CountSent;
	}
	
	public List<String> getSenteces(){
		return this.sentences;
	}
	
	//======================================================// 
		
	
	
	public void extractUrls(String text){
	    
	    String urlRegex = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";
	    
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);
	    

	    while (urlMatcher.find())
	    {
	        this.containedUrls.add(text.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }
	    
	    this.CountUrl = this.containedUrls.size();

	}
	
	
	public void CutSenteces(String text){
		
		String Alt[] = text.split(Pattern.quote("."));
		
		for (int i = 0; i < Alt.length; i++) {
			this.sentences.add(Alt[i]);
		}
	    
	    this.CountSent = this.sentences.size();
		
	}
	
	
	
	public double CalcUrlDetection(){
		
		int WeblinkFormat = 1;
		
		double result = ( this.CountUrl / this.CountSent  ) * WeblinkFormat;
		
		return result;
	}
	
	
	
	public double WebLinkingCalc(String text){
		
		this.extractUrls(text);
		this.CutSenteces(text);
		
		return this.CalcUrlDetection();
		
	}
	

}
