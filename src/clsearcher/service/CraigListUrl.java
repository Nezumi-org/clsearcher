package clsearcher.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**Represent the CraigList Url
 * Assumptions: The url structure tree grows this way:  
http://seattle.craigslist.org/sno/bab/
http://seattle.craigslist.org/sno/bab/index100.html
http://seattle.craigslist.org/sno/bab/index200.html
...
*/
public class CraigListUrl { 
    private String host = "http://seattle.craiglist.org/";
    private String path1;
    private String path2;
    private String fullPath;
    protected final Log logger = LogFactory.getLog(getClass());

    
   CraigListUrl(String path1, String path2){
	 	setPath1(path1);
    	setPath2(path2);
    	    
     }
    public String getFullPath(){
       return host + path1 + "/"+ path2+ "/";
       }
    public String getPath1(){
    	return path1;
    }
    //Todo; find if DI can be used  
    private void setPath1(String path){
    if (path.equalsIgnoreCase("Seattle"))
    		this.path1 = "see";
    	else if (path.equalsIgnoreCase("EastSide"))
    		this.path1 = "est";
    	else if (path.equalsIgnoreCase("Snohomish"))
    		this.path1= "sno";
    	else{
    		logger.info(" wrong path1 "+ path);
    		assert false:path; 
    		}
    }
   private void setPath2(String path){
  	 if (path.equalsIgnoreCase("Baby"))
   		this.path2 = "bab";
   	else if (path.equalsIgnoreCase("Toy"))
   		this.path2 = "tag";
   	else{
   		logger.info(" wrong path2 "+ path);
   		assert false:path; 
   	}
   }

}
