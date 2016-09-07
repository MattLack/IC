

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlDetection {
	
	public List<String> containedUrls = new ArrayList<String>();
	public int CountUrl;
	
	
	//======================= Sets =========================// 
	
	
	
	
	
	//======================================================// 

	
	//======================= Gets =========================// 
	
	public int getCountUrl(){	
		return this.CountUrl;
	}
	
	public List<String> getContainedUrls(){
		return this.containedUrls;
	}
	
	//======================================================// 
	

	public static void main(String[] args) {
		
		
		System.out.println(extractUrls("Welcome to ftp://www.stackoverflow.com and here is another link https://www.google.com/ \n which is a great search engine"));
		System.out.println();

	}
		
	
	/**
	 * Returns a list with all links contained in the input
	 */
	public static List<String> extractUrls(String text)
	{
	    List<String> containedUrls = new ArrayList<String>();
	    String urlRegex = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";
	    
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);
	    

	    while (urlMatcher.find())
	    {
	        containedUrls.add(text.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }

	    return containedUrls;
	}
	
	

}
