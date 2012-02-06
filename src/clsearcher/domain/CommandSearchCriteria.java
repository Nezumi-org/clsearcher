package clsearcher.domain;
import java.io.Serializable;
import java.lang.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
*Command class to hold data from a form
*/
public class CommandSearchCriteria implements Serializable {
	
    private String [] regions;
    private String [] categories;
    private String searchWord;
    protected final Log logger = LogFactory.getLog(getClass());
    
    public String[] getRegions() {
        return regions;
    }
    public void setRegions(String[] regions) {
        this.regions = regions;
        logger.info("Leaving setRegions... " );
    }
    public String[] getCategories() {
        return categories;
    }
    public void setCategories(String[] categories) {
        this.categories = categories;
        logger.info("Leaving setCategorie... "+ this.categories );
    }
    public String getSearchWord(){
    	return searchWord;
    }
    public void setSearchWord(String searchWord){
    	this.searchWord = searchWord;
    }
      
}