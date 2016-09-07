

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlDetection {
	
	private  List<String> containedUrls = new ArrayList<String>();
	private int CountUrl;

	
	//======================= Gets =========================// 
	
	public int getCountUrl(){	
		return this.CountUrl;
	}
	
	public List<String> getContainedUrls(){
		return this.containedUrls;
	}
	
	//======================================================// 
		
	
	/**
	 * Returns a list with all links contained in the input
	 * @return 
	 */
	public void extractUrls(String text){
	    //List<String> containedUrls = new ArrayList<String>();
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
	
	//teste
	

}
